import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class B20
{
	private static DecimalFormat df10 = new DecimalFormat(".##########");
    public static void main(String[] args) 
      {
        int a, b, c;
        double root1, root2, d;
        Scanner s = new Scanner(System.in);
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();
        d = (double)b * (double)b - (double)4 *(double) a *(double) c;
       //System.out.println(d);
        if(a==0 && b!=0 && c!=0)
        {
        	System.out.println("1");
        	System.out.println((double)((double)-c/(double)b));
        }
        else if(a==0 && b==0 && c!=0)
        	System.out.println(0);
        else if(a==0 && b==0 && c==0)
        	System.out.println(-1);
        else if((c==0 && b==0) || (c==0 && a==0) ){
        	System.out.println(1);
        	System.out.println(0);
        }
        else if(d > 0)
        {
        	System.out.println(2);
            root1 = ((double)-b + (double)Math.sqrt(d))/((double)(2*a));
            root2 = ((double)-b - (double)Math.sqrt(d))/(double)((2*a));
            if(root1>root2){
            	System.out.println(root2);
            	System.out.println(root1);
            }
            else{
            	System.out.println(root1);
            	System.out.println(root2);
            }
        }
        else if(d == 0)
        {
           System.out.println(1);
            root1 = (-b+Math.sqrt(d))/(2*a);
            System.out.println(df10.format(root1));
        }
        else
        {
            System.out.println(0);
        }
    }
}