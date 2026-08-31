import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] h = new int[n];
    int[] g = new int[n];
    for (int j = 0; j < n; j++) {
      h[j] = s.nextInt();
      g[j] = s.nextInt();
    }
    int t = 0;
    for (int j = 0; j < n; j++) {
     for (int k = 0; k < n; k++) {
       if (j == k) continue;
       if (h[j] == g[k]) t++;
     }
    }
    System.out.println(t);
  }
}
