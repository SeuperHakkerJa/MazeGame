/*
 * Filename: MazeCell.java
 * Author:   Xiaochen Li
 * UserId:   cs11fayl
 * Date:     11/21/2018
 * Sources of help: None
 */

import objectdraw.*;


/**
 * the MazeCell is the element of Maze, it acts as a storage for a upperleft
 * location, and it knows if it is occupied.
 */
public class MazeCell {

  private int column, row;
  private Location upperLeftLoc;

  private boolean wall, visited, startPoint, endPoint;


  public MazeCell(int column, int row, Location loc) {
    this.column = column;
    this.row = row;
    this.upperLeftLoc = loc;
  }



  public int getColumn() {
    return column;
  }

  public int getRow() {
    return row;
  }

  public boolean isWall() {
    return wall;
  }

  public boolean isVisited(){
    return visited;
  }

  public boolean isEndPoint() {
    return endPoint;
  }

  public boolean isStartPoint() {
    return startPoint;
  }

  public void setEndPoint(boolean endPoint) {
    this.endPoint = endPoint;
  }
  public void setWall(boolean wall){
    this.wall = wall;
  }

  public void setStartPoint(boolean startPoint) {
    this.startPoint = startPoint;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }
}

