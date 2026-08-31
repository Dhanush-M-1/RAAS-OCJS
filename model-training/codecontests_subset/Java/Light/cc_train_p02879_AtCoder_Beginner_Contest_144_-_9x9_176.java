import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int ans = -1;
    if((a < 10) && (b < 10)) ans = (a * b);
    System.out.println(ans);
  }
}