import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p016 {
	public static void main(String args[]) throws Exception {
//		StringTokenizer stok = new StringTokenizer(new Scanner(new File("C:/Users/Arunkumar/Downloads/input.txt")).useDelimiter("\\A").next());
		StringTokenizer stok = new StringTokenizer(new Scanner(System.in).useDelimiter("\\A").next());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(stok.nextToken());
		while(t-->0) {
			int n = Integer.parseInt(stok.nextToken());
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(stok.nextToken());
			}
			int i=-1;
			int v = a[0];
			int g=0,s=0,b=0;
			while(++i<n && a[i]==v) g++;
			while(i<n && s<=g) {
				v = a[i];
				i--;
				while(++i<n && a[i]==v) s++;
			}
			int j=n/2;
			v=a[n/2];
			while(--j>=0 && a[j]==v);
			b = j+1-s-g;
//			System.out.println(g+" "+s+" "+b);
			if(g>0 && s>0 && b>0 && g<s && g<b) sb.append(g+" "+s+" "+b+"\n");
			else sb.append("0 0 0\n");
		}
		System.out.println(sb);
	}
}