import java.util.*;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long total = 0;
    int N = sc.nextInt();
    for (int i = 0; i < N; i++) {
      total += sc.nextInt() - 1;
    }
    System.out.println(total);
  }
}
