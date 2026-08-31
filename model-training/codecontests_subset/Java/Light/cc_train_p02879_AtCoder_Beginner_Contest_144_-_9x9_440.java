import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int X = scan.nextInt();
    int Y = scan.nextInt();
    if (X > 9 | Y > 9){
      System.out.println(-1);
    } else{
      System.out.println(X * Y);
    }
  }
}