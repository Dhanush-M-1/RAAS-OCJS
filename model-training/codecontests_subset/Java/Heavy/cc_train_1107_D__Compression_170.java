// No sorceries shall prevail. //           
import java.util.*;
import java.io.*;

public class InVoker {
	static long mod = 1000000007;
	static long mod2 = 998244353;	
    static class Segment implements Comparable<Segment> {
		int l, r, initialIndex;
		Segment () {}
		Segment (int l_, int r_, int d_) {
		    this.l = l_;
		    this.r = r_;
		    this.initialIndex = d_;
		}
		@Override
		public int compareTo(Segment o) {
		    return l - o.l;
		}
    }
    
//  Segment[] seg=new Segment[n];
//	for (int i=0;i<n;i++) {
//		int l=inp.nextInt();
//		int r=inp.nextInt();
//		seg[i]=new Segment(l,r,i);
//	}
    
	static long gcd(long a, long b) { 
		return b==0?a:gcd(b,a%b);
	}
	static int gcd(int a, int b) { 
		return b==0?a:gcd(b,a%b);
	}
	static Scanner inp= new Scanner(System.in);
	static PrintWriter out= new PrintWriter(System.out);
	static void input(long a[], int n) {
		for(int i=0;i<n;i++) {
			a[i]=inp.nextLong();
		}
	}
	static void input(int a[], int n) {
		for(int i=0;i<n;i++) {
			a[i]=inp.nextInt();
		}
	}	
	static void input(String s[],int n) {
		for(int i=0;i<n;i++) {
			s[i]=inp.next();
		}
	}
	void main() {

		int n=inp.nextInt();
		int a[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			String s=inp.next();
			for(int j=0;j<n/4;j++) {
				char x=s.charAt(j);
				int num= x>='A'?x-'A'+10:x-'0';
				for(int k=0;k<4;k++) {
					a[i][(j+1)*4-k-1] = num%2;
					num/=2;
				}
			}
		}
		int gg=solve(a,n);
		a=transpose(a,n);
		gg=gcd(solve(a,n),gg);	
		out.println(gg);
	}
	
	static int solve(int a[][], int n){
		int ans=0,k=1;
		for(int i=1;i<=n;i++) {
			boolean diff=false;
			if(i==n) {
				diff=true;
			}else {
				for(int j=0;j<n;j++) {
					if(a[i][j]!=a[i-1][j]) {
						diff=true;
						break;
					}
				}
			}
			if(diff) {
				ans=gcd(k,ans);
				k=1;
			}else {
				k++;
			}
		}
		
		return ans;
	}
	
	static int[][] transpose(int a[][], int n){
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				int x=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=x;
			}
		}
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[]) {
		InVoker g = new InVoker();
		g.main();
		
		out.close();
		inp.close();
	}
}















