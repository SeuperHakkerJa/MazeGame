
/**
 * Defines movement directions as 2D x,y unit vectors.
 */
public enum Direction {

  // Definitions for the enum Direction constants
  // "NONE" means no movement
  NONE(0, 0), UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

  private final int x;
  private final int y;

  /**
   * Constructor for defining an enum value.
   *
   * @param x The x movement unit vector to assign to this direction
   * @param y The y movement unit vector to assign to this direction
   */
  Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns the x component of this movement direction.
   *
   * @return the x component of this movement direction
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the y component of this movement direction.
   *
   * @return the y component of this movement direction
   */
  public int getY() {
    return y;
  }

  /**
   * Returns whether or not this direction is the opposite of that direction.
   * For example, LEFT and RIGHT are opposite directions, UP and DOWN are
   * opposite direction, LEFT and UP are *not* opposite directions.
   *
   * @param that The other direction to compare to
   * @return whether or not the two directions are the opposite of each other
   */
  public boolean isOpposite(Direction that) {
    // Directions are opposite when their x and y components both add up to 0
    return (this.x + that.x == 0) && (this.y + that.y == 0);
  }

  /**
   * Returns the string representation of a Direction. This can be useful for
   * debugging by printing out the string returned to verify that the directions
   * are working as intended in your code.
   *
   * @return the string representation of this Direction
   */
  @Override
  public String toString() {
    // this.name() returns the name of this Direction enum constant
    return this.name() + "(" + x + ", " + y + ")";
  }

}
