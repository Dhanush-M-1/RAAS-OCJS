import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader sc=new FastReader();
		int n=sc.I();
		char c[]=sc.nextLine().toCharArray();
		int i=0;
	    for(i=1;i<n;i++)
	    {
	       if(c[i]<c[i-1])
	       break;
	    }
		if(i==n)
		System.out.println("NO");
		else
		{
		    i++;
		    System.out.println("YES\n"+(i-1)+" "+i);
		}
	 }
	 
	 
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
  
        int I() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long L() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double D() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    static int gcd(int a,int b)
		{
		    if(a%b==0)
		    return b;
		    return gcd(b,a%b);
		}
	static float power(float x, int y) 
    { 
        float temp; 
        if( y == 0) 
            return 1; 
        temp = power(x, y/2);  
          
        if (y%2 == 0) 
            return temp*temp; 
        else
        { 
            if(y > 0) 
                return x * temp * temp; 
            else
                return (temp * temp) / x; 
        } 
    } 
    static long pow(int a,int b)
    {
        long result=1;
        if(b==0)
        return 1;
        long x=a;
        while(b>0)
        {
            if(b%2!=0)
            result*=x;
            
            x=x*x;
            b=b/2;
        }
        return result;
    }
    
    static ArrayList<Integer> sieveOfEratosthenes(int n) 
    { 
        ArrayList<Integer> arr=new ArrayList<Integer>();
        boolean prime[] = new boolean[n+1]; 
        for(int i=2;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            if(prime[p] == true) 
            { 
                arr.add(p);
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
        return arr;
    } 
}