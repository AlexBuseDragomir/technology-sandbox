#!/bin/bash


package=htop

apt install $package

echo "The exit code for the package install is: $?"


package=htop

sudo apt install $package

if [ $? -eq 0 ]
then
	echo "The installation of $package was successful."
	echo "The new command is available here:"
	which $package
else
	echo "$package failed to install."
fi
