

// A class for an edge in a graph

public class Edge<N, W> implements IEdge<N, W> {

  private INode<N> source;
  private INode<N> destination;
  private W weight;

  // Constructor
  public Edge(INode<N> s, INode<N> d, W w) {
    source = s;
    destination = d;
    weight = w;
  }

  // Gets the source node of the edge
  public INode<N> getSource() {
    return source;
  }

  // Gets the destination node of the edge
  public INode<N> getDestination() {
    return destination;
  }

  // Gets the weight of the edge
  public W getWeight() {
    return weight;
  }

  // Tests for equality of two edges
  // Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
  // and this.dst == o.dst
  public boolean equals(Object o) {
    try {
      IEdge<N, W> e = (IEdge<N, W>) o;
      if (this.getSource() == e.getSource() && this.getDestination() == e.getDestination()) {
        return true;
      }
    }
    catch (Exception e) {
      System.out.println("ERROR: " + e);
    }
    return false;
  }

}
