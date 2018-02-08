# BASH Profile

## Why

For making the MAC OS terminal experience better.

## How to add the settings

* Create a file .bash_profile in the users home directory ~
* Copy paste below code to the new file
* Restart MAC terminal for the changes to be visible

```sh
#!/bin/bash

#  ---------------------------------------------------------------------------
#
#  Description:  This file holds all my BASH configurations and aliases
#
#  Sections:
#  1.  Environment Configuration
#  2.  Make Terminal Better 
#  3.  Adding alias
#
#  ---------------------------------------------------------------------------

#   -------------------------------
#   1. ENVIRONMENT CONFIGURATION
#   -------------------------------

#   Set home path for sonarqube scanner installatiom
#   ------------------------------------------------------------
export SONAR_SCANNER_HOME=/Users/allanselvan/tools/sonarqube-scanner/sonar-scanner-3.0.3.778

#   Set Paths
#   ------------------------------------------------------------
export PATH=$PATH:$SONAR_SCANNER_HOME/bin

#   -----------------------------
#   2. MAKE TERMINAL BETTER
#   -----------------------------

export PS1="\[\033[36m\]\u\[\033[m\]@\[\033[32m\]\h:\[\033[33;1m\]\w\[\033[m\]\$ "
export CLICOLOR=1
export LSCOLORS=ExFxBxDxCxegedabagacad

if [ -f $(brew --prefix)/etc/bash_completion ]; then
. $(brew --prefix)/etc/bash_completion
fi 


#   -----------------------------
#   2. ADDING ALIAS
#   -----------------------------

alias cp='cp -iv'                           # Preferred 'cp' implementation
alias mv='mv -iv'                           # Preferred 'mv' implementation
alias mkdir='mkdir -pv'                     # Preferred 'mkdir' implementation
alias ll='ls -lrt'                          # Preferred 'll' implementation
alias ls='ls -GFh'                          # Preferred 'ls' implementation
alias cd..='cd ../'                         # Go back 1 directory level (for fast typers)
alias ..='cd ../'                           # Go back 1 directory level
alias ...='cd ../../'                       # Go back 2 directory levels
alias .3='cd ../../../'                     # Go back 3 directory levels
alias .4='cd ../../../../'                  # Go back 4 directory levels
alias .5='cd ../../../../../'               # Go back 5 directory levels
alias .6='cd ../../../../../../'            # Go back 6 directory levels
alias f='open -a Finder ./'                 # f:            Opens current directory in MacOS Finder
alias path='echo -e ${PATH//:/\\n}'         # path:         Echo all executable Paths
trash () { command mv "$@" ~/.Trash ; }     # trash:        Moves a file to the MacOS trash

#   lr:  Full Recursive Directory Listing
#   ------------------------------------------
alias lr='ls -R | grep ":$" | sed -e '\''s/:$//'\'' -e '\''s/[^-][^\/]*\//--/g'\'' -e '\''s/^/   /'\'' -e '\''s/-/|/'\'' | less'

#   ------------------------------------------
#   EOF
#   ------------------------------------------
```