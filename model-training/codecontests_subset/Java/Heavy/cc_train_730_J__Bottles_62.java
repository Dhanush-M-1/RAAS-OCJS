
import java.io.*;
import java.util.*;
public class no {
	static int n,c,total;
	static int [] a,b;
	public static void main(String[] args) throws Throwable {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);

		n=Integer.parseInt(br.readLine());
		a=new int [n];
		b=new int [n];
		String s = br.readLine();
		String[] sa = s.split(" ");
		for(int i=0;i<n;i++){
			a[i] = Integer.parseInt(sa[i]);
			total+=a[i];
		}
		s = br.readLine();
		sa = s.split(" ");
		for(int i=0;i<n;i++){
			b[i] = Integer.parseInt(sa[i]);
		}
		pair[] arr = new pair[n];
		for(int i = 0;i<n;i++)
			arr[i] = new pair(a[i],b[i]);

		Arrays.sort(arr);

		int j=0;
		int curSum = 0;
		while(j<n && curSum<total)
		{
			curSum+=arr[j].b;
			j++;
		}
		c= j;

		mem=new int [n+1][(int)1e4+1][c+1];
		for(int i=0;i<=n;i++)
			for(int k=0;k<mem[i].length;k++)
				Arrays.fill(mem[i][k], -1);
		
		//System.out.println(dp(0, total,c));
		pw.println(c + " " +(total-dp(0, total,c)));

		pw.flush();
		pw.close();
	}
	static int [][][] mem;
	static int inf=(int)(1e7);
	static int dp(int i,int v , int remC){
//		System.out.println(i + " " + v + " " + remC);
		if(v<=0 && remC==0)
			return 0;
		if(v<0 || remC<0)
			return -inf;
		if(i == n)
			return -inf;
		if(mem[i][v][remC]!=-1)
			return mem[i][v][remC];

		int ans=dp(i+1, v,remC);
		ans=Math.max(ans, a[i]+dp(i+1, v-b[i],remC-1));

		return mem[i][v][remC]=ans;
	}

	static class pair implements Comparable<pair>{
		int b,a;

		pair(int a,int b){
			this.a=a;
			this.b=b;
		}
		public int compareTo(pair o) {
			if(b!=o.b)
				return o.b-b;
			return o.a-a;
		}
	}
}
