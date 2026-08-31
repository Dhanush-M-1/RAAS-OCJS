import java.util.*;

public class Main {
	
	static int A[],B[];
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=Integer.parseInt(in.next());
		A=new int[n];
		for(int i=0;i<n;i++)A[i]=Integer.parseInt(in.next());
		
		int q=Integer.parseInt(in.next());
		for(int i=0;i<q;i++) {
			int begin=Integer.parseInt(in.next()),end=Integer.parseInt(in.next()),t=Integer.parseInt(in.next());
			swap(begin,end,t);
		}
		for(int i=0;i<n-1;i++)System.out.print(A[i]+" ");
		System.out.println(A[n-1]);
	}
	
	static void swap(int begin,int end,int t) {
		for(int k=0;k<end-begin;k++) {
			int tt=A[begin+k];
			A[begin+k]=A[t+k];
			A[t+k]=tt;
		}
	}

}
