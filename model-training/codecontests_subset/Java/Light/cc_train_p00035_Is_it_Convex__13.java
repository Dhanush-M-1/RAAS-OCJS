import java.util.Scanner;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in).useDelimiter("[,\n]");
		
		while (true)
		{
			double xa, ya, xb, yb, xc, yc, xd, yd;
			try
			{
				xa = sc.nextDouble();
				ya = sc.nextDouble();
				xb = sc.nextDouble();
				yb = sc.nextDouble();
				xc = sc.nextDouble();
				yc = sc.nextDouble();
				xd = sc.nextDouble();
				yd = sc.nextDouble();
			}
			catch (Exception e)
			{
				break;
			}
			if (inPoint(xb, yb, xc, yc, xd, yd, xa, ya)
				|| inPoint(xc, yc, xd, yd, xa, ya, xb, yb)
				|| inPoint(xd, yd, xa, ya, xb, yb, xc, yc)
				|| inPoint(xa, ya, xb, yb, xc, yc, xd, yd)
			) {
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
		}
	}
	public static boolean inPoint(double x1, double y1, double x2, double y2, double x3, double y3, double xp, double yp)
	{
		if (!((f(x1, y1, x2, y2, x3) < y3 && f(x1, y1, x2, y2, xp) < yp)
			|| (f(x1, y1, x2, y2, x3) > y3 && f(x1, y1, x2, y2, xp) > yp)
		)) {
			return false;
		}
		if (!((f(x2, y2, x3, y3, x1) < y1 && f(x2, y2, x3, y3, xp) < yp)
			|| (f(x2, y2, x3, y3, x1) > y1 && f(x2, y2, x3, y3, xp) > yp)
		)) {
			return false;
		}
		if (!((f(x3, y3, x1, y1, x2) < y2 && f(x3, y3, x1, y1, xp) < yp)
			|| (f(x3, y3, x1, y1, x2) > y2 && f(x3, y3, x1, y1, xp) > yp)
		)) {
			return false;
		}
		return true;
	}
	private static double f(double x1, double y1, double x2, double y2, double x)
	{
		return (y1 - y2) / (x1 - x2) * (x - x1) + y1;
	}
}