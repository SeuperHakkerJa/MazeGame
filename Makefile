maze:
	@javac -cp ./Acme.jar:./objectdraw.jar:. *.java
	@java -cp ./Acme.jar:./objectdraw.jar:. Main

clean:
	@rm -r *.class
