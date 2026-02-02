#!/bin/bash

release_file=/etc/os-release

if grep -q "Arch" $release_file
then
        # The host uses Arch, 
	# Run the pacman update command
        sudo pacman -Syu
fi

if grep -q "Pop" $release_file 
	|| grep -q "Ubuntu" $release_file
then
        # The host uses Ubuntu or Pop,
        # Run the apt version of the command
        sudo apt update
        sudo apt dist-upgrade
fi
