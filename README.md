# MazeGame 
* Automatically find the shortest path of costimized maze from users.
* This game is inspired by a PA related to Queue by Professor Joe Politz and a Snake Game PA by Professor Rick Ord.

## SET UP
User may start the Maze Game by make command. Type the following command in your terminal windows<br>
```
make maze
```
or
```
javac -cp ./Acme.jar:./objectdraw.jar:. *.java
java -cp ./Acme.jar:./objectdraw.jar:. Main
```
These compiles and run the Maze Game.

## Game Instructions
1. Click on set Start Button on the right side, then choose any maze cell and click as a start point. Once the start point set, the button is going to be disabled.
2. Click on set Wall Button on the right side, then choose as many maze cells you want and click to be the obstacles or walls. 
3. Click on set End Button on the left side, then choose any one maze cell to be the end point. Once the start point set, the button is going to be disabled.
* The first three steps are in recommended order, you dont need to follow them strictly.
4. Click the solve buttons on the bottom panel. Once clicked, no more modification are allowed.
5. Click on the next step, the path is going to be in red color.

## MISC
```
make clean
```
This make command deleted all the .class file
