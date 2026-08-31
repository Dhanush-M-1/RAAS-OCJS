import java.util.Scanner;

public class mainC {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		long n, p, w, d;
		
		n = scan.nextLong();
		p = scan.nextLong();
		w = scan.nextLong();
		d = scan.nextLong();
		
		long x;
		int y = 0;
		
		while( y < w && (p - d * y) % w != 0) {
			y++;
			//System.out.println("ASD"  + y);
		}
		
		if( y < w) {
			x = (p - d * y) / w;
			if(n >= x + y && x >= 0 && y >= 0)
				System.out.println(x + " " + y + " " + (n - x - y));
			else
				System.out.println(-1);
		}
		
		else
			System.out.println(-1);
	}

}
