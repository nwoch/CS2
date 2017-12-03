

// A class that implement a List backed by an array that is resized as needed

public class ArrayList<T> implements IList<T> {

  private T[] array;
  private int curr_idx;
  private int size;
  private T curr_value;

  // Constructor
  public ArrayList() {
    size = 0;
    array = (T[]) new Object[size];
    curr_idx = 0;
    this.curr_value = curr_value;
  }

  // Inserts an item at a specific index in the list
  public void insert(int idx, T v) {
    curr_idx = idx;
    curr_value = v;
    T[] temporary = (T[]) new Object[array.length + 1];
    for (int i = 0; i < array.length; i++) {
      if (i < curr_idx) {
        temporary[i] = array[i];
      }
      else {
        temporary[i + 1] = array[i];
      }
    }
    temporary[curr_idx] = curr_value;
    array = temporary;
  }

  // Adds an item to the end of list. Moves curr_idx to the end of the list.
  public void append(T v) {
    T[] temporary = (T[]) new Object[array.length + 1];
    for (int i = 0; i < array.length; i++) {
      temporary[i] = array[i];
    }
    temporary[array.length] = v;
    curr_idx = array.length - 1;
    array = temporary;
  }

  // Removes the item at curr_idx in the list.
  // Curr_idx becomes the previous item in the list, if such an element exists.
  public void remove() {
    T[] temporary = (T[]) new Object[array.length - 1];
    curr_value = array[curr_idx];
    for(int i = 0; i < array.length; i++) {
      if (i < curr_idx) {
          temporary[i] = array[i];
      }
      if (i > curr_idx) {
          temporary[i - 1] = array[i];
      }
    }
    if (curr_idx != 0) {
      curr_idx = curr_idx - 1;
    }
    array = temporary;
  }

  // Removes the item at a specific index
  public void remove(int idx) {
    curr_idx = idx;
    remove();
  }

  // Changes the location of an existing element in the list
  public void move(int sidx, int didx) {
    remove(sidx);
    insert(didx, curr_value);
  }

  // Fetches the value at the curr_idx in the list.
  public T fetch() {
    return array[curr_idx];
  }

  // Fetches the value at a specific index in the list.
  public T fetch(int idx) {
    curr_idx = idx;
    curr_value = fetch();
    return curr_value;
  }

  // Advances the curr_idx to the next index, if possible.
  public void next() {
    if (curr_idx < 0 || curr_idx >= array.length) {
      curr_idx = 0;
    }
    curr_idx = curr_idx + 1;
  }

  // Advances the curr_idx to the previous index, if possible.
  public void prev() {
    if (curr_idx < 0 || curr_idx >= array.length) {
      curr_idx = 0;
    }
    curr_idx = curr_idx - 1;
  }

  // Advances the curr_idx to the tail element
  public void jumpToTail() {
    curr_idx = array.length - 1;
  }

  // Advances the curr_idx to the head element
  public void jumpToHead() {
    curr_idx = 0;
  }

  // Returns the number of elements in the list
 public int size() {
   return array.length;
 }

}
