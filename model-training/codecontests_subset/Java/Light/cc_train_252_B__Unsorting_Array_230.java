import java.io.*;
import java.util.*;


public class CF153B {
	private static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static boolean isSorted(int[] a) {
		boolean oka = true, okb = true;
		for(int i = 1; i < a.length; i++) {
			if(a[i] < a[i-1]) {
				oka = false;
				break;
			}
		}
		
		for(int i = 1;i < a.length; i++) {
			if(a[i] > a[i-1]) {
				okb = false;
				break;
			}
		}
		return oka || okb;
	}
	
	private static String Unsorting(int[] a) {
		
		if(a.length < 3) {
			return "-1";
		}

		for(int i = 0; i < 2; i++) {
			for(int j = i+1; j < a.length; j++) {
				if(a[i] != a[j]) {
					exch(a,i,j);
					if(!isSorted(a)) {
						return (i+1)+" "+(j+1);
					}
					exch(a,i,j);
				}
			}
		}
		return "-1";
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i <n; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		
		String ans = Unsorting(a);
		pr.println(ans);
		pr.flush();
		
	}
	
}	