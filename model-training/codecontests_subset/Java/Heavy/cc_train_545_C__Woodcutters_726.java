import java.util.*;

public class Main {

	static class Pair implements Comparable<Pair>{
		int in;
		long h;
		
		Pair(int a,long b){
			in=a;
			h=b;
		}
		
		public int compareTo(Pair b) {
			if(this.in<b.in)
				return -1;
			else
				return 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		Pair[] p=new Pair[n];
		
		for(int i=0;i<n;i++) {
			int x=input.nextInt();
			long h=input.nextLong();
			p[i]=new Pair(x,h);
		}
		Arrays.sort(p);
		
		int ans=1;
		long last=p[0].in;
		for(int i=1;i<n-1;i++) {
			if(last<p[i].in-p[i].h) {
				ans++;
				last=p[i].in;
			}
			else if(p[i].in+p[i].h<p[i+1].in) {
				ans++;
				last=p[i].in+p[i].h;
			}
			else {
				last=p[i].in;
			}
		}
		
		if(n!=1) {
			ans++;
		}
		System.out.println(ans);
	}

}
