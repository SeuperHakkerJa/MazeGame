import objectdraw.*;


public class Main extends WindowController {

  public static int columns = 8, rows = 8;
  public static Maze maze;
  public static MazeSolver ms;



  public static void main(String[] args) {

    new Acme.MainFrame(new Main(), args,
      columns * Constants.GRID_CELL_SIZE,
      rows * Constants.GRID_CELL_SIZE + Constants.SCORE_PANEL_HEIGHT);


  }

  public void begin() {
    initGame();
    solve();
  }

  public void initGame() {
    columns = 8;
    rows = 8;
    maze = new Maze(rows, columns, canvas);
    maze.draw(canvas);
    maze.setWall(2, 3);
    maze.setWall(2, 4);
    maze.setWall(2, 6);
    maze.setWall(2, 5);
    maze.setWall(6, 4);

    maze.setWall(5, 6);
    maze.setWall(0, 6);
    maze.setWall(1, 6);
    maze.setStart(0, 0);
    maze.setEnd(4, 7);
    ms = new MazeSolver();


  }

  public void onMouseClick(Location point) {
    System.out.println(ms.formPath(maze));
    ms.popNextPath();

  }



  public void solve() {
    ms = new MazeSolver();
    ms.solve(maze, new QueueWorklist());
    ms.formPath(maze);
  }


}
