import java.util.*;


import java.lang.*;
import java.math.BigInteger;
import java.io.*;



public class Main {

	public static class Pair{
		int x;
		int y;
		
		public Pair(int a, int b) {
			x=a;
			y=b;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	public static HashMap<String,Integer> map=new HashMap<>();
	public static void exec(String act,int nb, int prev) {
		if (nb<7) {
			String tmp;
			for( int i=0;i<6;i++) {
				if (prev==-1 || i!=prev) {
					tmp=new StringBuilder(act).substring(0,i);
					tmp+=new StringBuilder(new StringBuilder(act).substring(i)).reverse().toString();
					if (map.get(tmp)== null)
						map.put(tmp, nb+1);
					else {
						map.put(tmp,Math.min(map.get(tmp), nb+1));
					}
					exec (tmp,nb+1,i);
				}
			}
		}
	}
	
	public static void main (String[] args) {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=sc.nextInt();
		int[] tab=new int[n];
		int sum=0;
		int max=0;
		for (int i=0;i<n;i++) {
			tab[i]=sc.nextInt();
			sum+=tab[i];
			if (max<tab[i]) max= tab[i];
		}
		int ans=max;
		int tmp=0;
		for (int i=0;i<n;i++) {
			tmp+=(max-tab[i]);
		}
		while (tmp<=sum) {
			ans++;
			tmp=0;
			for (int i=0;i<n;i++) {
				tmp+=(ans-tab[i]);
			}
		}
		out.println(ans);
		out.close();
	}
	
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
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