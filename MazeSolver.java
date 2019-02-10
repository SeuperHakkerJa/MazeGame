
public class MazeSolver {
  private MazeCell criticalTracker;


  public MazeCell[] getNeighbors(Maze m, int r, int c) {

    // if specific neighbor is out of bound, assign null
    MazeCell east = c + 1 < m.getColumns() ?
      m.returnSpecificGridCell(c + 1, r) : null;
    MazeCell south = r + 1 < m.getRows() ? m.returnSpecificGridCell(c, r + 1) :
      null;
    MazeCell west = c - 1 >= 0 ? m.returnSpecificGridCell(c - 1, r) : null;
    MazeCell north = r - 1 >= 0 ? m.returnSpecificGridCell(c, r - 1) : null;

    MazeCell[] neighbors = {east, south, west, north};
    return neighbors;

  }

  public MazeCell solve(Maze maze, QueueWorklist wl) {

    criticalTracker = maze.start;

    // add first square to wl and mark it as visited
    wl.add(maze.end);
    maze.end.setVisited(true);

    while (!wl.isEmpty()) {

      MazeCell current = wl.remove();

      if (current == maze.start) {
        return current;
      } else {

        // get current location
        int row = current.getRow();
        int col = current.getColumn();

        // get neighbor squares
        MazeCell[] neighbors = getNeighbors(maze, row, col);

        for (MazeCell n : neighbors) {

          // req: not null, not wall, not visited.
          if (n != null && !(n.isWall() || n.isVisited())) {
            wl.add(n);
            n.setPrevious(current);
            n.setVisited(true);
          }
        }
      }
    }
    // if there is no solution
    return null;
  }


  public synchronized MazeCell showPath() {


    criticalTracker.setPath();
    return criticalTracker;


  }

  public void getNext(Maze maze) {

    if (criticalTracker != maze.end) {
      criticalTracker = criticalTracker.getPrevious();
    }
  }
}

