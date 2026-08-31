import java.util.*;
import java.io.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
public class c 
{
	public static void main(String[] arg)
	{
		new c();
	}
	public c()
	{
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		Point2D p = new Point2D.Double(in.nextInt(), in.nextInt());
		Point2D[] arr = new Point2D[n];
		for(int i = 0; i < n; i++) arr[i] = new Point2D.Double(in.nextInt(), in.nextInt());
		double min = Integer.MAX_VALUE;
		double max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++)
		{
			int j = (i+1)%n;
			Line2D l = new Line2D.Double(arr[i], arr[j]);
			min = Math.min(min, l.ptSegDist(p));
			min = Math.min(min, p.distance(arr[i]));
			min = Math.min(min, p.distance(arr[j]));
			
			max = Math.max(max, l.ptSegDist(p));
			max = Math.max(max, p.distance(arr[i]));
			max = Math.max(max, p.distance(arr[j]));
		}
		
		out.println(Math.PI*(max*max-min*min));
		in.close(); out.close();
	}
}
