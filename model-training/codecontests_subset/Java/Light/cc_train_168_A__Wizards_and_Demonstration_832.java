import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int x=sc.nextInt();
      int y=sc.nextInt();
      double k=Math.ceil(y*0.01*n);
      if(k-x<0)
      System.out.println(0);
      else
      System.out.format("%.0f",k-x);
    }
}