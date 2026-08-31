import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class maze {
	static int k,m,n;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader ds=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s=new StringTokenizer(ds.readLine());
		m=Integer.parseInt(s.nextToken());
		n=Integer.parseInt(s.nextToken());
		k=Integer.parseInt(s.nextToken());
		char a[][]=new char[m][n];
		int dfs[][]=new int[m][n];
		int i1=-1,j1=-1;
		maze obj=new maze();
		for(int i=0;i<m;i++)
		{
			String str=ds.readLine();
			
			for(int j=0;j<n;j++)
				{	dfs[i][j]=0;
					a[i][j]=str.charAt(j);
					
					
						
				}
				
		}
		
		for(int i=m-1;i>=0;i--)
		{
			for(int j=n-1;j>=0;j--)
			{
				if(i1==-1 && a[i][j]=='.')
				{	i1=i;j1=j;	}
			}
		}
		
		
		obj.dfs1(a,dfs,i1,j1);
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j]);
			}
			
			System.out.println();
		}
		
	}


	void dfs1(char[][] a,int dfs[][],int i,int j)
	{
		dfs[i][j]=1;
		if(i<m-1 && a[i+1][j]=='.' && dfs[i+1][j]==0)dfs1(a,dfs,i+1,j);
		if(j<n-1 && a[i][j+1]=='.' && dfs[i][j+1]==0)dfs1(a,dfs,i,j+1);
		
		if(i>0 && a[i-1][j]=='.' && dfs[i-1][j]==0)dfs1(a,dfs,i-1,j);
		
		if(j>0 && a[i][j-1]=='.' && dfs[i][j-1]==0)dfs1(a,dfs,i,j-1);	
		
		
		
		
		
		
		
		if(k>0)
		{
			k--;
			a[i][j]='X';
		}
		
	}
	
	
}
