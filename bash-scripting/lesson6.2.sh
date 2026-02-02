#!/bin/bash

package=not_available

sudo apt install $package >> package_install_results.log 2>&1

if [ $? -eq 0 ]
then
        echo "The installation of $package was successful."
        echo "The new command is available here:"
        which $package
else
        echo "$package failed to install." >> package_install_failure.log
fi
