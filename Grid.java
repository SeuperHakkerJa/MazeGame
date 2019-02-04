/*
 * Filename: Grid.java
 * Author:   Xiaochen Li
 * UserId:   cs11fayl
 * Date:     11/21/2018
 * Sources of help: None
 */

import objectdraw.*;

/**
 * the Grid class acts as a collector of grid, storing important location
 * information, and able to return any cells and their info it has.
 */
public class Grid {

  private int columns, rows;
  private GridCell[] gridCells;
  private DrawingCanvas canvas;


  /**
   * Constructor of the Grid Object, it collects all the gridcells'
   * information and related methods.
   *
   * @param rows    the number of rows of gridcells
   * @param columns the number of columns of gridcells
   * @param canvas  the place where the whold grid is based on
   */
  public Grid(int rows, int columns, DrawingCanvas canvas) {

    // Dimensions
    this.rows = rows;
    this.columns = columns;

    gridCells = new GridCell[rows * columns];
    this.canvas = canvas;
  }

  /**
   * draw methods draw out the layout including the background and the lines
   *
   * @param canvas the place where the lines are based on.
   */
  public void draw(DrawingCanvas canvas) {

    // set up the background
    FilledRect grid = new FilledRect(0, 0,
      columns * Constants.GRID_CELL_SIZE,
      rows * Constants.GRID_CELL_SIZE, canvas);
    grid.setColor(Constants.BACKGROUND_COLOR);

    // calculate the upper left location of every gridcell.
    for (int i = 0; i < columns * rows; ++i) {
      double x = Constants.GRID_CELL_SIZE * (i % columns);
      double y = Constants.GRID_CELL_SIZE * (i / columns);

      // store and assign the location to the gridcells
      Location loc = new Location(x, y);
      gridCells[i] = new GridCell(i % columns, i / columns, loc, this);

      // draw the horizontal and vertical lines.
      drawVerticalLine(columns, rows);
      drawHorizontalLine(columns, rows);
    }
  }


  /**
   * helper method that draws vertical line based on the layout of the gridcell.
   *
   * @param columnNuber the number of columns of gridcells.
   * @param rowNumber   the number of rows of gridcells.
   */
  public void drawVerticalLine(int columnNuber, int rowNumber) {

    for (int i = 1; i < columnNuber; ++i) {

      // draw lines
      Line line = new Line((double) i * Constants.GRID_CELL_SIZE, 0,
        (double) i * Constants.GRID_CELL_SIZE,
        (double) rowNumber * Constants.GRID_CELL_SIZE, canvas);

      // set color
      line.setColor(Constants.GRID_LINE_COLOR);
    }
  }


  /**
   * helper that draws horizontal line based on the layout of the gridcell.
   *
   * @param columnNumber the number of columns of gridcells.
   * @param rowNumber    the number of rows of gridcells.
   */
  public void drawHorizontalLine(int columnNumber, int rowNumber) {

    for (int i = 1; i < rowNumber; ++i) {

      // draw lines
      Line line = new Line(0, (double) i * Constants.GRID_CELL_SIZE,
        (double) columnNumber * Constants.GRID_CELL_SIZE,
        (double) i * Constants.GRID_CELL_SIZE, canvas);

      // set color
      line.setColor(Constants.GRID_LINE_COLOR);
    }
  }


  /**
   * it deletes everything on the gridcell, used when restarting the game.

  public void resetGrid() {
    for (GridCell gridCell : gridCells) {
      gridCell.deleteFruit();
      gridCell.deleteSnake();
    }
  }
  */


  /**
   * this returns the gridcell at a specific location based on the
   * combination of the column and row, if not exist return null
   *
   * @param colNum the column index
   * @param rowNum the row index
   * @return target, the target cell given the col/row information
   */
  public GridCell returnSpecificGridCell(int colNum, int rowNum) {
    GridCell target;
    for (int i = 0; i < gridCells.length; ++i) {
      if ((gridCells[i].getColumns() == colNum) && (gridCells[i].getRows() ==
        rowNum)) {
        target = gridCells[i].returnMySelf();
        return target;
      }
    }
    return null;
  }


  /**
   * this method, given current cell and potential direction of moving,
   * returns the neighbor cell.
   *
   * @param cell the current cell
   * @param dir  the direction of moving
   * @return target, the next cell given direction of moving.
   */
  public GridCell getCellNeighbor(GridCell cell, Direction dir) {

    // calculate, in x-y plane, the position of next cell
    int x_offset = dir.getX();
    int y_offset = dir.getY();

    // return the target cell using the col/row information
    GridCell target = returnSpecificGridCell(cell.getColumns() + x_offset,
      cell.getRows() + y_offset);
    return target;
  }

}
