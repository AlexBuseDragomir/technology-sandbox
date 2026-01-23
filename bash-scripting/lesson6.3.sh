#! /bin/bash

directory=/etc

if [ -d $directory ]
then
        echo $?
	echo "The directory $directory exists."
else
	echo $?
	echo "The directory $directory does not exist."
fi

echo "The exit code for this script run is $?"


# Exiting 1 even when something succeeds
echo "Hello world"
exit 1
echo $?

# Exiting 0 even when something fails
sudo apt install notexist
exit 0
echo $?
