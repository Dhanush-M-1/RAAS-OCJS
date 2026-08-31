import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    String ans = "No";
    int d = (a + b + c) / 2;
    if(d == a) ans = "Yes";
    if(d == b) ans = "Yes";
    if(d == c) ans = "Yes";
    if(((a + b + c) % 2) == 1) ans = "No";
    System.out.println(ans);
  }
}