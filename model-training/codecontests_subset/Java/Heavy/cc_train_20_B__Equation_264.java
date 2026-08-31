import java.util.*;
import java.text.DecimalFormat;
// warm-up
public class Equation {

	static void solve() {
		Scanner sc = new Scanner(System.in);
		double a=sc.nextDouble(), b=sc.nextDouble(), c=sc.nextDouble();
		double[] r = {0,0}; boolean change=false;
		if (a==0 || b==0 || c==0) {
			if (b!=0 && c!=0) {
				System.out.println(1+"\n"+(-c/b)); change=true;
			}
			else if (a==0 && c==0 && b!=0) {
				System.out.println(1+"\n"+new DecimalFormat("#0.0000000000").format(0));
				change=true;
			}
			else if (c==0 && a!=0 && b!=0) {
				System.out.println(2);
				if (-(b/a)>0) {
					System.out.println(new DecimalFormat("#0.0000000000").format(0));
					System.out.println(new DecimalFormat("#0.0000000000").format(-(b/a)));
				} else {
					System.out.println(new DecimalFormat("#0.0000000000").format(-(b/a)));
					System.out.println(new DecimalFormat("#0.0000000000").format(0));
				}
				change=true;
			}
		}
		if (!change) {
			if (a==0 && b==0 && c==0) System.out.println(-1);
			else {
				r[0]=((-b)+Math.sqrt((b*b)-(4*a*c)))/(2*a);
				r[1]=((-b)-Math.sqrt((b*b)-(4*a*c)))/(2*a);
				if (Double.isNaN(r[0])||Double.isNaN(r[1])) System.out.println(0);
				else if (Double.isInfinite(r[0])||Double.isInfinite(r[1])) System.out.println(-1);
				else {
					System.out.println(r[0]==r[1] ? 1 : 2);
					if (r[0]>r[1]) {
						System.out.println(new DecimalFormat("#0.0000000000").format(r[1]));
						System.out.println(new DecimalFormat("#0.0000000000").format(r[0]));
					} else {
						System.out.println(new DecimalFormat("#0.0000000000").format(r[0]));
						if (r[0]!=r[1]) System.out.println(new DecimalFormat("#0.0000000000").format(r[1]));
					}
				}
			}
		} 
		sc.close();			
	}

	public static void main(String args[]) {
		solve();
	}

}