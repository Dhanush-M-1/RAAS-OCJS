import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int[] a = { 0, 1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51 };
    Scanner scan = new Scanner(System.in);
    int S = scan.nextInt();
    System.out.println(a[S]);
  }
}