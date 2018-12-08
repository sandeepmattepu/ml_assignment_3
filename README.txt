This project compilation and running is dependent on Apache-Ant. If it is not present in your OS please follow instructions from
http://ant.apache.org/manual/install.html

1) Navigate the terminal to the location of the project. You should see "build.xml" file when you type ls command
2) Now type "ant jar" in command line and hit enter. It should create jar file inside build folder which is created at current location of the terminal.
3) Navigate the terminal from current location to "build/jar/". You should see "Main.jar" file when you type ls command.
4) To execute the program type "java -jar Main.jar locationOfData locationToSave". Example:-
	java -jar Main.jar ~/Desktop/perceptron/Example.tsv ~/Desktop/Solution.tsv
5) [Optional] To run fixed number of iterations give last argument as number of iterations. Example:-
	java -jar Main.jar ~/Desktop/perceptron/Example.tsv ~/Desktop/Solution.tsv 10
6) Above command prints for 11 iterations(including iteration 0).