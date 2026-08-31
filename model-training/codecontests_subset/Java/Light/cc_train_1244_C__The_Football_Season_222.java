import java.util.Scanner;


public class que3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		long p = scn.nextLong();
		long w = scn.nextLong();
		long d = scn.nextLong();
		for (long i = 0; i < w; i++) {
			long val = (p - i * d);
			if ((val>=0&&(val % w) == 0) && ((val/w + i) <= n)) {
               System.out.println((val/w)+" "+i+" "+(n-(val/w+i)));
               return;
			}
		}
		System.out.println("-1");
	}
}
