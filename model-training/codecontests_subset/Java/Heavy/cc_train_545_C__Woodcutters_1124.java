/*Author LAVLESH*/
import java.util.*;
import java.io.*;

public class solution {
	
	static class FastScanner{
		BufferedReader B;
		StringTokenizer st;
		public FastScanner(){
			st=new StringTokenizer("");
			B=new BufferedReader(new InputStreamReader(System.in));
		}
		
		public int nextInt() throws IOException{
			if(st.hasMoreTokens())
				return Integer.parseInt(st.nextToken());
			else{
				st = new StringTokenizer(B.readLine());
				return nextInt();
			}
			}
			
		public long nextLong() throws IOException{
			if(st.hasMoreTokens())
				return Long.parseLong(st.nextToken());
			else{
				st= new StringTokenizer(B.readLine());
				return nextLong();
			}
		}
			public double nextDouble() throws IOException{
				if(st.hasMoreTokens())
					return Double.parseDouble(st.nextToken());
				else{
					st = new StringTokenizer(B.readLine());
					return nextDouble();
				}
			}
		
		
	}

	
	public static void main(String args[])throws Exception
    {
     
     FastScanner in=new FastScanner();
      int n=in.nextInt();
      int []a=new int[n+1];
      int []b=new int[n+1];
      int i,cnt=0;
      for(i=1;i<=n;i++)
      {
    	  a[i]=in.nextInt();
    	  b[i]=in.nextInt();
      }
     if(n<=1)cnt=n;
     else{
      for(i=2;i<n;i++)
      {
    	  if(a[i]-b[i]>a[i-1]){ cnt++;}
    	  else if(a[i]+b[i]<a[i+1]-b[i+1]){cnt++;}
    	  else if(a[i]+b[i]<a[i+1])
    	  {
    		  a[i]=a[i]+b[i];
    		  b[i]=0;
    		  cnt++;
    	  }
    	  
      }}
     if(n>=2)cnt+=2;
     System.out.print(cnt);
  }
}

