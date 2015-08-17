# CommandInterpreter

VMware Talent Boost Class

This task was given in the proccess of VMware Talent Boost Class course. It is devided in 3 parts (Task 1, Task 1.2 and Task 1.3)

#*Task 1*
Develope a simple command interpreter with the following properties:

The interpreter takes commands from the standart input. The commands that will be currently supported are the following:

- reverse 
- count-words
- reverse-words

The **"reverse"** command has the following syntax:
reverse  <`string`>
It reverse the letters in the provided string. For example

	input: reverse abra cadabra
	output: arbadac arba

The **"count-words"** command has the following syntax:
  count-words  <`string`>
It returns the number of words in the provided string. For example

	input: count-words abra cadabra
	output: 2

The **"reverse-words"** command has the following syntax:
reverse-wrods <`string`>
It reverse the order of the words in the provided string. For example

	input: count-words abra cadabra
	output: cadabra abra

#*Task 1.2*
Extend the commands to supported the following commands:
	get
	set
	calc
	
**The "get" command** has the following syntax:
get <`variable`>

It obtain the value of the given variable and prints it out in the format:
[<`type`>]<`value`>
*(please see the example at the end.)*

**The "set" command** has the following syntax:
set <`variable`> <`type`><`value`>

The command create a value of the given type and stores it in the given variable.

The output of the command is the string **"Ok"**.

**The "calc" command** has the following syntax:
calc  <`variable1`> <`variable2`> <`operation`> <`variable3`>

The command performs a simplistic operation between variable2 and variable3 and stores the result in variable1. The supported operations are listed below.

The output of the command is the string **"Ok"**.


In all cases if an error occurs during the execution of the command (for example there is no such variable or the value type does not support the operation), the string **"Err"** is printed instead of the normal output.

The possible **types of the values** are the following:
	String
	Number

The textual representation of the values (e.g their input format for the "set" command or the output format for the "get" command) is the same as supported by Java.

The operations supported by these types are the following:
	
- string

		+ <string> concatenates the two strings
		
		+ <`number`> add the number as a string to the end
		
		* <`number`> repeats the string a <`number`> times
		
- number

		+ <`number`> add the two numbers
		
		- <`number`> subtracts the two numbers
		
		* <`number`> multiplies the two numbers
		
- date

		+ <`number`> adds a <`number`> of days
