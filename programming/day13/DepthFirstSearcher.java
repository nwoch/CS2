

// A class for searching graphs by depth first

public class DepthFirstSearcher<N,W> implements ISearcher<N,W> {

  private INode<N>[] visited;
  private DoubleLinkList<INode<N>> path;
  private int index;

  // Constructor
  public DepthFirstSearcher() {
    visited = (INode<N>[]) new INode[0];
    path = new DoubleLinkList<INode<N>>();
    index = 0;
  }

  // Determines if there is a path without returning the path
  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e) {
    if (s == e) {
      System.out.println("Start and end are the same");
      return false;
    }
    createArray(g);
    if (search(g, s, e) == e) {
      path.append(e);
      System.out.println(e.getValue() + " added");
      return true;
    }
    return false;
  }

  // Searches for path
  public INode<N> search(IGraph<N,W> g, INode<N> s, INode<N> e) {
    for (int i = 0; i < visited.length; i++) {
      if (visited[i] == s) {
        return null;
      }
    }
    visited[index] = s;
    index++;
    path.append(s);
    System.out.println(path.fetch().getValue() + " added");
    if (g.getEdgesFrom(s).length > 0) {
      for (int i = 0; i < g.getEdgesFrom(s).length; i++) {
        if (g.getEdgesFrom(s)[i].getDestination() == e) {
          return e;
        }
        if (search(g, g.getEdgesFrom(s)[i].getDestination(), e) == e) {
          return e;
        }
      }
    }
    path.jumpToTail();
    path.prev();
    System.out.println(path.fetch().getValue() + " removed");
    path.remove();
    return null;
  }

  // Creates an array to store visited nodes
  public void createArray(IGraph<N,W> g) {
    INode<N>[] temporary = (INode<N>[]) new INode[g.getNodeSet().length];
    visited = temporary;
    index = 0;
  }

  // Finds a path based on the properties of the search algorithm.
  // If there is no path in graph g from node s to node e, null should be
  // returned. If node s and node e are the same, an empty list should be returned.
  public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e) {
    DoubleLinkList<INode<N>> temporary = new DoubleLinkList<INode<N>>();
    path = temporary;
    if (s == e || pathExists(g, s, e) == true) {
      return path;
    }
    System.out.println("No path found");
    return null;
  }

  public static void main(String[] argv) throws Exception {
    ISearcher<String, Double> searcher = new DepthFirstSearcher<String, Double>();
    IGraphReader r = new DiGraphReader();
    IGraph<String,Double> g = r.read("graphfile.cs2");
    IList<INode<String>> path = new DoubleLinkList<INode<String>>();
    path = searcher.getPath(g, g.getNodeSet()[0], g.getNodeSet()[5]);
    int size = path.size();
    path.jumpToHead();
    for (int i = 0; i < size; i++) {
      System.out.println("path (start -> node4): " + path.fetch().getValue());
      path.next();
    }
  }

}
