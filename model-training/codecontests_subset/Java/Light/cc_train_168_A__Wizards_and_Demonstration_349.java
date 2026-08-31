import java.util.*;


public class Main {
  
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println((int)Math.max(0,(Math.ceil(n*y/100.0)-x)));
  }
}