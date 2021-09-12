__author__ = "Black"

import os, sys, time

noFileName = True
noSearchString = True
count = 0
while noFileName: # Check for invalid inputs and exit after 5 invalids
    if count > 4:
        count = 0
        print("Too many wrong file names/Empty inputs, quitting...",end=' ')
        for i in range(3):
            time.wait(1)
            print(i)
        sys.exit()
    file_name = input("File Name >>> ") # Name of the file to be read
    exists = os.path.exists(file_name)

    if not exists:
        count += 1
        print("File does not exist or no input given, make sure to enter a correct file name. \t also check if you're in the correct working directory")
        continue
    else:
        noFileName = False

while noSearchString: # Check for invalid inputs and exit after 5 invalids
    if count > 4:
        count = 0
        print("Too many empty inputs detected, quitting...", end=' ')
        for i in range(3):
            time.wait(1)
            print(i)
        sys.exit()
    string = input("String to search >>> ") # Where to store the content to be searched
    if not string:
        count += 1
        print("No input detected, kindly try again")
        continue
    else:
        noSearchString = False

new_file = f'tmp_{file_name}' # Title of temp file to be created
clause = "" # Variable to store the read date

file = open(file_name, "r") # Open Original file in read mode
try:
    tmp_file = open(new_file, 'x') # Create and open temp file in write mode
except:
    tmp_file = open(new_file, 'w+') # Open file if it already exists

def save(file_name, content):
    with open(file_name, 'a') as file:
        f.save()

for line in file.readlines(): # Mainloop
    chars = line # Move to next line of file
    if chars != '': # if the line is not empty, add it to clause
        clause += (chars+"\n")
    if chars == '': # Check if the read line is empty
        contains = clause.search(string) # Bolean variable for wether it contians the search string or not
        if contains: # Continue the loop if it does
            clause = "" # Empty the clause varaible if the search returns true

        else: # If it doesn't, write the clause into the temp file and continue the loop
            tmp_file.writelines(clause)
            tmp_file.writeline("")
            clause = "" # Reset the contents of the clause variable

tmp_file.read()
file.close()
tmp_file.close() # Close the created file
