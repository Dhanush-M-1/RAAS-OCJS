import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] a = new int[n];
    int count = 0;
    Outer:
      for (int i = 0; i < n; i++) {
        a[i] = stdIn.nextInt();
        if (a[i] < 2) continue;
        if (a[i] == 2) {
          count++;
          continue;
        }
        if (a[i] % 2 == 0) continue;
        for (int j = 3; j <= a[i] / j; j+= 2) {
          if (a[i] % j == 0) continue Outer;
        }
        count++;
      }
    System.out.println(count);
  }
}