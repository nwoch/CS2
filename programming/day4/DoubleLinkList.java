

// A class that implement a doubly-linked list. Both head and tail cells are null.

public class DoubleLinkList<T> implements IList<T> {

  private IDLink<T> curr;
  private IDLink<T> head;
  private IDLink<T> tail;
  private T curr_value;

  // Constructor
  public DoubleLinkList() {
    head = new DLink<T>();
    tail = new DLink<T>();
    head.setPrev(head);
    tail.setNext(tail);
    head.setNext(tail);
    tail.setPrev(head);
    curr = head;
    this.curr_value = curr_value;
  }

  // Inserts an item at a specific index in the list
  public void insert(int idx, T v) {
    IDLink<T> new_cell = new DLink<T>();
    curr = head;
    for (int i = 0; i < idx; i++) {
      curr = curr.getNext();
    }
    new_cell.setPrev(curr);
    new_cell.setNext(curr.getNext());
    curr.getNext().setPrev(new_cell);
    curr.setNext(new_cell);
    new_cell.setValue(v);
  }

  // Adds an item to the end of list. Moves <i>current</i> to the end of the list.
  public void append(T v) {
    IDLink<T> new_cell = new DLink<T>();
    curr = tail.getPrev();
    new_cell.setPrev(curr);
    new_cell.setNext(tail);
    tail.setPrev(new_cell);
    curr.setNext(new_cell);
    new_cell.setValue(v);
    curr = new_cell;
  }

  //Removes the item at the <i>current</i> index in the list.
  //<i>Current</i> becomes the previous item in the list, if such element exists.
	public void remove() {
    curr_value = curr.getValue();
    curr.getNext().setPrev(curr.getPrev());
    curr.getPrev().setNext(curr.getNext());
    curr = curr.getPrev();
  }

	//Removes the item at a specific index
	public void remove(int idx) {
    curr = head;
    for (int i = 0; i <= idx; i++) {
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
    if (curr == head) {
      curr = curr.getNext();
    }
    if (curr == tail) {
      curr = curr.getPrev();
    }
    return curr.getValue();
  }

  // Fetches the value at a specific index in the list.
  public T fetch(int idx) {
    curr = head;
    for (int i = 0; i <= idx; i++) {
      curr = curr.getNext();
    }
    curr_value = fetch();
    return curr_value;
  }

  // Advances the <i>current</i> to the next index, if possible.
  public void next() {
    if (curr == tail) {
      curr = head;
    }
    else {
      curr = curr.getNext();
    }
  }

  // Advances the <i>current</i> index to the previous index, if possible.
  public void prev() {
    if (curr == head) {
      curr = tail;
    }
    else {
      curr = curr.getPrev();
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
   int counter = -1; //excludes head and tail
   curr = head;
   while (curr != tail) {
     curr = curr.getNext();
     counter++;
   }
   return counter;
 }

}
