import java.util.Scanner;


public class Prob74 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r1 = s.nextInt();
		int r2 = s.nextInt();
		int c1 = s.nextInt();
		int c2 = s.nextInt();
		int d1 = s.nextInt();
		int d2 = s.nextInt();
		s.close();
		int x11;
		int x12;
		int x21;
		int x22;
		
		for (int i = 1; i < Math.min(10, Math.min(r1, Math.min(c1, d1))); i++) {
			x11 = i;
			x12 = r1 - x11;
			x21 = c1 - x11;
			x22 = d1 - x11;
			if (x21 + x22 == r2 && x12 + x22 == c2 && x12 + x21 == d2 && 
					x11 != x12 && x11 != x21 && x11 != x22 && 
					x12 != x21 && x12 != x22 && 
					x21 != x22 &&
					
					x12 < 10 && x21 < 10 && x22 < 10) {
				System.out.println(x11 + " " + x12);
				System.out.println(x21 + " " + x22);
				System.exit(0);
			}
		}
		System.out.println(-1);
		
	}
	
	
}
