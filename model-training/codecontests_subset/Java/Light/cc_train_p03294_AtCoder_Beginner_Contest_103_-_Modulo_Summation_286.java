import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int max = 0;
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      max += num;
    }
    System.out.println(max - n);
  }
}