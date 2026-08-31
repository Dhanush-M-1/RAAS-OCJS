import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
 
public class SnowBlower {
	int x,y;
	SnowBlower(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<SnowBlower> sb = new ArrayList<SnowBlower>();
		int N = sc.nextInt();
		int Ox = sc.nextInt();
		int Oy =sc.nextInt();
		for(int i =1; i<=N;i++)
		{
			int x=sc.nextInt()-Ox;
			int y = sc.nextInt()-Oy;
			SnowBlower p= new SnowBlower(x, y);
			sb.add(p);
		}
		double c=9e12;
		double f =0;
		for(int i=0; i<sb.size(); i++)
		{
			int x1 = sb.get(i).x;
			int y1 = sb.get(i).y;
			int x2 = sb.get((i+1)%N).x;
			int y2 = sb.get((i+1)%N).y;
			//System.out.println("x1: "+x1+" y1: "+y1+" x2: "+x2+" y2: "+y2);
			if(dotProduct(x1,y1,x1-x2,y1-y2)>=0&&dotProduct(x2,y2,x2-x1,y2-y1)>=0) {
				c=Math.min(c,Math.abs(crossProduct(x1,y1,x2,y2)/Math.hypot(x1-x2, y1-y2)));
			}
			else {
				double c1=Math.min(Math.hypot(x1, y1), Math.hypot(x2, y2));
				c=Math.min(c, c1);
			}
			f = Math.max(f, Math.hypot(x1, y1));
			
		}
		//System.out.println("c: "+c+", "+"f: "+f);
		System.out.println(Math.abs((Math.abs(c*c)-Math.abs(f*f))*Math.PI));
	}
	public static long dotProduct(long x1, long y1, long x2, long y2)
	{
	 return x1*x2+y1*y2;
	}
	public static long crossProduct(long x1, long y1, long x2, long y2)
	{
	 return x1*y2-x2*y1; 
	}
	
}