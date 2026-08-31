import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      int i,n,m,x,y;
      int t=0,a,b,c,c1=0,c2=0;
      Scanner sc=new Scanner(System.in);
      n=sc.nextInt();
      x=sc.nextInt();
      y=sc.nextInt();
      int d=(int)Math.ceil((y*n)/100d);
      //System.out.println(d+" "+x);
      if(d<=x)
      System.out.println("0");
      else
      {
          System.out.println(d-x);
      }
    }
}