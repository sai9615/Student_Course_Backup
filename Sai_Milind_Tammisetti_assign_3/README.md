# CSX42: Assignment 3
## Name: Sai Milind Tammisetti

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
The project implements the observer design pattern. There are two interfaces named as observer and subject. The observer consist of the update method and the subject interface consists the notifyAll and registerObs methods. So first we create the original node by reading the input from the file. If the node (bnumber) doesn't exsist in the tree then we create a new node and also create two backup nodes for the original node and then add them to their respective trees. I have created an arraylist of trees in treeBuilder.java to store the original node and the two backup nodes into three different trees. Now if we create a new node then we create two clones of that new node by calling the clone method, which will act as our backup nodes. After that we call registerObs method by using our original node to register the two cloned nodes as the backup nodes (observers) for our new node (subject). 

Now if the node (bnumber) already exsists in the tree then we call the update method to update the orignal node as well as to notify all (by calling notifyAll method) the observers (backup nodes) about the update and update them. Here I have made use of enum value to check whether the update operation is to delete the course or to insert a new course.  

I have used a binary search tree and the base code for the tree has been borrowed from the following website: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/ . The worst case time complexity for insertion and search of node is O(h) where h is the height of the binary search tree.    

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: 7/09/2019 


