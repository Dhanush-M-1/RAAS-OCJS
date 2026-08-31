import java.util.*;
import java.io.*;

public class Solution {
	public static void main (String[] args)throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String k[] = br.readLine().split(" ");
	    long n = Long.parseLong(k[0]);
	    long p = Long.parseLong(k[1]);
	    long w = Long.parseLong(k[2]);
	    long d = Long.parseLong(k[3]);
	    if(p==0)
	    {
	        System.out.println(0+" "+0+" "+n);
	        return;
	    }
	    long x = 0;
	    for(int y=0;y<w;y++)
	    {
	        
	        if((p-y*d)%w==0)
	        {
	            x = (p-y*d)/w;
	            if(x>=0 && x+y<=n)
	            {
	            System.out.println(x+" "+y+" "+(n-x-y));
	            return;
	            }
	        }
	    }
	    System.out.println(-1);
	}
	
}