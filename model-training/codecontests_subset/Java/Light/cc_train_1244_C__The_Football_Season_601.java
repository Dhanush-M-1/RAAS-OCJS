import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		long p = Long.parseLong(sc.next());
		int w_a = Integer.parseInt(sc.next());
		int d_a = Integer.parseInt(sc.next());
		long w = (long)w_a;
		long d = (long)d_a;

		long w_tmp = -1;
		long gcd = (long)gcd(w_a, d_a);
		if (p%gcd!=0) {
			System.out.println(-1);
		} else {
			for (int i=0;i<d;i++) {
				if ((p-w*i)%d==0) {
					w_tmp = i;
					break;
				}
			}
			// System.out.println("w_tmp" + w_tmp);
			// long remainder = (int)Math.floor(p-w*w_tmp)/(w*d/gcd); // nokori
			long remainder = (p-w*w_tmp)/(w*d/gcd); // nokori
			long w_max = w_tmp + d/gcd*remainder;
			long d_min = (p-w*w_max)/d;
			// System.out.println("W_Max" + w_max + " d_min" + d_min);
			// int max = (int)Math.ceil((p-w*w_tmp)/(w*d/gcd)/(w-d)); //long
			// System.out.println("max" + max);
			// System.out.println(d/gcd);
			// System.out.println("remainder" + remainder);
			if (w_max+d_min<=n && w_max>=0 && d_min>=0 && (w_tmp!=-1)) {
				System.out.println(w_max + " " + d_min + " " + (n-w_max-d_min));
			} else {
				System.out.println(-1);
			}
		}
	}

	static int gcd(int a,int b) {
	    int temp;
	    while ((temp=a%b)!=0) {
	        a=b;
	        b=temp;
	    }
	    return b;
	}
}