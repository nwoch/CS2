

// A class for searching graphs by breadth first

public class BreadthFirstSearcher<N,W> implements ISearcher<N,W> {

  private Queue<INode<N>> visited;
  private DoubleLinkList<INode<N>> path;
  private Dict<String, INode<N>> visited2;

  // Constructor
  public BreadthFirstSearcher() {
    visited = new Queue<INode<N>>(0);
    path = new DoubleLinkList<INode<N>>();
    visited2 = new Dict<String, INode<N>>();
  }

  // Determines if there is a path without returning the path
  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e) {
    if (s == e) {
      System.out.println("Start and end are the same");
      return false;
    }
    create(g);
    if (search(g, s, e) == e) {
      return true;
    }
    return false;
  }

  // Searches for path
  public INode<N> search(IGraph<N,W> g, INode<N> s, INode<N> e) {
    if (s == e) {
      return e;
    }
    if (visited2.size() == 0) {
      try {
        visited.enqueue(s);
      }
      catch (OverFlowException o) {
        System.out.println("ERROR: " + o);
      }
      visited2.add((String) s.getValue(), null);
    }
    if (visited.getSize() == 0 && visited2.size() != 0) {
      return null;
    }
    INode<N> curr_node = new Node<N>(null);
    try {
      curr_node = visited.dequeue();
    }
    catch (UnderFlowException u) {
      System.out.println("ERROR: " + u);
    }
    if (g.getEdgesFrom(curr_node).length > 0) {
      for (int i = 0; i < g.getEdgesFrom(curr_node).length; i++) {
        if (g.getEdgesFrom(curr_node)[i].getDestination() == e) {
          visited2.add((String) e.getValue(), curr_node);
          return e;
        }
        try {
          visited.enqueue(g.getEdgesFrom(curr_node)[i].getDestination());
        }
        catch (OverFlowException o) {
          System.out.println("ERROR: " + o);
        }
        if (visited2.fetch((String) g.getEdgesFrom(curr_node)[i].getDestination().getValue()) == null) {
          visited2.add((String) g.getEdgesFrom(curr_node)[i].getDestination().getValue(), curr_node);
        }
      }
      for (int i = 0; i < g.getEdgesFrom(curr_node).length; i++) {
        if (search(g, g.getEdgesFrom(curr_node)[i].getDestination(), e) == e) {
          return e;
        }
      }
    }
    return null;
  }

  // Creates a queue and dictionary to store nodes
  public void create(IGraph<N,W> g) {
    Dict<String, INode<N>> temporary = new Dict<String, INode<N>>();
    Queue<INode<N>> temporary2 = new Queue<INode<N>>(g.getNodeSet().length);
    visited2 = temporary;
    visited = temporary2;
  }

  // Finds shortest path taken from visited nodes
  public IList<INode<N>> findPath(INode<N> e) {
    if (e == null) {
      reversePath();
      return path;
    }
    Object[] temp = visited2.keys();
    for (int i = 0; i < visited2.size(); i++) {
      if (temp[i] == e.getValue()) {
        path.append(e);
        return findPath(visited2.fetch((String) temp[i]));
      }
    }
    return path;
  }

  // Reverses backwards path
  public void reversePath() {
    DoubleLinkList<INode<N>> reversed = new DoubleLinkList<INode<N>>();
    int size = path.size();
    path.jumpToTail();
    path.prev();
    for (int i = 0; i < size; i++) {
      reversed.append(path.fetch());
      path.prev();
    }
    path = reversed;
  }

  // Finds a path based on the properties of the search algorithm.
  // If there is no path in graph g from node s to node e, null should be
  // returned. If node s and node e are the same, an empty list should be returned.
  public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e) {
    DoubleLinkList<INode<N>> temporary = new DoubleLinkList<INode<N>>();
    path = temporary;
    if (s == e || pathExists(g, s, e) == true) {
      return findPath(e);
    }
    System.out.println("No path found");
    return null;
  }

  public static void main(String[] argv) throws Exception {
    ISearcher<String, Double> searcher = new BreadthFirstSearcher<String, Double>();
    IGraphReader r = new DiGraphReader();
    IGraph<String,Double> g = r.read("graphfile.cs2");
    IList<INode<String>> path2 = new DoubleLinkList<INode<String>>();
    path2 = searcher.getPath(g, g.getNodeSet()[0], g.getNodeSet()[4]);
    int size = path2.size();
    path2.jumpToHead();
    for (int i = 0; i < size; i++) {
      System.out.println("path (start -> end): " + path2.fetch().getValue());
      path2.next();
    }
  }

}
