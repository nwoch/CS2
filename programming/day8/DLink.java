

// A class that implements doubly-linked list nodes

public class DLink<T> implements IDLink<T> {

  private T curr_value;
  private IDLink<T> next;
  private IDLink<T> prev;

  // Constructor
  public DLink() {
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
  public IDLink<T> getNext() {
   return next;
  }

  //* Gets the previous cell in the list
  public IDLink<T> getPrev() {
    return prev;
  }

  //Sets the next cell in the list
  public void setNext(IDLink<T> c) {
    next = c;
  }

  //Sets the previous cell in the list
  public void setPrev(IDLink<T> c) {
    prev = c;
  }

}
