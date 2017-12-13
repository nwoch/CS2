

// A class for a node in a graph

public class Node<N> implements INode<N> {

  private N value;

  // Constructor
  public Node(N start_value) {
    value = start_value;
  }

  // Updates the value at the node
  public void setValue(N v) {
    value = v;
  }

  // Fetches the value at the node
  public N getValue() {
    return value;
  }

}
