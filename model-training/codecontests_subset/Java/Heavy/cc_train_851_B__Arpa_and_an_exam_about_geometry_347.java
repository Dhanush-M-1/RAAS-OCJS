import java.util.*;
public class C{
    public static void main(String []args){
        Scanner s=new Scanner(System.in);
        double a1=s.nextDouble();
        double a2=s.nextDouble();
        double b1=s.nextDouble();
        double b2=s.nextDouble();
        double c1=s.nextDouble();
        double c2=s.nextDouble();
        double m1=Math.abs(a2-b2)/Math.abs(a1-b1);
        double m2=Math.abs(a2-c2)/Math.abs(a1-c1);
        if(m1==m2)
        System.out.println("NO");
        else{
            long x=(long)Math.abs(b1-a1);
            long y=(long)Math.abs(b2-a2);
            long xy=x*x+y*y;
            long dis1=xy;
            
             x=(long)Math.abs(b1-c1);
             y=(long)Math.abs(b2-c2);
             xy=x*x+y*y;
             long dis2=xy;
             if(dis1==dis2)
             System.out.println("YES");
             else
             System.out.println("NO");
        }
    }
}