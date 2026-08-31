// Working program with FastReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GFG {
    static byte g[]=new byte[1000001];
    static int f[]=new int[1000001];
	public static void main (String[] args) {
	FastReader sc = new FastReader();
	//Scanner in=new Scanner(System.in);
	int t=1,i,j,n,b,a;
	//t=sc.nextint();
	while(t-->0){
	    n=sc.nextInt();
	    a=1;b=1000000;
	    for(i=0;i<n;i++){
	        j=sc.nextInt();
	        if(j<=500000 && j>a){
	            a=j;
	        }else if(j>500000 && j<b){
	            b=j;
	        }
	    }
	    j=Math.max(a-1,1000000-b);
	    System.out.println(j);
	    
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
}