import java.io.*;
public class Main{
	static char dp[][];
	static int visit[][];
	static int n,m,k;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String str[]=s.split(" ");
		n=Integer.parseInt(str[0]);
		m=Integer.parseInt(str[1]);
		k=Integer.parseInt(str[2]);
		dp=new char[n+1][m+1];
		for(int i=1;i<=n;i++){
			s=br.readLine();
			for(int j=1;j<=m;j++){
				dp[i][j]=s.charAt(j-1);	
			}
		}
		visit=new int[n+1][m+1];
		int count=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(dp[i][j]!='#' && visit[i][j]==0){
					dfs(i,j,visit);	
				}

			}	
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				System.out.print(dp[i][j]);	
			}
			System.out.println();
		}

	}	
	public static void dfs(int i,int j,int visit[][]){
		if((i<=0||i>n) || (j<=0 || j>m)){
			return ;
		}
		if(visit[i][j]==1 || dp[i][j]=='#') {
			return;	
		}
		if(dp[i][j]=='.'){
			visit[i][j]=1;
			dfs(i+1,j,visit);
			dfs(i-1,j,visit);
			dfs(i,j-1,visit);
			dfs(i,j+1,visit);
		}
		if(k!=0){
			dp[i][j]='X';
			k-=1;
		}
	}
}
