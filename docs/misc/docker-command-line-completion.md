Install command completion
Bash
Make sure bash completion is installed.

On a current Linux OS (in a non-minimal installation), bash completion should be available.

On a Mac, install with brew install bash-completion.

Place the completion script in /etc/bash_completion.d/ (or /usr/local/etc/bash_completion.d/ on a Mac):

sudo curl -L https://raw.githubusercontent.com/docker/compose/1.17.0/contrib/completion/bash/docker-compose -o /etc/bash_completion.d/docker-compose
On a Mac, add the following to your ~/.bash_profile:

if [ -f $(brew --prefix)/etc/bash_completion ]; then
. $(brew --prefix)/etc/bash_completion
fi