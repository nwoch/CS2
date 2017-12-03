

// A class that implements singlely-linked list nodes

public class SLink<T> implements ISLink<T> {

  private T curr_value;
  private ISLink<T> next;

  // Constructor
  public SLink() {
  }

  // Gets the current value for this link cell
  public T getValue() {
    return curr_value;
  }

  // Sets the current value for this link cell
  public void setValue(T v) {
    curr_value = v;
  }

  //* Gets the next cell in the list
  public ISLink<T> getNext() {
   return next;
  }

  //Sets the next cell in the list
  public void setNext(ISLink<T> c) {
    next = c;
  }

}
