import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;  
  
public class codefo
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
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
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
 
    public int gcd(int a,int b)
    {
        return b==0?a:gcd(b,a%b);
    }
 
    public boolean isPrime(long n)
    {
        if(n==2)return true;
        int i=2;
        while(i*i<=n)
        {
            if(n%i==0) return false;
            i++;
        }
        return true;
    }
  
    public static void main(String[] args) 
    {
        FastReader ob=new FastReader(); 
        	int n=ob.nextInt();
        	int x=ob.nextInt();
        	int y=ob.nextInt();
        	double res=(double)n/100;
        	double sum=(double)y*res;
        	sum=(Math.ceil(sum));
        	if(x>(int)sum)
        		System.out.println("0");
        	else
        		System.out.println((int)sum-x);
	}
}

