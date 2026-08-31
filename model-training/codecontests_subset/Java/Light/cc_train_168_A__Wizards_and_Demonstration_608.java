import java.util.Scanner;
import java.lang.Math;
public class JavaApplication4 {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      long n=in.nextInt();
      long  x=in.nextInt();
      long y=in.nextInt();
      double a;
      a=Math.ceil((y*n)/100.000);
      if(a>x)
      System.out.print((int)(Math.abs(a-x)));
      else
          System.out.print(0);
    }
    
}
