

import java.util.*;

public class VasiliaTheWise {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean br2 = false;
		int r1 = in.nextInt();
		int r2 = in.nextInt();
		int c1 = in.nextInt();
		int c2 = in.nextInt();
		int d1 = in.nextInt();
		int d2 = in.nextInt();
		int e = 0;
		int f = 0;
		int g = 0;
		int h = 0;
		for (int a = 1; a < 10; a++) {
			for (int b = 1; b < 10; b++) {
				for (int c = 1; c < 10; c++) {
					for (int d = 1; d < 10; d++) {
						if (c + d == r2) {
							if (b + d == c2) {
								if (a + d == d1) {
									if (b + c == d2) {
										if (a + c == c1) {
											if (a + b == r1) {
												br2 = true;
												e += a;
												f += b;
												g += c;
												h += d;
											}
										}
									}
								}
							}
						}
						}
					}
				}
			}
			if (br2 = true) {
									if (e == f) {
										System.out.println("-1");
									}
									else if (e == g) {
										System.out.println("-1");
									}
									else if (e == h) {
										System.out.println("-1");
									}
									else if (f == g) {
										System.out.println("-1");
									}
									else if (f == h) {
										System.out.println("-1");
									}
									else if (g == h) {
										System.out.println("-1");
									}
									else {
										System.out.println(e + " " + f);
										System.out.println(g + " " + h);
									}
						
							
						
					
				
			
		}
		else {
			System.out.println("-1");
		}
		in.close();
	}

}
