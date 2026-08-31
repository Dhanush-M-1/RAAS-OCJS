
/**
 * Write a description of class CF114A here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class CF114A
{
   public static void main(String args[])
   {
       Scanner S = new Scanner(System.in);
       int n = S.nextInt();
       int x = S.nextInt();
       int y = S.nextInt();
       int m = (y * n)/ 100;
       if((m * 100) != (y*n))
        m++;
       if(x >= m)
       System.out.println(0);
       else
       System.out.println(m - x);
    }
    
}
