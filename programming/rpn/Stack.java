

// A class that represents a fixed-length array stack

public class Stack<T> implements IStack<T> {

  private T[] stack;
  private int size;
  private int top;

  // Constructor
  public Stack(int size) {
    this.size = size;
    top = 0;
    stack = (T[]) new Object[size];
  }

  // Pushes a new value onto the stack
  public void push(T v) throws OverFlowException {
    if (top == size) {
      throw new OverFlowException();
    }
    stack[top] = v;
    top++;
  }

  // Pops the top value from the stack
  public T pop() throws UnderFlowException {
    if (top == 0) {
      throw new UnderFlowException();
    }
    T value = stack[top - 1];
    top--;
    return value;
  }

}
