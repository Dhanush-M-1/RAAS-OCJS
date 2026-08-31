import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int MAX_N=300001;
		int n,m;
		int a[]=new int[MAX_N];
		int cnt[]=new int[MAX_N];
		ArrayList<ArrayList<Integer>>G=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<MAX_N;i++) {
			ArrayList<Integer> x=new ArrayList<Integer>();
			G.add(x);
		}
		n=in.nextInt();m=in.nextInt();
		for(int i=1;i<=n;i++) {
			a[i]=in.nextInt();
		}
		for(int i=1;i<=m;i++) {
			int v,u;
			v=in.nextInt();u=in.nextInt();
			G.get(u).add(v);
		}
		int res=0;
		for(int i=0;i<G.get(a[n]).size();i++) {
			cnt[G.get(a[n]).get(i)]++;
		}
		for(int i=n-1;i>=1;i--) {
			int x=a[i];
			if(cnt[x]==n-i-res)res++;
			else {
				for(int j=0;j<G.get(x).size();j++) {
					cnt[G.get(x).get(j)]++;
				}
			}
		}
		System.out.println(res);
	}
}
