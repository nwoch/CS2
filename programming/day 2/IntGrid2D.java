

// A class that represents an integer grid in 2D

public class IntGrid2D implements IIntGrid2D {

  private int ul_x;
  private int ul_y;
  private int lr_x;
  private int lr_y;
  private char fill_value;
  private char[][] grid;

  // Constructor
  public IntGrid2D(int ul_x, int ul_y, int lr_x, int lr_y, char fill_value) {
    this.ul_x = ul_x;
    this.ul_y = ul_y;
    this.lr_x = lr_x;
    this.lr_y = lr_y;
    this.fill_value = fill_value;
    this.grid = new char[Math.abs(ul_x - lr_x) + 1][Math.abs(ul_y - lr_y) + 1];
  }

    // Sets the value at a point on the grid, replacing the previous value if any
    public void setPoint(IIntPoint2D p, char v) {
      int grid_y = p.getY() * -1;
      int grid_x = grid_y;
      grid_y = p.getX();
      try {
        grid[grid_x + 1][grid_y + 1] = v;
      }
      catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("ERROR: " + e);
      }
    }

    // Gets the value at a point on the grid
    public char getPoint(IIntPoint2D p) {
      int grid_y = p.getY() * -1;
      int grid_x = grid_y;
      grid_y = p.getX();
      try {
        fill_value = grid[grid_x + 1][grid_y + 1];
      }
      catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("ERROR: " + e);
      }
      return fill_value;
    }

     // Gets the coordinate for the upper left most location
     public IIntPoint2D getUpperLeftCorner() {
       IntPoint2D upper_left = new IntPoint2D(ul_x, ul_y);
       return upper_left;
     }

     // Gets the coordinate for the lower right most location
     public IIntPoint2D getLowerRightCorner() {
       IntPoint2D lower_right = new IntPoint2D(lr_x, lr_y);
       return lower_right;
     }

}
