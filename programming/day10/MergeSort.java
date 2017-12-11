

// A class that uses a merge sort algorithm to sort an array

public class MergeSort<T extends Comparable> implements ISort<T> {



  public MergeSort() {
  }

  // Merges sorted halves of array
  public T[] merge(T[] a, T[] b) {
    T[] sorted = (T[]) new Comparable[a.length + b.length];
    int a_index = 0;
    int b_index = 0;
    for (int i = 0; i < sorted.length; i++) {
      if (a_index == a.length) {
        sorted[i] = b[b_index];
        b_index++;
      }
      else if (b_index == b.length) {
        sorted[i] = a[a_index];
        a_index++;
      }
      else if (a[a_index].compareTo(b[b_index]) < 0) {
        sorted[i] = a[a_index];
        a_index++;
      }
      else {
        sorted[i] = b[b_index];
        b_index++;
      }
    }
    return sorted;
  }


  // Splits array into halves
  public T[] split(T[] in) { 
    if (in.length > 1) {
      int middle = (int) Math.round((double) in.length / 2);
      T[] a = (T[]) new Comparable[middle];
      int length = 0;
      if (in.length % 2 == 1)
        length = middle - 1;
      else {
        length = middle;
      }
      T[] b = (T[]) new Comparable[length];
      for (int i = 0; i < in.length; i++) {
        if (i < middle) {
          a[i] = in[i];
        }
        else {
          b[i - middle] = in[i];
        }
      }
      T[] new_a = split(a);
      T[] new_b = split(b);
      return merge(new_a, new_b);
    }
    return in;
  }

  // Sorts an array of items in place
  public void sort(T[] in) {
    T[] sorted_array = split(in);
    for (int i = 0; i < sorted_array.length; i++) {
      in[i] = sorted_array[i];
    }
  }

  // Produces the name of the kind of sort implemented
  public String sortName() {
    return "Merge Sort";
  }

  public static void main(String[] argv) {
    MergeSort<String> string_array = new MergeSort<String>();
    MergeSort<Integer> int_array = new MergeSort<Integer>();
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
