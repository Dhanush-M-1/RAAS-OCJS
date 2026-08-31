
import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder out = new StringBuilder(); 
		while(t-->0) {
			
			int n = sc.nextInt() , m = sc.nextInt(); 
			String s = sc.next();
			int[][]c = new int[n][26];
			
			for(int i = 0;i<n;i++) {
				if(i!=0){
					for(int j=0;j<26;j++) {
						c[i][j] = c[i-1][j];
					}
				}
				c[i][s.charAt(i)-'a']++;
			}
			int[] r = new int[26];
			while(m-->0) {
				int  p = sc.nextInt();
				--p;
				for(int i = 0 ; i <26;i++) {
					r[i]+=c[p][i];
				}
				
			}
			for(int i = 0 ; i <26;i++) {
				r[i]+=c[n-1][i];
			}
			for(int i=0;i<26;i++) {
				out.append(r[i]+" ");
			}
			out.append("\n");
		}
		
		System.out.println(out);
		
	}

}	