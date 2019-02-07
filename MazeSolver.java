public class MazeSolver {
  public static MazeCell[] getNeighbors(Maze m, int r, int c) {

    // if specific neighbor is out of bound, assign null
    MazeCell east = c + 1 < m.getColumns() ?
      m.returnSpecificGridCell(r, c + 1) : null;
    MazeCell south = r + 1 < m.getRows() ? m.returnSpecificGridCell(r + 1, c) :
      null;
    MazeCell west = c - 1 >= 0 ? m.returnSpecificGridCell(r, c - 1) : null;
    MazeCell north = r - 1 >= 0 ? m.returnSpecificGridCell(r - 1, c) : null;

    MazeCell[] neighbors = {east, south, west, north};
    return neighbors;

  }

  public static MazeCell solve(Maze maze, QueueWorklist wl) {

    // add first square to wl and mark it as visited
    wl.add(maze.start);
    maze.start.setVisited(true);

    while (!wl.isEmpty()) {

      MazeCell current = wl.remove();

      if (current == maze.end) {
        MazeCell path = current;
        //while(path != maze.start){
          //path.setPath();
          //path = path.getPrevious();
       // }
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

  public void findPath(Maze m){
    MazeCell end = m.end;

    while (end != m.start) {
      end.setPath();

    }
  }
}
