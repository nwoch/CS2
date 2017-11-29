

// A class that represents integer points in 2D

public class IntPoint2D implements IIntPoint2D {

  private int x;
  private int y;

  // Constructor
  public IntPoint2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // Returns the X coordinate
  public int getX() {
    return x;
  }

  // Returns the Y coordinate
  public int getY() {
    return y;
  }

  // Computes the manhattan distance to another point
  public int manhattanDistance(IIntPoint2D o) {
    int m_distance = (Math.abs(x - o.getX())) + (Math.abs(y - o.getY()));
    return m_distance;
  }

  // Computes the euclidean distance to another point
    public double distance(IIntPoint2D o) {
      double value_1 = ((double) x) - ((double) o.getX());
      double value_2 = ((double) y) - ((double) o.getY());
      double e_distance = Math.sqrt((value_1 * value_1) + (value_2 * value_2));
      return e_distance;
    }

    // Converts a point object to a string of the form (X,Y)
    public String toString() {
      String coordinates = "(" + Integer.toString(x) + ", " + Integer.toString(y) + ")";
      return coordinates;
    }

    // Determines if this point is the same as another (i.e. x1=x2 and y1=y2)
    public boolean equals(IIntPoint2D o) {
      boolean is_equal = (x == o.getX() && y == o.getY());
      return is_equal;
    }

    // Hashcode to support some standard library data structures
    public int hashcode() {
      int hash_code = (x << 16) + y;
      return hash_code;
    }

}
