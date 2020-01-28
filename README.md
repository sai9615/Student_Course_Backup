## Backup System for Student Course Assignments

-----------------------------------------------------------------------
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=<input.txt> -Darg1=<delete.txt> -Darg2=<output1.txt> -Darg3=<output2.txt> -Darg4=<output3.txt> -Darg5=<logger-value> 

Example:

The last argument is the Logger value. 

ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt -Darg5=4

-----------------------------------------------------------------------
## Description: 
The code perfroms the following tasks:

* Reads the command line arguments.
* Builds three trees, based on input.txt and the observer pattern.
* Applies updates according to delete.txt
* Creates a new Results instance and call printNodes(...) on each of the three trees to store the BNumber and list of courses to store in Results. So, each of the three trees will use a different instance of Results.
* Calls a method in Results, via the method in FileDisplayInterface, to write the data stored in Results to output1.txt, output2.txt, and output3.txt, for the three trees.
* When read an input file, it tries to insert the course into the main tree corresponding to the node that has the BNumber. If a node with the BNumber exists, then update that node in the main tree, notifyAll(...) to the two corresponding listener nodes. If no such node with that BNumber exists in the main tree, then it performs the following tasks:
	* create a Node (lets call it new node) with that BNumber and course.
	* clones the new node twice.
	* setup the two cloned nodes as listeners of the new node (add their references to the listeners list in the new node).
	* inserts the node in the main tree (using recursive insert from the root).
	* inserts the two cloned nodes in the backup trees similarly (recursively from the root)
* notifyAll(...) is being used for processing delete.txt and also when we need to add a course to an existing BNumber from the input.txt list. So, I have added an enum as a parameter to the notifyAll(...) to indicate whether the notifyAll(...) call, which calls update(...) on the listener nodes, is for insert or delete.
 
-----------------------------------------------------------------------



