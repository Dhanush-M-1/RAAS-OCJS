import java.util.*;
public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = 0;

    if(a<=9 && b<=9){
      c = a*b;
      System.out.println(c);
    }else{
      System.out.println(-1);
    }
  }
}
