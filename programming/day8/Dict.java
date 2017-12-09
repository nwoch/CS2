

// A class that implements a dictionary backed by a list.

public class Dict<K extends Comparable<K>,V> implements IDict<K, V> {

  private DoubleLinkList<DictLink<K, V>> list;
  private DictLink<K, V> curr_cell;

  // Constructor
  public Dict() {
    list = new DoubleLinkList<DictLink<K, V>>();
    curr_cell = null;
  }

  // Adds a value to the dictionary, replacing the existing value if any.
  public V add(K k, V v) {
    list.jumpToHead();
    if (list.size() == 0) {
      DictLink<K, V> new_cell = new DictLink<K, V>(k, v);
      list.append(new_cell);
      return null;
    }
    if (fetch(k) == null) {
      DictLink<K, V> new_cell = new DictLink<K, V>(k, v);
      list.append(new_cell);
      return null;
    }
    V value_replaced = fetch(k);
    curr_cell.setValue(v);
    return value_replaced;
  }

  // Removes a value and key from the dictionary. An unmatched key should return null.
  public V remove(K k) {
    if (fetch(k) == null) {
      return null;
    }
    V value_removed = fetch(k);
    list.remove();
    return value_removed;
  }

  // Returns the size of the dictionary.
  public int size() {
    return list.size();
  }

  // Returns the value associated with a particular key in the dictionary.
  // Returns null if there is no matching key.
  public V fetch(K k) {
    list.jumpToHead();
    list.next();
    curr_cell = list.fetch();
    while (!curr_cell.getKey().equals(k)) {
      list.next();
      curr_cell = list.fetch();
      if (curr_cell == null) {
        return null;
      }
    }
    return curr_cell.getValue();
  }

  // Returns an array of the keys in the dictionary.
  public K[] keys() {
    int size = size();
    K[] array = (K[]) new Comparable[size];
    list.jumpToHead();
    for (int i = 0; i < size; i++) {
      list.next();
      curr_cell = list.fetch();
      array[i] = curr_cell.getKey();
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
