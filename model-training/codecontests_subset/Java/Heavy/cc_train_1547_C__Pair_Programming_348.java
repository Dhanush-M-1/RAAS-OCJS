import java.util.*;
import java.io.*;
public class PairPro{
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc= new Scanner (System.in);
        
        //Code From Here----
                
        int t=fr.nextInt();
        while (t-->0) {
            int k=fr.nextInt();
            int m=fr.nextInt();
            int n=fr.nextInt();
            int [] mon= new int [m];
            int [] pol=new int[n];
            for (int i = 0; i < mon.length; i++) {
                mon[i]=fr.nextInt();
            }
            for (int i = 0; i < pol.length; i++) {
                pol[i]=fr.nextInt();
            }
            int mc=0;
            int pc=0;
            int [] sol=new int [m+n];
            boolean cond=true;
			int counter=0;
            while(pc!=n || mc!=m)
			{
				if(pc!=n && pol[pc]==0)
				{
					sol[counter++]=pol[pc++];
					k++;
				}
				else if(mc!=m && mon[mc]==0)
				{
					sol[counter++]=mon[mc++];
					k++;

				}
				else if(pc!=n && pol[pc]<=k)
				{
					sol[counter++]=pol[pc++];
				}
				else if(mc!=m && mon[mc]<=k)
				{
					sol[counter++]=mon[mc++];
					
				}
				else
				{
					cond=false;
					break;
				}
			}
            if (cond) {
                for (int i = 0; i < sol.length; i++) {
                    out.print(sol[i]+" ");
                }
                out.println();
            }
            else
            out.println("-1");
        }



        
        out.flush();
        sc.close();
    }

    //This RadixSort() is for long method

    public static long[] radixSort(long[] f){ return radixSort(f, f.length); }
	public static long[] radixSort(long[] f, int n)
	{
		long[] to = new long[n];
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(int)(f[i]&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[(int)(f[i]&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(int)(f[i]>>>16&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[(int)(f[i]>>>16&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(int)(f[i]>>>32&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[(int)(f[i]>>>32&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < n;i++)b[1+(int)(f[i]>>>48&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < n;i++)to[b[(int)(f[i]>>>48&0xffff)]++] = f[i];
			long[] d = f; f = to;to = d;
		}
		return f;
	}
    // For Fast Input  ----
    
    
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(
				new InputStreamReader(System.in));
		}

		String next()
		{
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() { return Integer.parseInt(next()); }

		long nextLong() { return Long.parseLong(next()); }

		double nextDouble()
		{
			return Double.parseDouble(next());
		}

		String nextLine()
		{
			String str = "";
			try {
				str = br.readLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}



    
}
