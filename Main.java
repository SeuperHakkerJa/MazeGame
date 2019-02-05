import objectdraw.*;


public class Main extends WindowController {

  public static int columns = 8, rows = 8;
  public static Maze maze;



  public static void main(String[] args) {

    new Acme.MainFrame(new Main(), args,
      columns * Constants.GRID_CELL_SIZE,
      rows * Constants.GRID_CELL_SIZE + Constants.SCORE_PANEL_HEIGHT);


  }

  public void begin() {
    initGame();
  }

  public void initGame() {
    columns = 8;
    rows = 8;
    maze = new Maze(rows, columns, canvas);
    maze.draw(canvas);
    maze.setWall(2, 3);
    maze.setWall(4, 3);
    maze.setWall(2, 6);
    maze.setWall(2, 4);
    maze.setWall(5, 6);
    maze.setStart(0, 0);
    maze.setEnd(4, 7);


  }


}
