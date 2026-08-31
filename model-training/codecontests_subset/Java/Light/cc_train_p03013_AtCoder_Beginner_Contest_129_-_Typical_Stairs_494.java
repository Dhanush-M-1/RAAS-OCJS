import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		long[] way = new long[n+1];
		boolean[] broken = new boolean[n+1];
		for(int i=0;i<m;i++) broken[sc.nextInt()]=true;
		for(int i=0;i<=n;i++) way[i]=-1;
		way[0]=1;
		if(broken[1]) way[1]=0;
		else way[1]=1;
		System.out.println(stair(n,broken,way));
	}

	static long stair(int n, boolean[] broken, long[] way) {
		final long mod = 1000000007;
		if(broken[n]) return 0;
		if(way[n]!=-1) return way[n];
		else{
			way[n] = (stair(n-1,broken,way)+stair(n-2,broken,way))%mod;
			return way[n];
		}
	}
}
