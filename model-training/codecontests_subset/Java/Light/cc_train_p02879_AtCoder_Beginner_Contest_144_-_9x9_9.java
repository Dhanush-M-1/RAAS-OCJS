import java.util.*;
public class Main{
  public static void main(String[] args) {
    int a,b;
    Scanner sc=new Scanner(System.in);
    a=sc.nextInt();
    b=sc.nextInt();
    if(a<10&&b<10){
      System.out.println(a*b);
    }else{
      System.out.println(-1);
    }
  }
}
