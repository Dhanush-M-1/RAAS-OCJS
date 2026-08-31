import java.util.Scanner;
import java.io.PrintWriter;
public class D92 {
	static Scanner in = new Scanner(System.in);
	static PrintWriter w = new PrintWriter(System.out, true);

	static int ni() {
		return in.nextInt();
	}

	static String nl() {
		return in.nextLine();
	}

	public static void main(String[] args) {
		int a = ni(), b = ni(), x1 = ni(), y1 = ni(), x2 = ni(), y2 = ni();
		int cx1 = (x1-y1)/(2*b), cy1 = (x1+y1)/(2*a); 
		int cx2 = (x2-y2)/(2*b), cy2 = (x2+y2)/(2*a);
		int d1 = Math.abs(cx1-cx2), d2 = Math.abs(cy1-cy2);
		if ((x1-y1)*Math.signum(x2-y2) < 0.01) {
			d1++;
		}
		if ((x1+y1)*Math.signum(x2+y2) < 0.01) {
			d2++;
		}
		int ddd = Math.max(d1, d2);
		w.println(ddd);
	}
}
