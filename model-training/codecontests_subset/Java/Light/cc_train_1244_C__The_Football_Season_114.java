import java.io.*;
import java.util.*;
import java.math.*;
     
public class Main {
	//static int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = System.out;
    	PrintWriter out = new PrintWriter(outputStream);
 
        int j;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n=Long.parseLong(st.nextToken());
		long p=Long.parseLong(st.nextToken());
		long w=Long.parseLong(st.nextToken());
		long d=Long.parseLong(st.nextToken());
		
		long x=0, y=0, z=0;
		for(int i=0; i<w ; i++)
		{
		    if((p-i*d)%w==0){
		        
		    x=(p-i*d)/w;
		    if(x<0)
		        break;
		    if(x+i>n)
		        break;
		  out.print(x+" "+i+" "+(n-i-x));
		  out.flush();
    	  out.close();
		  return;
		    }
		}
		out.print(-1);
		out.flush();
    	out.close();
    	}
    }