import java.util.*;

public class Main {
	
	static boolean A[];
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt(),D[]=new int[n],max=0,cnt=0;
		
		for(int i=0;i<n;i++) {
			D[i]=Integer.parseInt(in.next());
			if(D[i]>max)max=D[i];
		}
		sieve(max);
		for(int i=0;i<D.length;i++) {
			if(!A[D[i]])cnt++;
		}
		System.out.println(cnt);
	}
		
	static void sieve(int n) {
		A=new boolean[n+1];
		for(int i=2;i<Math.sqrt(A.length);i++) {
			if(!A[i]) {
				int p=i,s=p*2;
				for(int j=s;j<A.length;j+=p)A[j]=true;
			}
		}
	}

}
