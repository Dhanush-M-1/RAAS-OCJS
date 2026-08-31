

import java.io.*;
import java.util.*;
 
public class B 
{	
	public static void main(String[] args)throws IOException 
	{	
		FastReader f=new FastReader();
		
		int test=f.nextInt();
		while(test-->0)
		{	
			StringBuffer sb = new StringBuffer();
			int n=f.nextInt();
			char ch[][]=new char[n][n];
			for(int i=0;i<n;i++)
			{
				char c[]=f.next().toCharArray();
				for(int j=0;j<n;j++)
					ch[i][j]=c[j];
			}
			
			int a=ch[n-3][n-1]-'0';
			int b=ch[n-2][n-2]-'0';
			int c=ch[n-1][n-3]-'0';
			int e=ch[n-2][n-1]-'0';
			int d=ch[n-1][n-2]-'0';
			if(a==b && b==c && c==d && d==e)
			{
				sb.append(2+"\n");
				sb.append((n-1)+" "+n+"\n");
				sb.append(n+" "+(n-1)+"\n");
				System.out.println(sb);
				continue;
			}
			if(d==e)
			{	
				int count=0;
				int v=d;
				if(a==v)
				{	
					sb.append((n-2)+" "+n+"\n");
					count++;
				}
				if(b==v)
				{
					sb.append((n-1)+" "+(n-1)+"\n");
					count++;
				}
				if(c==v)
				{
					sb.append(n+" "+(n-2)+"\n");
					count++;
				}
				System.out.println(count);
				System.out.println(sb);
			}
			else
			{
				int o=0,z=0;
				if(a==0)z++; else o++;
				if(b==0)z++; else o++;
				if(c==0)z++; else o++;
				
				int count=0;
				if(o>z)
				{
					if(a==0) 
					{
						count++;
						sb.append((n-2)+" "+n+"\n");
					}
					if(b==0)
					{
						count++;
						sb.append((n-1)+" "+(n-1)+"\n");
					}
					if(c==0)
					{
						count++;
						sb.append(n+" "+(n-2)+"\n");
					}
					if(d==1)
					{
						count++;
						sb.append(n+" "+(n-1)+"\n");
					}
					if(e==1)
					{
						count++;
						sb.append((n-1)+" "+n+"\n");
					}
				}
				if(z>o)
				{
					if(a==1) 
					{
						count++;
						sb.append((n-2)+" "+n+"\n");
					}
					if(b==1)
					{
						count++;
						sb.append((n-1)+" "+(n-1)+"\n");
					}
					if(c==1)
					{
						count++;
						sb.append(n+" "+(n-2)+"\n");
					}
					if(d==0)
					{
						count++;
						sb.append(n+" "+(n-1)+"\n");
					}
					if(e==0)
					{
						count++;
						sb.append((n-1)+" "+n+"\n");
					}
				}
				System.out.println(count);
				System.out.println(sb);
			}
		}	
	}
	
	static class FastReader 
	{ 
	    BufferedReader br; 
	    StringTokenizer st; 

	    public FastReader() {
	    	br = new BufferedReader(new
	                 InputStreamReader(System.in)); 
	    }
	    String next() { 
	        while (st == null || !st.hasMoreElements()) { 
	            try{ 
	                st = new StringTokenizer(br.readLine()); 
	            } 
	            catch (IOException  e) { 
	                e.printStackTrace(); 
	            } 
	        } 
	        return st.nextToken(); 
	    } 
	    int nextInt() { 
	        return Integer.parseInt(next()); 
	    } 
	    long nextLong() { 
	        return Long.parseLong(next()); 
	    } 
	    double nextDouble() { 
	        return Double.parseDouble(next()); 
	    } 
	    String nextLine() { 
	        String str = ""; 
	        try{ 
	            str = br.readLine(); 
	        } 
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	        return str; 
	    } 
	} 
}