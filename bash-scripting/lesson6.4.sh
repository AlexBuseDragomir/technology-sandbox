#! /bin/bash

directory=/etc

if [ -d $directory ]
then
	echo "The directory $directory exists."
	exit 0
else 
	echo "The directory $directory does not exist."
	exit 1
fi

echo "The exit code for this script run is: $?"
echo "You did not see that statement."
echo "You will not see this one either."


directory=/non-existing

if [ -d $directory ]
then
        echo "The directory $directory exists."
        exit 0
else
        echo "The directory $directory does not exist."
        exit 1
fi

echo "The exit code for this script run is: $?"
echo "You did not see that statement."
echo "You will not see this one either."
