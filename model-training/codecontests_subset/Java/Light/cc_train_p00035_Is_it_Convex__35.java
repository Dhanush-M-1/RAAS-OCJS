import java.util.Scanner;


public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		for(; scanner.hasNext();)
		{
			float[] x = new float[4];
			float[] y = new float[4];
			
			String input = scanner.next();
			String[] words = input.split(",");
			for(int i=0; i<4; i++)
			{
				x[i] = Float.parseFloat(words[i*2]);
				y[i] = Float.parseFloat(words[i*2+1]);
			}
			
			double angle = 0;
			for(int i=0; i<4; i++)
			{
				int prev=0, next=0;
				switch (i)
				{
					case 0:
						prev = 3;
						next = 1;
						break;
					case 1:
						prev = 0;
						next = 2;
						break;
					case 2:
						prev = 1;
						next = 3;
						break;
					case 3:
						prev = 2;
						next = 0;
						break;
				}
				
				double a = Math.sqrt((x[prev]-x[next])*(x[prev]-x[next]) + (y[prev]-y[next])*(y[prev]-y[next]));
				double b = Math.sqrt((x[prev]-x[i])*(x[prev]-x[i]) + (y[prev]-y[i])*(y[prev]-y[i]));
				double c = Math.sqrt((x[i]-x[next])*(x[i]-x[next]) + (y[i]-y[next])*(y[i]-y[next]));
				double ang = Math.acos((b*b + c*c - a*a) / (2*b*c));
				
				angle += Math.toDegrees(ang);
			}
			
			System.out.println((int)(angle+0.5)==360 ? "YES" : "NO");
		}
	}
}