import java.util.*;
// warm-up
// Good riddance manhattan. No more manhattan new york california please.
public class Main {

	static class Point {
		int x=0, y=0;
		Point (int a, int b) {
			x=a; y=b;
		}
	}

	static void solve() {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt(), t=0, i=0;
		Point[] a = new Point[n];
		Point[] b = new Point[m];
		t=n;
		while (t-->0) a[i++] = new Point(sc.nextInt(), sc.nextInt()); 
		t=m; i=0;
		while (t-->0) b[i++] = new Point(sc.nextInt(), sc.nextInt()); 
		for (Point d : a) {
			int min=Integer.MAX_VALUE, j=0; i=1;
			for (Point c : b) {
				if ((Math.abs(d.x-c.x)+Math.abs(d.y-c.y))<min) {
					min = Math.abs(d.x-c.x)+Math.abs(d.y-c.y);
					j=i;
				}
				i++;
			}
			System.out.println(j);
		}
		sc.close();			
	}

	public static void main(String args[]) {
		solve();
	}

}