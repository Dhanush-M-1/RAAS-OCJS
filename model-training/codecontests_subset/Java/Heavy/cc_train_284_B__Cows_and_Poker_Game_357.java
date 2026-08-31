import java.util.*;
import java.io.*;

public class p284B{
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		char[] g = in.readLine().toCharArray();
		Arrays.sort(g);
		int n1 = Arrays.binarySearch(g,'A');
		int n2 = Arrays.binarySearch(g,'F');
		int n3 = Arrays.binarySearch(g,'I');
		int a = n2;
		int f = n3-n2;
		int i = n-n3;
		boolean b1 = (n1<0);
		boolean b2 = (n2<0);
		boolean b3 = (n3<0);
		// System.out.println(Arrays.toString(g));
		// System.out.println(n1+" "+n2+" "+n3);
		if(b1&&b2){
			a = 0;
			f = 0;
			i = n;
		}
		else if(b1&&b3){
			a = 0;
			f = n;
			i = 0;
		}
		else if(b2&&b3){
			a = n;
			f = 0;
			i = 0;
		}
		else if(b1){
			a = 0;
			for(int o = n3-1; o>=0; o--){
				if(g[o]=='F'){
					n3 = o+1;
					break;
				}
			}
			f = n3;
			i = n-n3;
		}
		else if(b2){
			f = 0;
			for(int o = n3-1; o>=0; o--){
				if(g[o]=='A') {
					n3 = o+1;
					break;
				}
			}
			a = n3;
			i = n-n3;
		}
		else if(b3){
			i = 0;
			for(int o = n2-1; o>=0; o--){
				if(g[o]=='A') {
					n2 = o+1;
					break;
				}
			}
			a = n2;
			f = n-n2;
		}
		int ans = -1;
		if(i==0) ans = a;
		else if(i==1) ans = 1;
		else ans = 0;
		// System.out.println(b1+" "+b2+" "+b3);
		// System.out.println(n1+" "+n2+" "+n3);
		// System.out.println(a+" "+f+" "+i);
		System.out.println(ans);
	}
}