import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int c = in.nextInt();
    int p = in.nextInt();
    int[] v = new int[] {p, in.nextInt()};
    int a = in.nextInt(), l = in.nextInt(), n = 1;

    while (p < c) {
      v[0] = Math.min(v[1], v[0] + a);
      p += v[0] - l;
      n++;
    }

    System.out.format("%d\n", n);
  }
}
