//package cf347;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws FileNotFoundException {
		InputStream is = System.in;
//		is = new FileInputStream(new File("A.txt"));
		Scanner sc = new Scanner(new InputStreamReader(is));
		String t = sc.nextLine();
		t = t.replace(" ", "");
		String tt[] = t.split("=");
		int N = Integer.valueOf(tt[1]);
		int l = (tt[0].length())/2;
		boolean ttt[] = new boolean[l];
//		System.out.println(tt[0]+" "+N+"   "+l);
		int m = 0;
		int p = 0;
		for (int i=0; i<l; i++) {
			if (tt[0].charAt(2*i+1)=='+') {
				p++;
				ttt[i] = true;
			} else 
				m++;
		}
//		System.out.println(Arrays.toString(ttt));
//		System.out.println("minus="+m+" plus="+p);
		int totalP = (p+1)*N;
		int totalM = m;
		///System.out.println(totalP + " " +totalM);
		boolean cond1 = totalP - totalM>=N;
		boolean cond2 = p - N*m <= N;
		if (cond1 && cond2) {
			int tot = 0;
			int tm = 0;
//			l:for (tot=totalP; tot>p; tot--) {
//				for (tm=totalM; tm<=N*m; tm++) {
//					if (tot-tm==N) break l;
//				}
//			}
			for (tot=totalP; tot>=p; tot--) {
				tm = tot-N;
				if (tm<=N*m) break;
			}
			System.out.println("Possible");
			System.out.print(tot/(p+1));
//			String s = +"";
			tot -= tot/(p+1);
			for (int i=0; i<ttt.length; i++) {
				if (ttt[i]==true) {
					System.out.print(" + ");
					System.out.print(tot/p);
//					s+=" + ";
//					s+=tot/p;
					tot-=tot/p;
					p--;
				} else {
					System.out.print(" - ");
//					s+=" - ";
					System.out.print(tm/m);
//					s+=tm/m;
					tm-=tm/m;
					m--;
				}
			}
			System.out.print(" = "+ N);
//			System.out.println(s+" = " + N);
		} else {
			System.out.println("Impossible");
		}
	}

}

