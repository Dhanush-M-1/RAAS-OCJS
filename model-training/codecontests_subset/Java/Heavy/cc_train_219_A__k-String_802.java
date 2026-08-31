import java.util.*;
import java.io.*;
public class A  {
    static FastReader in=new FastReader();
    static final Random random=new Random();
    static long mod=1000000007L;

    public static void main(String args[]) throws IOException {
        int t=1;//in.nextInt();
        StringBuilder res=new StringBuilder();
        loop:
        while(t-->0)
        {
        	int k=in.nextInt();
        	
        	int freq[]=new int[26];
        	
        	String s=in.next();
        	for(int i=0;i<s.length();i++)
        	{
        		freq[s.charAt(i)-'a']++;
        	}
        	for(int x: freq)
        	{
        		if(x%k!=0)
        		{
        			res.append(-1);
        			break loop;
        		}
        	}
        	int times[]=new int[26];
        	for(int i=0;i<26;i++)
        	{
        		times[i]=freq[i]/k;
        	}
        	while(res.length()!=s.length())
        	{
        		for(int i=0;i<26;i++)
        		{
        			if(freq[i]>0)
        			{
        				for(int j=0;j<times[i];j++)
        					res.append((char)('a'+i));
        				freq[i]-=times[i];
        			}
        		}
        		//print(res);
        	}
        }
        print(res);
    }
    
    public static int gcd(int i, int j)
    {
    	System.out.println(i+":"+j);
        if (i == 0)
            return j;
        if (i > j)
            return gcd(i%j, j);
        return gcd( j%i,i);
    } 
    static class boy
    {
    	int i;
    	int val;
    	public boy(int i,int val)
    	{
    		this.i=i;
    		this.val=val;
    	}
    }

     
    static void ruffleSort(int[] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }

    static < E > void print(E res)
    {
        System.out.println(res);
    }


    /*static  int gcd(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }*/

    static int abs(int a)
    {
        if(a<0)
            return -1*a;
        return a;
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

        int [] readintarray(int n) {
            int res [] = new int [n];
            for(int i = 0; i<n; i++)res[i] = nextInt();
            return res;
        }
        long [] readlongarray(int n) {
            long res [] = new long [n];
            for(int i = 0; i<n; i++)res[i] = nextLong();
            return res;
        }
    }

}




