

// A class that implement a singlely-linked list. Head cell is null; tail cell contains a value.

public class SingleLinkList<T> implements IList<T> {

  private ISLink<T> curr;
  private ISLink<T> head;
  private ISLink<T> tail;
  private T curr_value;

  // Constructor
  public SingleLinkList() {
    head = new SLink<T>();
    tail = new SLink<T>();
    tail.setNext(tail);
    head.setNext(tail);
    curr = head;
    this.curr_value = curr_value;
  }

  // Inserts an item at a specific index in the list
  public void insert(int idx, T v) {
    if (tail.getValue() == null) {
      tail.setValue(v);
    }
    else if (idx == size()) {
      append(v);
    }
    else {
      ISLink<T> new_cell = new SLink<T>();
      curr = head;
      for (int i = 0; i < idx; i++) {
        curr = curr.getNext();
      }
      new_cell.setNext(curr.getNext());
      curr.setNext(new_cell);
      new_cell.setValue(v);
    }
  }

  // Adds an item to the end of list. Moves <i>current</i> to the end of the list.
  public void append(T v) {
    if (tail.getValue() == null) {
      tail.setValue(v);
    }
    else {
      ISLink<T> new_cell = new SLink<T>();
      tail.setNext(new_cell);
      tail = tail.getNext();
      tail.setValue(v);
    }
    curr = tail;
  }

  //Removes the item at the <i>current</i> index in the list.
  //<i>Current</i> becomes the previous item in the list, if such element exists.
	public void remove() {
    if (curr != tail) {
      curr_value = curr.getNext().getValue();
      if (curr.getNext() == tail) {
        tail = curr;
        curr = tail;
      }
      else {
        curr.setNext(curr.getNext().getNext());
        prev();
      }
    }
  }

	//Removes the item at a specific index
	public void remove(int idx) {
    curr = head;
    for (int i = 0; i < idx; i++) {
      curr = curr.getNext();
    }
    remove();
  }

  // Changes the location of an existing element in the list
  public void move(int sidx, int didx) {
    remove(sidx);
    insert(didx, curr_value);
  }

  // Fetches the value at the <i>current</i> in the list.
  public T fetch() {
    if (curr == tail) {
      prev();
    }
    return curr.getNext().getValue();
  }

  // Fetches the value at a specific index in the list.
  public T fetch(int idx) {
    curr = head;
    for (int i = 0; i < idx; i++) {
      curr = curr.getNext();
    }
    curr_value = fetch();
    return curr_value;
  }

  // Advances the <i>current</i> to the next index, if possible.
  public void next() {
    if (curr == tail) {
      curr = tail;
    }
    else {
      curr = curr.getNext();
    }
  }

  // Advances the <i>current</i> index to the previous index, if possible.
  public void prev() {
    if (curr == head) {
      curr = head;
    }
    else {
      ISLink<T> temporary = new SLink<T>();
      temporary = head;
      while (temporary.getNext() != curr) {
        temporary = temporary.getNext();
      }
      curr = temporary;
    }
  }

  // Advances the <i>current</i> to the tail element
  public void jumpToTail() {
    curr = tail;
  }

  // Advances the <i>current</i> to the head element
  public void jumpToHead() {
    curr = head;
  }

  // Returns the number of elements in the list
 public int size() {
   int counter = 0; //excludes head
   curr = head;
   while (curr != tail) {
     curr = curr.getNext();
     counter++;
   }
   return counter;
 }

}
