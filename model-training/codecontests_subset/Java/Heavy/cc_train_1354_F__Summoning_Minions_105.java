/*
 ID: tommatt1
 LANG: JAVA
 TASK: 
*/
import java.util.*;
import java.io.*;
public class cf1354f{

	public static void main(String[] args)throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int tt=Integer.parseInt(st.nextToken());
		while(tt-->0) {
			st=new StringTokenizer(bf.readLine());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			pair[] mnn=new pair[n+1];
			boolean[] inc=new boolean[n+1];
			boolean[][] poss=new boolean[n+1][k+1];
			int[][] dp=new int[n+1][k+1];
			for(int i=1;i<=n;i++) {
				st=new StringTokenizer(bf.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				mnn[i]=new pair(a,b,i);
			}
			for(int i=0;i<=n;i++) {
				Arrays.fill(dp[i], 1, k+1, Integer.MIN_VALUE/2);
			}
			Arrays.sort(mnn,1,n+1);
			for(int i=1;i<=n;i++) {
				for(int j=k;j>0;j--) {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1]+mnn[i].a-mnn[i].b*(k-j));
					poss[i][j]=(dp[i][j]^dp[i-1][j])==0?false:true;
				}
			}
			for(int i=n,j=k;i>0;i--) {
				if(poss[i][j]) {
					inc[i]=true;
					j--;
				}
			}
			out.println(k+2*(n-k));
			for(int i=1,j=0;i<=n;i++) {
				if(j==k-1) {
					for(int z=1;z<=n;z++) {
						if(!inc[z]) {
							out.print(mnn[z].c+" "+(-mnn[z].c)+" ");
						}
					}
					j++;
				}
				if(inc[i]) {
					out.print(mnn[i].c+" ");
					j++;
				}
			}
			out.println();
		}
		out.close();
	}
	static class pair implements Comparable<pair>{
		int a,b,c;
		public pair(int x,int y,int z) {
			a=x;b=y;c=z;
		}
		public int compareTo(pair p) {
			return b-p.b;
			//if(a>p.a) return 1;
		}
	}

}
