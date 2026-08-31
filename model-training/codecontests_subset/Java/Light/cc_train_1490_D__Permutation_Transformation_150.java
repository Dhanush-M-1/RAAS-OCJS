

import java.util.Scanner;

public class permutran {
	public static int depth(int i,int j,int a1[],int count,int d[]) {
		int max=0;
		int f=0;
		if(j<0 || i>a1.length-1) {
			return count;
		}
		else if(i ==j){
			
			return count;}
		else {
		for(int k=i;k<j;k++) {
			max=Math.max(a1[k], max);
		}
		for(int h=i;h<j;h++) {
			if(a1[h] == max) {
				f=h;
				break;
			}
		}count+=1;
		d[f] =count;
		
		
		
		return Math.max(depth(i,f,a1,count,d), depth(f+1,j,a1,count,d));}
		
		
	}
	public void dept(int i,int j,int a1[],int count) {
		int max=0;int f=0;
		for(int k=i;k<j;k++) {
			max=Math.max(a1[k], max);
		}
		for(int h=i;h<j;h++) {
			if(a1[h] == max) {
				f=h;
				break;
			}
		}
		count++;
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a =sc.nextInt();
		
		
		for(int k=0;k<a;k++) {
			int c= sc.nextInt();
			int []b =new int[c];
			for(int i=0;i<c;i++) {
				b[i]=sc.nextInt();
			}
			int d[] =new int[c];
				int s =depth(0,c,b,-1,d);
				for(int u=0;u<c;u++) {
					System.out.print(d[u]+" ");
				}
				System.out.println();
			

	}}

}
