/*package whatever //do not write package name here */

import java.io.*;
import java.util.Scanner;


public class Solution {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0){
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        
	        String s = sc.next();
	        char cs[] = s.toCharArray();
	        
	        int[] p  = new int[m];
	        int[] f  = new int[n+2];
	        int[] an  = new int[26];
	        
	        for(int i=0;i<m;i++){
	            p[i]=sc.nextInt();
	            f[1]++;
	            f[p[i]+1]--;
	        }
	        f[1]++;
	        f[n+1]--;

            for(int i=2;i<=n;i++)
                f[i]=f[i]+f[i-1];
            for(int i=1;i<=n;i++)
                an[cs[i-1]-'a']+=f[i];
                
            for(int i=0;i<26;i++)
                System.out.print(an[i]+" ");
            System.out.println();
	    }
	}
}