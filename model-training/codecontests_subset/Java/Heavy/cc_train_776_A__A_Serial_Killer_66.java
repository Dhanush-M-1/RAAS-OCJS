import java.util.*;
import java.io.*;
import java.lang.*;
public class problem{
	static long gcd(long a,long b){
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
    public static void main(String[] args)throws IOException {
    	FastReader sc=new FastReader();
    	OutputStream output=System.out;
    	PrintWriter out=new PrintWriter(output);

    	String s1=sc.next();
    	String s2=sc.next();
    	int n=sc.nextInt();
    	String[] arr1=new String[n+1];
    	String[] arr2=new String[n+1];
    	String[] ans1=new String[n+1];
    	String[] ans2=new String[n+1];
    	arr1[0]=s1;
    	arr2[0]=s2;
    	for(int i=1;i<arr1.length;i++){
    		arr1[i]=sc.next();
    		arr2[i]=sc.next();
    	}
    	ans1[0]=arr1[0];
    	ans2[0]=arr2[0];
    	for(int i=1;i<arr1.length;i++){
    		if(arr1[i].equals(ans1[i-1])&&arr1[i]!=ans2[i-1])
    			ans1[i]=ans2[i-1];

    		else if(arr1[i].equals(ans2[i-1])&&arr1[i]!=ans1[i-1])
    			    ans1[i]=ans1[i-1];
    		else if(arr1[i]!=(ans2[i-1])&&arr1[i]!=ans1[i-1])
    			ans1[i]=arr1[i];
    		if(arr2[i].equals(ans1[i-1])&&arr2[i]!=ans2[i-1])
    			ans2[i]=ans2[i-1];

    		else if(arr2[i].equals(ans2[i-1])&&arr2[i]!=ans1[i-1])
    			ans2[i]=ans1[i-1];
    		else if(arr2[i]!=(ans2[i-1])&&arr2[i]!=ans1[i-1])
    			ans2[i]=arr2[i];
    	}
    	for(int i=0;i<arr2.length;i++)
    		out.println(ans1[i]+" "+ans2[i]);

    	out.close();
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