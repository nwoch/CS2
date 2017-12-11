

// A class that uses a selection sort algorithm to sort an array

public class SelectSort<T extends Comparable> implements ISort<T> {

  public SelectSort() {
  }

  // Sorts an array of items in place
  public void sort(T[] in) {
    T min = null;
    int min_index = 0;
    T swap_value = null;
    for (int i = 0; i < in.length; i++) {
      min = in[i];
      min_index = i;
      for (int j = i; j < in.length; j++) {
        if (in[j].compareTo(min) < 0) {
          min = in[j];
          min_index = j;
        }
      }
      swap_value = in[i];
      in[i] = min;
      in[min_index] = swap_value;
    }
  }

  // Produces the name of the kind of sort implemented
  public String sortName() {
    return "Select Sort";
  }

  public static void main(String[] argv) {
    SelectSort<String> string_array = new SelectSort<String>();
    SelectSort<Integer> int_array = new SelectSort<Integer>();
    Integer[] array1 = {15, 2, 5, 3, 1, 12};
    String[] array2 = {"cat", "apple", "dog", "zoo", "rat"};
    string_array.sort(array2);
    int_array.sort(array1);
    for (int i = 0; i < array1.length; i++) {
      System.out.println(array1[i]);
    }
    for (int i = 0; i < array2.length; i++) {
      System.out.println(array2[i]);
    }
    System.out.println(string_array.sortName());
  }

}
