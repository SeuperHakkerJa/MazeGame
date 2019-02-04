/*
 * Filename: Constants.java
 * Author:   Xiaochen Li
 * UserId:   cs11fayl
 * Date:     11/15/2018
 * Sources of help: None
 */

import java.awt.Color;

/**
 * Contains constants for use in PA8. Note which constants are used in which
 * file. Some constants will be used in more than one file.
 */
public abstract class Constants {

  /* -------------------------------------------------------------------- *
   * Constants for parsing command line arguments
   * -------------------------------------------------------------------- */
  // Indices of command line arguments in args array
  public static final int GRID_SIZE_IDX = 0;
  public static final int LOOPS_TO_WIN_IDX = 1;
  public static final int DELAY_IDX = 2;
  public static final int MAX_NUM_ARGS = 3;

  // Constants for parsing grid size command line argument
  public static final String GRID_SIZE_DELIM = "x";
  public static final int NUM_GRID_SIZE_DIMENSIONS = 2;
  public static final int DEFAULT_ROWS = 20;
  public static final int DEFAULT_COLS = 18;

  // Length of pause in each iteration of the animation loop (in milliseconds)
  public static final int DEFAULT_ANIMATION_DELAY = 120;

  // Valid ranges for command line arguments
  public static final int MIN_ROWS = 2;
  public static final int MAX_ROWS = 25;
  public static final int MIN_COLS = 2;
  public static final int MAX_COLS = 45;
  public static final int MIN_LOOPS_TO_WIN = 1;
  public static final int MIN_DELAY = 50;
  public static final int MAX_DELAY = 1000;

  // Usage message
  public static final String USAGE_STR =
    "\nUsage: SnakeGame [rowsXcolumns [loopsToWin [delay]]]\n" +
      "  rowsXcolumns: size of the grid; 'X' is not case sensitive\n" +
      "    -- rows must be valid integer in the range [%d, %d]\n" +
      "    -- columns must be valid integer in the range [%d, %d]\n" +
      "    -- defaults to %dx%d\n" +
      "  loopsToWin: the number of fruit loops that must be eaten to win\n" +
      "    -- must be valid integer in the range [%d, (rows * columns) - 1]\n" +
      "    -- defaults to (rows * columns) - 1; (the full grid)\n" +
      "  delay: length of the animation pause measured in milliseconds\n" +
      "    -- must be valid integer in the range [%d, %d]\n" +
      "    -- defaults to %d milliseconds\n";

  // Error messages
  public static final String NUM_ARGS_ERR =
    "Error: too many arguments provided";
  public static final String GRID_SIZE_FMT_ERR =
    "Error: rowsXcolumns (%s) is not formatted properly\n";
  public static final String INT_ERR =
    "Error: %s (%s) must be a valid integer\n";
  public static final String RANGE_ERR =
    "Error: %s (%d) must be within the range [%d, %d]\n";
  public static final String LOOPS_RANGE_ERR =
    "Error: loopsToWin must be within the range [%d, (rows * columns) - 1]\n";

  // Strings for specifying the names of command line arguments
  // Used for filling some of the %s format specifiers in the strings above
  public static final String ROWS_STR = "rows";
  public static final String COLS_STR = "columns";
  public static final String LOOPS_STR = "loopsToWin";
  public static final String DELAY_STR = "delay";

  /* -------------------------------------------------------------------- *
   * General constants
   * -------------------------------------------------------------------- */
  public static final Color BACKGROUND_COLOR = new Color(32, 34, 37);
  public static final int GRID_CELL_SIZE = 40;

  /* -------------------------------------------------------------------- *
   * Use the following constants in SnakeGame.java
   * -------------------------------------------------------------------- */
  // Constants for the score labels
  public static final int SCORE_PANEL_HEIGHT = 22;
  public static final int NUM_LOOP_LABELS = 3;
  public static final String LOOPS_EATEN_STR = "Fruit Loops Eaten: ";
  public static final String LOOPS_TO_WIN_STR = "Fruit Loops to Win: ";
  public static final String MOST_LOOPS_EATEN_STR = "Most Fruit Loops Eaten: ";

  // Constants for popup messages
  public static final Color POPUP_COLOR = new Color(12, 14, 17, 230);
  public static final Color TEXT_COLOR = Color.WHITE;
  public static final int BIG_FONT_SIZE = 40;
  public static final int SMALL_FONT_SIZE = 15;
  public static final int TEXT_Y_OFFSET = 17;
  // Strings to be used in popup messages
  public static final String PAUSE_STR = "Paused";
  public static final String WIN_STR = "You Win!";
  public static final String LOSE_STR = "Game Over";
  public static final String RESTART_STR = "Press 'r' to restart";

  public static final Color[] FRUIT_LOOP_COLORS = {
    new Color(252, 53, 89),    // Red
    new Color(251, 125, 63),   // Orange
    new Color(254, 226, 74),   // Yellow
    new Color(83, 245, 118),   // Green
    new Color(38, 223, 253),   // Blue
    new Color(169, 87, 202)    // Purple
  };

  // Game states
  public static final int GAME_RUNNING = 0;
  public static final int GAME_PAUSED = 1;
  public static final int GAME_OVER = 2;  // Can be due to win or loss

  /* -------------------------------------------------------------------- *
   * Use the following constants in Maze.java
   * -------------------------------------------------------------------- */
  public static final Color GRID_LINE_COLOR = new Color(170, 171, 173);

  /* -------------------------------------------------------------------- *
   * Use the following constants in FruitLoop.java
   * -------------------------------------------------------------------- */
  public static final int OUTER_SIZE_DIVISOR = 2;
  public static final int INNER_SIZE_DIVISOR = 4;
}
