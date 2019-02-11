
import objectdraw.*;

import java.awt.*;


/**
 * the MazeCell is the element of Maze, it acts as a storage for a upperleft
 * location, and it knows if it is occupied.
 */
public class MazeCell {

  private int column, row;
  private Location upperLeftLoc;

  private boolean wall, visited, startPoint, endPoint;
  private DrawingCanvas canvas;
  private MazeCell previous;


  public MazeCell(int column, int row, Location loc, DrawingCanvas canvas) {
    this.column = column;
    this.row = row;
    this.upperLeftLoc = loc;
    this.canvas = canvas;

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

  public boolean isVisited() {
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
    FilledRect f = new FilledRect(upperLeftLoc.getX() + 1,
      upperLeftLoc.getY() + 1, Constants.GRID_CELL_SIZE - 1,
      Constants.GRID_CELL_SIZE - 1, canvas);
    f.setColor(Color.ORANGE);
  }

  public void setWall(boolean wall) {

    this.wall = wall;
    FilledRect f = new FilledRect(upperLeftLoc.getX() + 1,
      upperLeftLoc.getY() + 1,
      Constants.GRID_CELL_SIZE - 1,
      Constants.GRID_CELL_SIZE - 1, canvas);
    f.setColor(Color.pink);

  }

  public void setStartPoint(boolean startPoint) {
    this.startPoint = startPoint;
    FilledRect f = new FilledRect(upperLeftLoc.getX() + 1,
      upperLeftLoc.getY() + 1, Constants.GRID_CELL_SIZE - 1,
      Constants.GRID_CELL_SIZE - 1, canvas);
    f.setColor(new Color(107, 255, 106));

  }

  public void setVisited(boolean visited) {
    this.visited = visited;

    /**FilledRect f = new FilledRect(upperLeftLoc.getX() + 1,
     upperLeftLoc.getY() + 1, Constants.GRID_CELL_SIZE - 1,
     Constants.GRID_CELL_SIZE - 1, canvas);
     f.setColor(new Color(107, 255, 106)); // special green color**/
  }

  public void setPrevious(MazeCell m) {

    this.previous = m;

  }

  public void setPath() {
    if (!(this.isEndPoint() || this.isStartPoint())) {
      FilledRect f = new FilledRect(upperLeftLoc.getX() + 1,
        upperLeftLoc.getY() + 1, Constants.GRID_CELL_SIZE - 1,
        Constants.GRID_CELL_SIZE - 1, canvas);

      f.setColor(Color.RED);
    }

  }

  public MazeCell getPrevious() {
    return previous;
  }
}

