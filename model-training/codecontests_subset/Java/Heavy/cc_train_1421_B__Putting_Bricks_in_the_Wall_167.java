

import java.util.Scanner;

public class CodeForces1810 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i<t; i++) {
			System.out.println(algo(sc));
		}
	}
	
	public static String algo(Scanner sc) {
		int n = sc.nextInt();
		char[][] m = new char[n][n];
		for(int i = 0; i<n; i++) {
			String s = sc.next();
			for(int j = 0; j<n; j++) {
				m[i][j] = s.charAt(j);
			}
		}
		StringBuilder a = new StringBuilder("");
		a.append(m[0][1]);
		a.append(m[1][0]);
		a.append(m[n-2][n-1]);
		a.append(m[n-1][n-2]);
		StringBuilder r = new StringBuilder("");
		
		int[] a1 = transform(a, "1100");
		int[] a2 = transform(a, "0011");
		int[] q = a1[0]<=a2[0]?a1:a2;
		
		if(q[0]==0)
			return "0 ";
		else
			r.append(q[0] + " ");
		
		for(int i = 1; i<1+q[0]; i++) {
			if(q[i]==0)
				r.append("1 2 ");
			else if(q[i]==1)
				r.append("2 1 ");
			else if(q[i]==2)
				r.append((n-1) + " " + (n) + " ");
			else if(q[i]==3)
				r.append((n) + " " + (n-1) + " ");
		}
		r.append("\n");
		return r.toString();
	}
	
	public static int[] transform(StringBuilder a, String o) {
		int[] r = new int[8];
		int g = 1;
		for(int i = 0; i<4; i++) {
			if(a.charAt(i)!=o.charAt(i)) {
				r[0]++;
				r[g++]=i;
			}
		}
		return r;
	}
}
