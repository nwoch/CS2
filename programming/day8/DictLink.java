

// A class that implements list nodes for a dictionary, containing a key and value, as well as other methods for nodes in a binary search tree

public class DictLink<K,V> {

  private K key;
  private V value;
  private DictLink<K,V> left;
  private DictLink<K,V> right;
  private DictLink<K,V> parent;

  // Constructor
  public DictLink(K k, V v) {
    key = k;
    value = v;
  }

  // Gets the key for this link cell
  public K getKey() {
    return key;
  }

  // Gets the current value for this link cell
  public V getValue() {
    return value;
  }

  // Sets the current value for this link cell
  public void setValue(V v) {
    value = v;
  }

  // Sets the parent of this node (tree)
  public void setParent(DictLink<K,V> n) {
    parent = n;
  }

  // Sets the left child for this node (tree)
  public void setLeft(DictLink<K,V> n) {
    left = n;
  }

  // Sets the right child for this node (tree)
  public void setRight(DictLink<K,V> n) {
    right = n;
  }

  // Gets the parent of this node (tree)
  public DictLink<K,V> getParent() {
    return parent;
  }

  // Gets the left child for this node (tree)
  public DictLink<K,V> getLeft() {
    return left;
  }

  // Gets the right child for this node (tree)
  public DictLink<K,V> getRight() {
    return right;
  }

  // Checks to see if current node is a leaf (tree)
  public boolean isLeaf() {
    if (getLeft() == null && getRight() == null) {
      return true;
    }
    return false;
  }

}
