 Check for errors + debug code and abort if something isn't right
# 1 = ON
# 0 = OFF
DEBUG=0

# DEBUG mode
if [ $DEBUG -eq 1 ]
then
    set -e
    set -x
else
    sleep 1
fi

ask_yes_or_no() {
    read -r -p "$1 ([y]es or [N]o): "
    case ${REPLY,,} in
        y|yes)
            echo "yes"
        ;;
        *)
            echo "no"
        ;;
    esac
}

# Install letsencrypt
apt update -q2
apt upgrade -y
letsencrypt --version 2> /dev/null
LE_IS_AVAILABLE=$?
if [ $LE_IS_AVAILABLE -eq 0 ]
then
    certbot --version
else
    echo "Installing letsencrypt..."
    add-apt-repository ppa:certbot/certbot -y
    apt update -q4
    apt install letsencrypt -y -q
    apt update -q4
    apt dist-upgrade -y
fi

# Lets Encrypt standalone (webroot doesn't work at first)
echo "Generating standalone SSL certificate..."
certbot certonly \
--standalone \
--pre-hook 'service nginx stop' --post-hook 'service nginx start' \
--rsa-key-size 4096 \
--renew-by-default --email $EMAIL \
--text \
--agree-tos \
-d $URL
if [[ $? -eq 0 ]]
then
	echo "Let's Encrypt standalone SUCCESS!"
else
	echo "Let's Encypt standalone failed"
	# bash $SCRIPTS/remove_domain.sh
	rm /etc/nginx/sites-enabled/$DOMAIN.conf
	service nginx start
	exit 1
fi

# Let's Encrypt webroot
echo "Generating webroot SSL certificate..."
certbot certonly \
--webroot --webroot-path /usr/share/nginx/html/ \
--rsa-key-size 4096 \
--renew-by-default --email $EMAIL \
--text \
--agree-tos \
-d $URL
if [[ $? -eq 0 ]]
then
	echo "Let's Encrypt webroot SUCCESS"
else
	echo "Let's Encypt webroot failed"
	exit 1
fi