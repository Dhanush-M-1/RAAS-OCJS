import java.awt.geom.Line2D;
import java.io.*;
import java.math.*;
import java.util.*;

import javax.swing.text.Segment;
public class Main_1_3 {
	public static int x, y;
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	lines = in.readLine().split("\\s+");
	int  n, x1, y1;
	n = Integer.parseInt(lines[0]);
	int c = 1000000;
	x = Integer.parseInt(lines[1])+c;
	y = Integer.parseInt(lines[2])+c;
	double d1;
	double min = Double.MAX_VALUE;
	double max = Double.MIN_VALUE;
	int xs[] = new int[n], ys[] = new int[n];
	for( int i = 0; i < n; i++ )
	{
		lines = in.readLine().split("\\s+");
		xs[i] = Integer.parseInt(lines[0])+c;
		ys[i] = Integer.parseInt(lines[1])+c;
		d1 = Math.hypot(Math.abs(xs[i]-x), Math.abs(ys[i]-y));
		max = Math.max(max, d1);
	}
	for( int i = 0; i < n; i++ )
	{
		min = Math.min(min, dis( xs[i], ys[i], xs[(i+1)%n], ys[(i+1)%n]));
	}
	double result = Math.PI*(max*max-min*min);
	System.out.println(result);
}
public static double dis( int x1, int y1, int x2, int y2)
{
	return Line2D.ptSegDist(x1, y1, x2, y2, x,y);
	

	
}
}
