

// A class for a directed graph data structure

public class Graph<N, W> implements IGraph<N, W> {

  private INode<N>[] nodes;
  private IEdge<N, W>[] edges;
  private int size;
  private int size2;

  public Graph() {
    size = 0;
    size2 = 0;
    nodes = (INode<N>[]) new INode[1];
    edges = (IEdge<N, W>[]) new IEdge[1];
  }

  // Gets an array of all the nodes in the graph
  public INode<N>[] getNodeSet() {
    return nodes;
  }

  // Gets an array of the neighbors of a node
  public INode<N>[] getNeighbors(INode<N> n) {
    int neighbors_size = getEdgesFrom(n).length + getEdgesTo(n).length;
    INode<N>[] neighbors = (INode<N>[]) new INode[neighbors_size];
    for (int i = 0; i < getEdgesFrom(n).length; i++) {
      neighbors[i] = getEdgesFrom(n)[i].getDestination();
    }
    for (int i = getEdgesFrom(n).length; i < neighbors_size; i++) {
      neighbors[i] = getEdgesTo(n)[i - getEdgesFrom(n).length].getSource();
    }
    return neighbors;
  }

   // Adds a node to the graph
   public INode<N> addNode(N v) {
     size++;
     INode<N> new_node = new Node<N>(v);
     if (size == 1) {
       nodes[0] = new_node;
     }
     else {
       INode<N>[] temporary = (INode<N>[]) new INode[size];
       for (int i = 0; i < nodes.length; i++) {
         temporary[i] = nodes[i];
       }
       temporary[size - 1] = new_node;
       nodes = temporary;
     }
     return new_node;
   }

   // Gets an array of all the edges in the graph
   public IEdge<N,W>[] getEdgeSet() {
     return edges;
   }

   // Gets an array of all the edges sourced at a particular node
   public IEdge<N,W>[] getEdgesFrom(INode<N> n) {
     int counter = 0;
     IEdge<N, W>[] temporary = (IEdge<N, W>[]) new IEdge[edges.length];
     for (int i = 0; i < edges.length; i++) {
       if (edges[i].getSource() == n) {
         temporary[counter] = edges[i];
         counter++;
       }
     }
     IEdge<N, W>[] sourced = (IEdge<N, W>[]) new IEdge[counter];
     for (int i = 0; i < counter; i++) {
       sourced[i] = temporary[i];
     }
     return sourced;
   }

   // Gets an array of all the edges destined for a particular node
   public IEdge<N,W>[] getEdgesTo(INode<N> n) {
     int counter = 0;
     IEdge<N, W>[] temporary = (IEdge<N, W>[]) new IEdge[edges.length];
     for (int i = 0; i < edges.length; i++) {
       if (edges[i].getDestination() == n) {
         temporary[counter] = edges[i];
         counter++;
       }
     }
     IEdge<N, W>[] destined = (IEdge<N, W>[]) new IEdge[counter];
     for (int i = 0; i < counter; i++) {
       destined[i] = temporary[i];
     }
     return destined;
   }

   // Adds an edge to the graph.
   // Duplicate edges are not allowed in the graph. The equals method of the edge can
   // be used to determine if two edges duplicate one another.
   public void addEdge(INode<N> s, INode<N> d, W w) {
     int duplicate = 0;
     IEdge<N, W> new_edge = new Edge<N, W>(s, d, w);
     if (size2 == 0) {
       edges[0] = new_edge;
       size2++;
     }
     else {
       for (int i = 0; i < edges.length; i++) {
         if (new_edge.equals(edges[i])) {
           duplicate = 1;
           break;
         }
       }
       if (duplicate == 0) {
         size2++;
         IEdge<N, W>[] temporary = (IEdge<N, W>[]) new IEdge[size2];
         for (int i = 0; i < edges.length; i++) {
           temporary[i] = edges[i];
         }
         temporary[size2 - 1] = new_edge;
         edges = temporary;
       }
     }
   }

}
