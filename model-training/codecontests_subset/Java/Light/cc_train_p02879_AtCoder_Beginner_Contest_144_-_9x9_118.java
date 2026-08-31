import java.util.*;
public class Main{
  public static void main(String[]args){
  	Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int ans = -1;
    if(a<=9&&b<=9)ans = a*b;
    System.out.println(ans);
  }
}