import java.util.*;
import java.awt.geom.*;

public class Main{
 public static void main(String[] args){
  Scanner ir=new Scanner(System.in);
  int n=ir.nextInt();
  double X=ir.nextDouble(),Y=ir.nextDouble();
  double[] x=new double[n],y=new double[n];
  double ma=0.0,mi=1e18;
  for(int i=0;i<n;i++){
   x[i]=ir.nextDouble()-X;
   y[i]=ir.nextDouble()-Y;
   ma=ma=Math.max(ma,x[i]*x[i]+y[i]*y[i]);
  }
  for(int i=0;i<n;i++){
   Line2D.Double l=new Line2D.Double(x[i],y[i],x[(i+1)%n],y[(i+1)%n]);
   mi=Math.min(mi,l.ptSegDistSq(0.0,0.0));
  }
  System.out.printf("%.9f\n",(ma-mi)*Math.PI);
 }
}