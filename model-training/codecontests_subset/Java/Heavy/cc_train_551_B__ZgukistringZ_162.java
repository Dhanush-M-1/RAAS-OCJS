import java.util.*;

import java.io.*;

public class PB {
	
	public static int findmin(int[] a, int[] c){
		int min = 100000;
		for(int i = 0 ;i<a.length;i++){
			
			if (c[i]!=0) min = Math.min(a[i] / c[i],min);
		}
		return min;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer a = new StringBuffer();
		a.append(in.readLine());
		StringBuffer b = new StringBuffer();
		b.append(in.readLine());
		StringBuffer c = new StringBuffer();
		c.append(in.readLine());
		in.close();
		int[] ar = new int[26];
		for (int i = 0 ;i<a.length();i++){
			int k = a.charAt(i)-'a';
			ar[k] ++;
		}
		
		int[] br = new int[26];
		for (int i = 0 ;i<b.length();i++){
			int k = b.charAt(i)-'a';
			br[k] ++;
		}
		int[] cr = new int[26];
		for (int i = 0 ;i<c.length();i++){
			int k = c.charAt(i)-'a';
			cr[k] ++;
		}
		
		int max = 0;
		StringBuilder res=new StringBuilder();
		int bmax = 0;
		int cmax = 0;
		int[] ary = ar.clone();
		loops:
		for (int i = 0 ;i<100000;i++){
			int min = findmin(ary,cr);
			
			if (min+i>max) {
				max = min+i;
				bmax = i;
				cmax = min;
				
			}
			for(int j=0; j<26; j++){
				ary[j] -= br[j];
				if(ary[j] < 0){
					break loops;
				}
			}	
		}
		if (max == 0) {
			System.out.println(a);
		}
		else{

			for (int j = 0; j<bmax;j++){
				res.append(b);
			}

			for (int j = 0; j<cmax;j++){
				res.append(c);
			}
			for (int j = 0; j<ar.length;j++){
				if (ar[j]!=0){
					for(int k = 0; k<ar[j] - bmax * br[j] - cmax * cr[j]; k++)
						res.append((char)(j+'a'));
				}
			}
			System.out.println(res);	
		}

	}
}
