import java.awt.Point;
import java.util.*;
import java.math.*;
import java.awt.geom.*;
/**
 *
 * @author sarthak
 */
public class rnd339_C {
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int px=s.nextInt();
        int py=s.nextInt();
        double mx=Double.MIN_VALUE;
        double mn=Double.MAX_VALUE;
     //   System.out.println(mx + "  "  + mn);
        int[] X=new int[n];
        int[] Y=new int[n];
        for(int i=0;i<n;i++)
        {
            int x=s.nextInt();
            int y=s.nextInt();
            mx=Math.max(mx, (double)((double)(px-x)*(double)(px-x))+(double)((double)(py-y)*(double)(py-y)));
            X[i]=x;Y[i]=y;
           //mn=Math.min(mn,(px-x)*(px-x)+(py-y)*(py-y));
        }
        for(int i=0;i<n;i++){
            Point2D p1=new Point2D.Double(X[i], Y[i]);
            Point2D p2=new Point2D.Double(X[(i+1)%n], Y[(i+1)%n]);
            Line2D l=new Line2D.Double(p1, p2);
            mn=Math.min(mn,l.ptSegDistSq(px, py));
        }
       //  System.out.println(mx + "  "  + mn);
        System.out.printf("%.12f", Math.PI*(mx-mn));
        System.out.println();
        
        
        
       
    }
    
}
