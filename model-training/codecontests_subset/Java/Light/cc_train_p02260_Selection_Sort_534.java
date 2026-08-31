import java.util.Scanner;

public class Main {
  static int selectionSort(int[] a, int n) {
    int sw = 0;
    for (int i = 0; i < n; i++) {
      int minj = i;
      for (int j = i; j < n; j++) 
        if (a[j] < a[minj]) 
          minj = j;
      int t = a[i];
      a[i] = a[minj];
      a[minj] = t;
      if (minj != i) sw++;
    }
    return sw;
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = stdIn.nextInt();
    int sw = selectionSort(a, n);
    for (int i = 0; i < n; i++) {
      System.out.print(a[i]);
      if (i != n - 1) System.out.print(' ');
      else System.out.println();
    }
    System.out.println(sw);
  }
}