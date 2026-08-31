import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Scanner;

public class _614C {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       final double INF=1e18;
       int n=sc.nextInt();
       double max,min,ans;
       Point2D.Double P=new Point2D.Double(sc.nextDouble(),sc.nextDouble());
       Point2D.Double points[]=new Point2D.Double[n];
       max=-INF;
       min=INF;
       for(int i=0;i<n;i++)
          points[i]=new Point2D.Double(sc.nextDouble(),sc.nextDouble());
       for(int i=0;i<n;i++){
          max=Math.max(max,points[i].distanceSq(P));
          min=Math.min(min,(new Line2D.Double(points[i],points[(i+1)%n])).ptSegDistSq((P)));
       }
       ans=Math.PI*(max-min);
       System.out.println(ans);
    }
}