import objectdraw.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends WindowController implements ActionListener {

  public static int columns = 8, rows = 8;
  public static Maze maze;
  public static MazeSolver ms;

  public static int columnInput, rowInput;

  public JPanel buttonPanel, functionPanel;
  public JButton nextStepButton, showPathButton, wallButton, startButton,
    endButton, solveButton;

  public boolean wallOpen, startOpen, endOpen;



  public static void main(String[] args) {

    new Acme.MainFrame(new Main(), args,
      columns * Constants.GRID_CELL_SIZE,
      rows * Constants.GRID_CELL_SIZE + Constants.SCORE_PANEL_HEIGHT);


  }

  public void begin() {

    constructLayout();
    initGame();

  }


  public void initGame() {
    columns = 8;
    rows = 8;
    maze = new Maze(rows, columns, canvas);
    maze.draw(canvas);

    ms = new MazeSolver();


  }

  public void onMouseClick(Location point) {


    System.out.println(point.getX() + " " + point.getY());
    //
    //ms.showPath();
    //ms.getNext(maze);
    int x = (int) (point.getX() / Constants.GRID_CELL_SIZE);
    int y = (int) (point.getY() / Constants.GRID_CELL_SIZE);

    if (wallOpen) {
      maze.setWall(x, y);
    } else if (startOpen) {
      maze.setStart(x,y);
      startButton.setEnabled(false);
    } else if (endOpen) {
      maze.setEnd(x,y);
      endButton.setEnabled(false);
    }


  }




  public void solve() {
    ms = new MazeSolver();
    ms.solve(maze, new QueueWorklist());

  }

  public void constructLayout() {

    buttonPanel = new JPanel(new GridLayout(1, 3));
    nextStepButton = new JButton("Next Step");
    showPathButton = new JButton("Show Path");
    solveButton = new JButton("Solve");
    buttonPanel.add(solveButton);
    buttonPanel.add(nextStepButton);
    buttonPanel.add(showPathButton);
    this.add(buttonPanel, BorderLayout.SOUTH);

    functionPanel = new JPanel(new GridLayout(3, 1));
    wallButton = new JButton("set Wall");
    startButton = new JButton("set Start");
    endButton = new JButton("set End");
    functionPanel.add(wallButton);
    functionPanel.add(startButton);
    functionPanel.add(endButton);
    this.add(functionPanel, BorderLayout.EAST);

    wallButton.addActionListener(this);
    startButton.addActionListener(this);
    endButton.addActionListener(this);
    solveButton.addActionListener(this);
    nextStepButton.addActionListener(this);


    this.validate();

  }

  public void actionPerformed(ActionEvent evt) {

    String actionCommand = evt.getActionCommand();

    if (actionCommand.equals("set Wall")) {
      wallOpen = !wallOpen;
      startOpen = false;
      endOpen = false;

    } else if (actionCommand.equals("Solve")) {

      solve();
      wallButton.setEnabled(false);
      startButton.setEnabled(false);
      endButton.setEnabled(false);

    } else if (actionCommand.equals("Next Step")) {

      ms.showPath();
      ms.getNext(maze);

    } else if (actionCommand.equals("set Start")){

      startOpen = !startOpen;
      endOpen = false;
      wallOpen = false;
    } else if (actionCommand.equals("set End")){
      endOpen = !endOpen;
      startOpen = false;
      wallOpen = false;
    }

  }
}
