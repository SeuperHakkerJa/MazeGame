/*
 * Filename: GridCell.java
 * Author:   Xiaochen Li
 * UserId:   cs11fayl
 * Date:     11/21/2018
 * Sources of help: None
 */

import objectdraw.*;

import java.awt.*;


/**
 * the GridCell is the element of Grid, it acts as a storage for a upperleft
 * location, and it knows if it is occupied.
 */
public class GridCell {

  private int columns, rows;
  private Location upperLeftLoc;

  // initially empty
  private boolean noFruit = true, noBody = true;

  // a reference to fruitloop it stores.
  private FruitLoop fruitLoop;
  private SnakeSegment sagment;


  /**
   * the Constructor of the Grid takes in the grid it is in, its col/row info
   * and a real location.
   */
  public GridCell(int columns, int rows, Location loc, Grid grid) {
    this.columns = columns;
    this.rows = rows;
    this.upperLeftLoc = loc;
  }

  /**
   * This method returns the column information of the cell.
   *
   * @return a integer number that indicates the column index
   */
  public int getColumns() {

    return columns;
  }


  /**
   * This methhod returns the rows information of the cell.
   *
   * @return a integer number that indicates the row index.
   */
  public int getRows() {

    return rows;

  }


  /**
   * this method the exact location in pixels.
   *
   * @return the upperleft location in the gridcell.
   */
  public Location getLocation() {
    return this.upperLeftLoc;
  }

  /**
   * this method indicates whether the cell is empty
   *
   * @return boolean of both no fruit and nobody, indicating no objects is in
   * the cell.
   */
  public boolean isEmpty() {

    return noFruit && noBody;

  }


  /**
   * this method inserts fruit into the gridcell
   *
   * @param color the color the fruit loops is in
   * @param canvas where the fruitLoop is going to be drew.
   */
  public void insertFruit(Color color, DrawingCanvas canvas) {

    // creating fruit loops
    fruitLoop = new FruitLoop(this, color, canvas);
    // update the gridcell's boolean indicating it is occupied.
    noFruit = false;
  }


  /**
   * this method inserts snake body into the gridcell, it is used to
   * construct the first snake body.
   *
   * @param canvas the place where the sagment is drew.
   */
  public void insertSnakeSegment(DrawingCanvas canvas) {

    // construct the snake body.
    sagment = new SnakeSegment(this, canvas);
    noBody = false;
  }


  /**
   * this method indicating whether there is snake in the gridcell.
   *
   * @return the status signifying if snakes body inside.
   */
  public boolean noSnake() {
    return noBody;
  }


  /**
   * this method indicating whether there is fruit in the gridcell.
   *
   * @return the status signifying if fruit inside.
   */
  public boolean noFruit() {
    return noFruit;
  }


  /**
   * removes the fruit from the grid
   */
  public void deleteFruit() {

    // clear both the reference and boolean
    fruitLoop.deleteFruit();
    noFruit = true;
  }

  /**
   * clean snake body and its reference
   */
  public void deleteSnake() {
    sagment.removeBody();
  }


  /**
   * return the gridcell and all the info it stores.
   *
   * @reutrn itself and all booleans and reference.
   */
  public GridCell returnMySelf() {
    return this;
  }


  /**
   *  this method set the status of the noBody boolean
   *
   * @bool either true for false are set to the noBody.
   */
  public void setNoSnake(boolean bool) {

    noBody = bool;
  }


  /**
   * it update the snake sagment reference
   */
  public void setSnakeBody(SnakeSegment s) {
    this.sagment = s;
  }

  public boolean snakeState() {

    // check if this gridcell is referencing any snakebody
    return (sagment == null);
  }
}

// the end of the GridCell class
