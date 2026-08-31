import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    int b = input.nextInt();
    String ans = "Odd";
    if (a*b%2==0){
      ans = "Even";
    };
    System.out.println(ans);
  }
}