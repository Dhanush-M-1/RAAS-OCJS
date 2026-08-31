//package Div2A;

import java.util.Scanner;

public class helpVasilisaTheWise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();int r2 = sc.nextInt(); int c1 = sc.nextInt(); int c2 = sc.nextInt();int d1 = sc.nextInt(); int d2 = sc.nextInt();

		int total = r1+r2+c1+c2+d1+d2;

		int x, y, z, w;

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int j2 = 1; j2 <= 9; j2++) {
					for (int k = 1; k <= 9; k++) {
						if(3*i + 3*j + 3*j2 + 3*k ==total && (j !=i &&  j2!=i && k!=i &&j!=j2 && j!=k && j2!=k)) {
							if(r1==i+j && r2==j2+k && c1==i+j2 && c2==j+k && d1==i+k && d2==j+j2) {
							System.out.println(i + " " + j + "\n" + j2 + " " + k);
							return;
							}
						}
					}
				}

			}
		}
		System.out.println(-1);

	}

}
