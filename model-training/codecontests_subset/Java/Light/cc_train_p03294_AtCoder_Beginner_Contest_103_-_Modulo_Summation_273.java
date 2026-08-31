import java.util.*;

public class Main {

  public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];

    for (int i = 0; i < N; i++) {
      a[i] = sc.nextInt();
    }

    sc.close(); 

    long max = 0;

    for (int i = 0; i < N; i++) {
      max += a[i] - 1;
    }

    System.out.println(max);

  }

}