import java.util.*;

public class Woodcutters {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] x=new int[n], h=new int[n];
		for(int i=0;i<n;i++) {
			x[i]=scan.nextInt();
			h[i]=scan.nextInt();
		}
		int prev=Integer.MAX_VALUE;
		
		//omg
		int res=0;
		
		//omg seriously
		for(int i=0;i<n;i++) {
			if(i==0) {
				res++;
				prev=x[0];
			}
			else if(i==n-1) res++;
			else {
				if(x[i]-h[i]>prev) {
					prev=x[i];
					res++;
				}
				else if(x[i]+h[i]<x[i+1]) {
					prev=x[i]+h[i];
					res++;
				}
				else prev=x[i];
			}
		}
		System.out.println(res);
	}
}