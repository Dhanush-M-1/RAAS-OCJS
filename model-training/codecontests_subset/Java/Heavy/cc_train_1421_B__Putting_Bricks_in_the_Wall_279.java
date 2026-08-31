import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class CodeForce {



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int next(String[] sr, int ind) {
		if(sr[ind].equals("S")||sr[ind].equals("F"))
			return 1000;
		return Integer.parseInt(sr[ind]);
	}

	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String[] sr=br.readLine().split(" ");
			int n=next(sr,0);
			int[][] arr=new int[n][n];
		
			for(int i=0;i<n;i++)
			{sr=br.readLine().split("");
				for(int j=0;j<n;j++)
				{
					arr[i][j]=next(sr,j);
					
				}
				
				
			}
			int a=arr[0][1];
			int b=arr[1][0];
			int x=arr[n-1][n-2];
			int y=arr[n-2][n-1];
			
			
			if(a==0&&b==0)
			{
				if(x==1&&y==1)
					{System.out.println("0");
				continue;}
			}
			if(a==1&&b==1)
			{
				if(x==0&&y==0)
				{	System.out.println("0");
				continue;}
				
			}
			
			
			
			if(a==1&&b==0 )
			{
				if(x==1&&y==1)
				{
					System.out.println("1");
					System.out.println("1 2");
					continue;
				}
				if(x==0&&y==0)
				{
					System.out.println("1");
					System.out.println("2 1");
					continue;
				}
				if(x==1&&y==0)
				{
					System.out.println("2");
					System.out.println("1 2");
					System.out.println(n-1+" "+n);
					continue;
				}
				if(x==0&&y==1)
				{	
					System.out.println("2");
				System.out.println("2 1");
				System.out.println(n-1+" "+n);
				continue;
			
				}
			}
			if(a==0&&b==1 )
			{
				if(x==1&&y==1)
				{
					System.out.println("1");
					System.out.println("2 1");
					continue;
				}
				if(x==0&&y==0)
				{
					System.out.println("1");
					System.out.println("1 2");
					continue;
				}
				if(x==1&&y==0)
				{
					System.out.println("2");
					System.out.println("2 1");
					System.out.println(n-1+" "+n);
					continue;
				}
				if(x==0&&y==1)
				{	
					System.out.println("2");
				System.out.println("1 2");
				System.out.println(n-1+" "+n);
				continue;
			
				}
			}
			if(a==1&&b==1 )
			{
				if(x==0&&y==1)
				{
					System.out.println("1");
					System.out.println(n-1+" "+n);
					continue;
				}
				if(x==0&&y==0)
				{
					System.out.println("0");
				
					continue;
				}
				if(x==1&&y==0)
				{
					System.out.println("1");
			
					System.out.println(n+" "+(n-1));
					continue;
				}
				if(x==1&&y==1)
				{	
					System.out.println("2");
			
				System.out.println("1 2");
				System.out.println("2 1");
				
				continue;
			
				}
			}
			if(a==0&&b==0 )
			{
				if(x==1&&y==0)
				{
					System.out.println("1");
					System.out.println(n-1+" "+n);
					continue;
				}
				if(x==1&&y==1)
				{
					System.out.println("0");
					
					
					continue;
				}
				if(x==0&&y==1)
				{
					System.out.println("1");
					System.out.println(n+" "+(n-1));
					continue;
				}
				if(x==0&&y==0)
				{	
					System.out.println("2");
					System.out.println("1 2");
					System.out.println("2 1");
			
				continue;
			
				}
			}
				
			
			
		
			
		}
		
	}
}
