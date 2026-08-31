import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

public class B {
	public static void main(String[] args) throws Throwable{
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int[] a=new int[26]; 
		int[] b=new int[26];
		int[] c=new int[26];
		char[] A=in.readLine().trim().toCharArray();
		char[] B=in.readLine().trim().toCharArray();
		char[] C=in.readLine().trim().toCharArray();
		for(int i=0;i<A.length;i++)
			a[A[i]-'a']++;
		for(int i=0;i<B.length;i++)
			b[B[i]-'a']++;
		for(int i=0;i<C.length;i++)
			c[C[i]-'a']++;
		int bs=0, cs=0;
		for(int i=0;i<100000;i++) {
			boolean ws=true;
			for(int j=0;j<26;j++) {
				a[j]-=b[j]*i;
				if(a[j]<0)
					ws=false;
			}
			if(ws) {
				int cc=can(a, c);
				if(cc+i>bs+cs) {
					bs=i;
					cs=cc;
				}
			}				
			for(int j=0;j<26;j++) 
				a[j]+=b[j]*i;
			if(!ws)
				break;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<bs;i++)
			sb.append(new String(B));
		for(int i=0;i<cs;i++)
			sb.append(new String(C));
		for(int j=0;j<26;j++) 
			a[j]-=b[j]*bs;
		for(int j=0;j<26;j++) 
			a[j]-=c[j]*cs;
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[i];j++)
				sb.append((char)(i+'a'));
		System.out.println(new String(sb));
	}
	
	static int can(int[] a, int b[]) {
		int min=10000000;
		for(int i=0;i<a.length;i++)
			if(b[i]>0) {
				min=Math.min(min, a[i]/b[i]);
			}
		return min;
	}
}
