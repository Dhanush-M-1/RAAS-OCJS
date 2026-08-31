import java.util.*;

class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    String ans = "Odd";
    if(((a*b)&1)==0) ans = "Even";
    System.out.println(ans);
  }
}