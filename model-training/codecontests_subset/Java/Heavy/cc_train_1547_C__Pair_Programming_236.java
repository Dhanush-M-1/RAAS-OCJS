import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int T=sc.nextInt();
while(T-->0) {
		int k=sc.nextInt();
		int n=sc.nextInt();
		int m=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++) a[i]=sc.nextInt();
		int b[]=new int[m];
		for(int i=0;i<m;i++) b[i]=sc.nextInt();
		
		int c[]=new int[n+m];
		int i=0,j=0,l=0;
		boolean flag=false;
		while(i<n && j<m) {
			if(a[i]==0) {
				k++;
				c[l++]=a[i++];
			}else if(a[i]>0 && a[i]<=k) {
				c[l++]=a[i++];
			}else if(a[i]>0 && a[i]>k) {
				if(b[j]==0) {
					k++;
				    c[l++]=b[j++];
				}else if(b[j]>0 && b[j]<=k) {
					c[l++]=b[j++];
				}else {
					System.out.print(-1);
					System.out.println();
					flag=true;
					break;
				}
			}
		}
		if(!flag) {
		while(i<n) {
			if(a[i]==0) {
				k++;
				c[l++]=a[i++];
			}else if(a[i]>0 && a[i]<=k) {
			c[l++]=a[i++];
		}
			else {
				System.out.print(-1+" ");
				System.out.println();
				flag=true;
				break;
			}
			}
		while(j<m) {
			if(b[j]==0) {
				k++;
			    c[l++]=b[j++];
			}else if(b[j]>0 && b[j]<=k) {
				c[l++]=b[j++];
			}else {
				System.out.print(-1);
				System.out.println();
				flag=true;
				break;
			}
		}
		if(!flag) {
		for(int q:c)System.out.print(q+" ");
		 System.out.println();
		}
		}
	
}

}}