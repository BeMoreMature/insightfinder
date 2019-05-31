# insightfinder
* What we would like you to implement (in Java) is the following:
Write a program that reads N messages from M input files. These input messages can contain any characters but you can assume each message can be delimited by the newline (\n) character. You can also assume the messages will all fit in memory. 

Once the reading of the input is complete, create a command line interface for the user which allows them to search for different words existing in the messages. When a word is found in a message, display the matching message. Display any matching words in uppercase. Allow the user to enter -1 to exit the program. 

When the program terminates, display a summary containing the number of searches performed along with the number of words matched across ALL input files. You can also include other summary information if you would like.

* Please complete this task and send me:
1. A zipped file that includes source code. Please do NOT include any binaries.
2. Simple instructions on how we should compile and run your code
3. A simple explanation on the design of your code
4. A list of third-party libraries used if there is any

* Bonus point:
In the assignment, we assume that the memory is big enough to store the entire message. Describe a solution that does not depend on this assumption on paper.

# Solution
all the data that I created are under the data folder
all the code in the src/main/java folder

There are three methods in the class readMessage.java

* readMessage
This function is used to read all the messages line by line in the data folder
Output all the messages

* findWords
First step in this function is getting the input word
Second step is iterate all the messages
Third step, if we find the matched word, convert word to uppercase and print, at the same time, keep the search information into logs

* printLogs
print all the logs

## When you run the program, you can see 
```
All the messages in the input files are as followed: 
File 1
information in file 1
File 2
information in file 2
...

```
## Then, each time you input the word, you can see the matched message on the console
```
word
matched messages
```
## Finally, when you input "-1", show the logs of all your searching records
```
Total number of searches is XXX
Number XXX search word is XXX, the number of matched words is XXX
```