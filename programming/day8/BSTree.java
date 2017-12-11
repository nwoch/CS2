

// A class that implements a dictionary backed by a binary search tree.

public class BSTree<K extends Comparable<K>,V> implements IDict<K, V> {

  private DictLink<K, V> curr_cell;
  private DictLink<K, V> root;
  private int size;
  private K[] array;

  // Constructor
  public BSTree() {
    curr_cell = null;
    root = null;
    size = 0;
    array = (K[]) new Comparable[0];
  }

  // Adds a value to the dictionary, replacing the existing value if any.
  public V add(K k, V v) {
    DictLink<K, V> new_cell = new DictLink<K, V>(k, v);
    if (root == null) {
      root = new_cell;
      return null;
    }
    if (fetch(k) == null) {
      if (k.compareTo(curr_cell.getKey()) < 0) {
        curr_cell.setLeft(new_cell);
      }
      else {
        curr_cell.setRight(new_cell);
      }
      new_cell.setParent(curr_cell);
      return null;
    }
    V value_replaced = fetch(k);
    curr_cell.setValue(v);
    return value_replaced;
  }

  // Removes a value and key from the dictionary. An unmatched key should return null.
  // (wrote method independently, but occasionally looked at Dan's Tree.java code to make sure I was on the right track)
  public V remove(K k) {
    curr_cell = root;
    // If unmatched key
    if (fetch(k) == null) {
      return null;
    }
    V value_removed = fetch(k);
    DictLink<K, V> parent = curr_cell.getParent();
    // Case 1: no children, remove the node
    if (curr_cell.isLeaf()) {
      if (parent.getRight() == curr_cell) {
        parent.setRight(null);
      }
      else {
        parent.setLeft(null);
      }
      curr_cell.setParent(null);
    }
    // Case 2: 1 child, replace node with child
    else if (curr_cell.getRight() == null || curr_cell.getLeft() == null) {
      if (curr_cell.getRight() == null) {
        curr_cell.getLeft().setParent(parent);
        if (parent.getRight() == curr_cell) {
          parent.setRight(curr_cell.getLeft());
        }
        else {
          parent.setLeft(curr_cell.getLeft());
        }
        curr_cell.setLeft(null);
      }
      else {
        curr_cell.getRight().setParent(parent);
        if (parent.getRight() == curr_cell) {
          parent.setRight(curr_cell.getRight());
        }
        else {
          parent.setLeft(curr_cell.getRight());
        }
        curr_cell.setRight(null);
      }
      curr_cell.setParent(null);
    }
    // Case 3: 2 children - go right once, then go left until you can't and remove that leaf, then replace the root value with that leaf's value
    else {
      DictLink<K, V> cell_to_remove = curr_cell;
      curr_cell = curr_cell.getRight();
      while (!curr_cell.isLeaf()) {
        curr_cell = curr_cell.getLeft();
      }
      // remove leaf
      if (parent.getRight() == curr_cell) {
        parent.setRight(null);
      }
      else {
        parent.setLeft(null);
      }
      curr_cell.setParent(null);
      // replace cell to remove with leaf value removed
      curr_cell.setRight(cell_to_remove.getRight());
      curr_cell.setLeft(cell_to_remove.getLeft());
      if (parent.getRight() == cell_to_remove) {
        parent.setRight(curr_cell);
      }
      else {
        parent.setLeft(curr_cell);
      }
      cell_to_remove.getRight().setParent(curr_cell);
      cell_to_remove.getLeft().setParent(curr_cell);
      cell_to_remove.setRight(null);
      cell_to_remove.setLeft(null);
      cell_to_remove.setParent(null);
    }
    return value_removed;
  }

  // Returns the size of the dictionary.
  public int size() {
    return traverse(root);
  }

  // Pre-order traversal of tree
  public int traverse(DictLink<K,V> node) {
    array[size] = root.getKey();
    size++;
    traverse(root.getLeft());
    traverse(root.getRight());
    return size;
  }

  // Returns the value associated with a particular key in the dictionary.
  // Returns null if there is no matching key.
  public V fetch(K k) {
    curr_cell = root;
    while (!curr_cell.getKey().equals(k)) {
      if (k.compareTo(curr_cell.getKey()) < 0) {
        if (curr_cell.getLeft() == null) {
          return null;
        }
        curr_cell = curr_cell.getLeft();
      }
      else {
        if (curr_cell.getRight() == null) {
          return null;
        }
        curr_cell = curr_cell.getRight();
      }
      if (!curr_cell.getKey().equals(k) && curr_cell.isLeaf()) {
        return null;
      }
    }
    return curr_cell.getValue();
  }

  // Creates array for keys() method
  public void createArray() {
    K[] temporary = (K[]) new Comparable[size()];
    array = temporary;
  }

  // Returns an array of the keys in the dictionary.
  public K[] keys() {
    createArray();
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
    return array;
  }

  public static void main(String[] argv) {
    Dict<String, Integer> dictionary = new Dict<String, Integer>();
    System.out.println(dictionary.size());
    System.out.println(dictionary.add("frog", 2));
    System.out.println(dictionary.add("cat", 5));
    System.out.println(dictionary.add("cat", 1));
    System.out.println(dictionary.add("pig", 3));
    System.out.println(dictionary.add("rat", 7));
    System.out.println(dictionary.add("mouse", 7));
    System.out.println(dictionary.add("bat", 7));
    System.out.println(dictionary.add("dog", 7));
    dictionary.keys();
    System.out.println(dictionary.fetch("cat"));
    System.out.println(dictionary.fetch("dog"));
    System.out.println(dictionary.remove("horse"));
    System.out.println(dictionary.remove("cat"));
    System.out.println(dictionary.remove("pig"));
    System.out.println(dictionary.remove("frog"));
    System.out.println(dictionary.size());
    System.out.println(dictionary.add("horse", 7));
    dictionary.keys();
    System.out.println(dictionary.size());
  }

}
