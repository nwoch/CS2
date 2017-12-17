

// A class that represents a fixed-length array queue

public class Queue<T> implements IQueue<T> {

  private T[] queue;
  private int size;
  private int back;

  // Constructor
  public Queue(int size) {
    this.size = size;
    back = 0;
    queue = (T[]) new Object[size];
  }

  // Dequeues the Front element from the queue
  public T dequeue() throws UnderFlowException {
    if (back == 0) {
      throw new UnderFlowException();
    }
    T element = queue[0];
    for (int i = 0; i < back - 1; i++) {
      queue[i] = queue[i + 1];
    }
    back--;
    return element;
  }

  // Enqueues an element at the back of the queue
  public void enqueue(T v) throws OverFlowException {
    if (back == size) {
      throw new OverFlowException();
    }
    queue[back] = v;
    back++;
  }

  public int getSize() {
    return queue.length;
  }

}
