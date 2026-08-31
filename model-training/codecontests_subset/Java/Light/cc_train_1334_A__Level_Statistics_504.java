import java.util.*;
import java.io.*;
public class Answer {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int t;
		t=sc.nextInt();
		while(t-->0) {
			solve();
		}
	}
	
	public static void solve() {
		int n;
		n=sc.nextInt();
		boolean ans=true;
		int p=0,c=0;
		for(int i=0;i<n;i++) {
			int x,y;
			x=sc.nextInt();y=sc.nextInt();
			if(x<p || y<c || y-c>x-p) {
				ans=false;
			}
			p=x;c=y;
		}
		
		System.out.println(ans==true?"YES":"NO");
		
	}
}
