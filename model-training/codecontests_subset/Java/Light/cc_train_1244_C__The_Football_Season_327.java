    import java.util.*;
    import java.io.*;
     
    public class Solution{
    
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n= Long.parseLong(st.nextToken());
		long p= Long.parseLong(st.nextToken());
		long w= Long.parseLong(st.nextToken());
		long d= Long.parseLong(st.nextToken());
		long i=0;
		 while(i <= w-1){
		    long num = (p-(i*d));
		    if(num < 0) break;
		    if( num % w == 0){
		        long x = num/w;
		        if(x + i > n){
		            i++;
		           continue; 
		        } 
		        out.print(x+" "+i+" "+(n-(x+i)));
		        out.close();
		        return;
		    }
		    i++;
		}
		out.println(-1);
		out.close();    
	}
}