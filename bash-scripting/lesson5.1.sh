#! /bin/bash

myNum=200

if [ $myNum -eq 200 ]
then
	echo "The condition is true."
fi


myNum=300

if [ $myNum -eq 200 ]
then
	echo "The condition is not true."
fi


if [ $myNum -eq 200 ]
then
        echo "The condition is true."
else
	echo "The variable does not equal 200."
fi


if [ ! $myNum -eq 200 ]
then
        echo "The condition is true."
else
        echo "The variable does not equal 200."
fi


if [ $myNum -ne 200 ]
then
        echo "The condition is true."
else
        echo "The variable does not equal 200."
fi


if [ $myNum -gt 200 ]
then
        echo "The condition is true."
else
        echo "The condition is false."
fi
