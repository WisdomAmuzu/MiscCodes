__author__ = "Black"

"""
Python Script to delete entries in a text file
with an empty line as delimeter. Can be tweaked
to modify text files using any conditions.
"""

import os
import sys
import time

noFileName = True
noSearchString = True
count = 0
while noFileName:  # Check for invalid inputs and exit after 5 invalids
    if count > 4:
        count = 0
        print("Too many wrong file names/Empty inputs, quitting...", end=' ')
        for i in range(3):
            time.wait(1)
            print(i)
        sys.exit()
    file_name = input("File Name >>> ")  # Name of the file to be read
    exists = os.path.exists(file_name)

    if not exists:
        count += 1
        print("File does not exist or no input given, make sure to enter a correct file name.")
        continue
    else:
        noFileName = False

while noSearchString:  # Check for invalid inputs and exit after 5 invalids
    if count > 4:
        count = 0
        print("Too many empty inputs detected, quitting...", end=' ')
        for i in range(3):
            time.wait(1)
            print(i)
        sys.exit()
    # Where to store the content to be searched
    string = input("String to search >>> ")
    if not string:
        count += 1
        print("No input detected, kindly try again")
        continue
    else:
        noSearchString = False

new_file = f'tmp_{file_name}'  # Title of temp file to be created
clause = ""  # Variable to store the read date

file = open(file_name, "r")  # Open Original file in read mode
tmp_file = open(new_file, 'w')  # Open temp file in write mode, Create it if it doesn't exist

while True:
    count = 0
    for line in file.readlines():  # Mainloop
        count += 1
        chars = line  # Move to next line of file
        if chars != '':  # if the line is not empty, add it to clause
            clause += (chars+"\n")
            continue
        else:  # Empty line encountered
            if count == 1:
                break
            # Bolean variable for wether it contians the search string or not
            contains = clause.search(string)
            if contains:  # Continue the loop if it does
                clause = ""  # Empty the clause varaible if the search returns true
                continue
            else:  # If it doesn't, write the clause into the temp file and continue the loop
                tmp_file.writelines(clause)
                tmp_file.writeline("")
                clause = ""  # Reset the contents of the clause variable

file.close()
tmp_file.close()  # Close the created file
