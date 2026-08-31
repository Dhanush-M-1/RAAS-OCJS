import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt(), B = sc.nextInt();
    System.out.println(A < 10 && B < 10 ? A * B: -1);
  }
}