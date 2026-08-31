import java.util.*;
import java.io.*;
import java.lang.*;
public class Main
{
	static class FastReader 
	{ 
	    BufferedReader br; 
	    StringTokenizer st; 

	    public FastReader() 
	    { 
	        br = new BufferedReader(new
	                 InputStreamReader(System.in)); 
	    } 
	    String next() 
	    { 
	        while (st == null || !st.hasMoreElements()) 
	        { 
	            try
	            { 
	                st = new StringTokenizer(br.readLine()); 
	            } 
	            catch (IOException  e) 
	            { 
	                e.printStackTrace(); 
	            } 
	        } 
	        return st.nextToken(); 
	    }
	    int nextInt() 
	    { 
	        return Integer.parseInt(next()); 
	    } 
	}

	public static void main(String args[])
	{
		FastReader s=new FastReader();
		int n=s.nextInt();
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			al.add(s.nextInt());
		int k=Collections.max(al);
		while(true)
		{
			int sum=0;
			int rsum=0;
			for(int i=0;i<n;i++)
				sum+=al.get(i);
			rsum=al.size()*k-sum;
			if(rsum>sum)
				break;
			k++;
		}
		System.out.println(k);
	}
}