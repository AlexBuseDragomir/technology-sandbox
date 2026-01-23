#! /bin/bash

if [ -f ~/Documents/scripts/lesson5.1.sh ]
then
        echo "The file exists."
else
        echo "The file does not exist."
fi


command=/usr/bin/htop

if [ -f $command ]
then
        echo "$command is available, let's run it..."
else
        echo "$command is NOT available, installing it..."
        sudo apt update && sudo apt install -y htop
fi

$command


programName=htop

if command -v $programName
then
        echo "$command is available, let's run it..."
else
        echo "$command is NOT available, installing it..."
        sudo apt update && sudo apt install -y $programName
fi

$programName
