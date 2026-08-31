import java.util.*;

public class destroyyyyy {
	/*do one of four things, for each turn take 0, 1, 2, or 3
	
	for each of those things always take the most damage u can
	it will never be good to take one that isn't the biggest
	for the given cost
	
	dp[i][j] max damage if ur on the ith turn and j=num%10
	*/
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		a=new turn[n];
		for(int i=0;i<n;i++) {
			int x=scan.nextInt();
			a[i]=new turn(x);
			for(int j=0;j<x;j++) {
				a[i].add(scan.nextInt(),scan.nextInt());
			}
			a[i].sort();
		}
		dp=new long[n][10];
		
		for(long[] d:dp) Arrays.fill(d,-1);
		System.out.println(go(0,0));
	}
	static turn[] a;
	static int n;
	public static long go(int at, int cycle) {
		if(at==n) return 0L;
		if(dp[at][cycle]!=-1) return dp[at][cycle];
		long res=0L;
		
		Long max1_1=null,max1_2=null,max1_3=null;
		if(a[at].a1.size()>=1) max1_1=a[at].a1.get(a[at].a1.size()-1);
		if(a[at].a1.size()>=2) max1_2=a[at].a1.get(a[at].a1.size()-2);
		if(a[at].a1.size()>=3) max1_3=a[at].a1.get(a[at].a1.size()-3);
		
		Long max2=null;
		if(a[at].a2.size()>=1) max2=a[at].a2.get(a[at].a2.size()-1);
		
		Long max3=null;
		if(a[at].a3.size()>=1) max3=a[at].a3.get(a[at].a3.size()-1);
		
		long add;
		
		//take 0
		res=Math.max(res,go(at+1,cycle));
		
		//take 1
		if(max1_1!=null) {//1
			add=max1_1;
			if(cycle+1>=10) add+=max1_1;
			res=Math.max(res,add+go(at+1,(cycle+1)%10));
		}
		
		//take 2
		if(max1_1!=null&&max1_2!=null) {//1,1
			add=max1_1+max1_2;
			if(cycle+2>=10) {
				long x=Math.max(max1_1,max1_2);
				add+=x;
			}
			res=Math.max(res,add+go(at+1,(cycle+2)%10));
		}
		if(max2!=null) {//2
			add=max2;
			if(cycle+1>=10) add+=max2;
			res=Math.max(res,add+go(at+1,(cycle+1)%10));
		}
		
		//take 3
		if(max1_1!=null&&max2!=null) {//2,1
			add=max1_1+max2;
			if(cycle+2>=10) {
				long x=Math.max(max1_1,max2);
				add+=x;
			}
			res=Math.max(res,add+go(at+1,(cycle+2)%10));
		}
		if(max3!=null) {//3
			add=max3;
			if(cycle+1>=10) add+=max3;
			res=Math.max(res,add+go(at+1,(cycle+1)%10));
		}
		if(max1_1!=null&&max1_2!=null&&max1_3!=null) {//1,1,1
			add=max1_1+max1_2+max1_3;
			if(cycle+3>=10) {
				long x=Math.max(max1_1,max1_2);
				x=Math.max(x,max1_3);
				add+=x;
			}
			res=Math.max(res,add+go(at+1,(cycle+3)%10));
		}
		return dp[at][cycle]=res;
	}
	static long[][] dp;
	
	static class turn {
		int n;
		ArrayList<Long> a1,a2,a3;
		turn(int n) {
			this.n=n;
			a1=new ArrayList<>();
			a2=new ArrayList<>();
			a3=new ArrayList<>();
		}
		void add(int cc, long dd) {
			if(cc==1) a1.add(dd);
			if(cc==2) a2.add(dd);
			if(cc==3) a3.add(dd);
		}
		void sort() {
			Collections.sort(a1);
			Collections.sort(a2);
			Collections.sort(a3);
		}
	}
}