import java.util.*;
import java.math.BigInteger;
public class sol{

   
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int x=s.nextInt();
        int y=s.nextInt();
        System.out.println((int)(Math.ceil(n*y*0.01)-x)<0?0:(int)(Math.ceil(n*y*0.01)-x));
}
   
}


