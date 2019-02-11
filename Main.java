import objectdraw.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends WindowController implements ActionListener {

  // default maze size
  public static int columns = 15, rows = 15;
  public static Maze maze;
  public static MazeSolver ms;

  // buttons and containers
  public JPanel buttonPanel, functionPanel;
  public JButton nextStepButton, wallButton, startButton,
    endButton, solveButton;
  public boolean wallOpen, startOpen, endOpen;



  public static void main(String[] args) {

    // size may differ on different OS
    new Acme.MainFrame(new Main(), args,
      columns * Constants.GRID_CELL_SIZE + 30,
      rows * Constants.GRID_CELL_SIZE + Constants.SCORE_PANEL_HEIGHT + 7);
  }


  public void begin() {

    constructLayout();
    initGame();

  }


  public void initGame() {

    maze = new Maze(rows, columns, canvas);
    maze.draw(canvas);
    ms = new MazeSolver();


  }

  public void onMouseClick(Location point) {

    // location / unit_length to determine which cell has been clicked
    int x = (int) (point.getX() / Constants.GRID_CELL_SIZE);
    int y = (int) (point.getY() / Constants.GRID_CELL_SIZE);

    // action determined by button which has been clicked
    if (wallOpen) {
      maze.setWall(x, y);

    } else if (startOpen) {
      maze.setStart(x, y);
      startButton.setEnabled(false);

    } else if (endOpen) {
      maze.setEnd(x, y);
      endButton.setEnabled(false);
    }
  }




  public void solve() {

    ms = new MazeSolver();
    ms.solve(maze, new QueueWorklist());

    // disabled all actions under onMouseClick
    startOpen = false;
    endOpen = false;
    wallOpen = false;

  }



  public void constructLayout() {

    // buttons at bottom
    buttonPanel = new JPanel(new GridLayout(1, 3));
    nextStepButton = new JButton("Next Step");
    solveButton = new JButton("Solve");
    buttonPanel.add(solveButton);
    buttonPanel.add(nextStepButton);
    this.add(buttonPanel, BorderLayout.SOUTH);

    // buttons at right side.
    functionPanel = new JPanel(new GridLayout(3, 1));
    wallButton = new JButton("set Wall");
    startButton = new JButton("set Start");
    endButton = new JButton("set End");
    functionPanel.add(wallButton);
    functionPanel.add(startButton);
    functionPanel.add(endButton);
    this.add(functionPanel, BorderLayout.EAST);

    // add this as listener to buttons.
    wallButton.addActionListener(this);
    startButton.addActionListener(this);
    endButton.addActionListener(this);
    solveButton.addActionListener(this);
    nextStepButton.addActionListener(this);


    // validate
    this.validate();

  }


  public void actionPerformed(ActionEvent evt) {

    String actionCommand = evt.getActionCommand();

    if (actionCommand.equals("set Wall")) {

      // enable setWall mode and turn off other mode to avoid conflict
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

    } else if (actionCommand.equals("set Start")) {

      // turn on setStart mode, and turn down other modes.
      startOpen = !startOpen;
      endOpen = false;
      wallOpen = false;

    } else if (actionCommand.equals("set End")) {
      endOpen = !endOpen;
      startOpen = false;
      wallOpen = false;
    }

  }
}
