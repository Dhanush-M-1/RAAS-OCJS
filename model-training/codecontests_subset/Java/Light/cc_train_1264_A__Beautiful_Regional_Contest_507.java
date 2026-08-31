//package codeforces;
import java.util.*;
import java.io.*;
public class Medals {
public static void main(String[] args)throws Exception {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(br.readLine());
	for(int i=0;i<t;i++) {
		int n=Integer.parseInt(br.readLine());
		int ar[]=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int j=0;j<n;j++) {
			ar[j]=Integer.parseInt(st.nextToken());
		}
		int k=n/2;
		int count=1;
		int g=0;
		int s=0;
		int b=0;
		int limit=k-1;
		int lt=k-1;
		int done=1;
		for(int j=1;j<k;j++) {
			if(ar[j]==ar[j-1]) {
				count++;             
			}
			else {
				g+=count;
				done=j;
				break;
			}
		}
		count=1;
		for(limit=k;limit>done;limit--) {
			if(ar[limit]==ar[limit-1]) {
				lt--;
			}
			else {
				break;
			}
		}
		int flag=0;
		for(int j=done+1;j<=lt;j++) {
			flag++;
			if(ar[j]==ar[j-1]) {
				count++;
			}
			else {
				s=flag;
				if(s>g)
					break;
				count=0;
			}
		}
		
		b=lt+1-s-g;
		//System.out.println(g+" "+s+" "+b);
		if(g>0 && g<b && g<s) {
			System.out.println(g+" "+s+" "+b);
		}
		else {
			System.out.println("0 0 0");
		}
	}
}
}
