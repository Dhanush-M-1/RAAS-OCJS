import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])
    {
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=1;
        while(T-->0)
        {
            int n=input.nextInt();
            int m=input.nextInt();
            int a[]=new int[n];
            int arr[]=new int[n+1];
            for(int i=0;i<n;i++)
            {
                a[i]=input.nextInt();
                arr[a[i]]=i;
            }
            ArrayList<Integer> adj[]=new ArrayList[n+1];
            for(int i=1;i<=n;i++)
            {
                adj[i]=new ArrayList<>();
            }
            int l=a[n-1];
            HashSet<Integer> set1=new HashSet<>();
            for(int i=0;i<m;i++)
            {
                int u=input.nextInt();
                int v=input.nextInt();
                if(arr[u]<arr[v])
                {
                    adj[u].add(v);
                    if(v==l)
                    {
                        set1.add(u);
                    }
                }
            }
            HashSet<Integer> set=new HashSet<>();
            int ans=0;
            for(int i=n-2;i>=0;i--)
            {
                if(set1.contains(a[i]))
                {
                    int count=0;
                    for(int j=0;j<adj[a[i]].size();j++)
                    {
                        int v=adj[a[i]].get(j);
                        if(set.contains(v))
                        {
                            count++;
                        }
                    }
                    if(count==set.size())
                    {
                        ans++;
                    }
                    else
                    {
                        set.add(a[i]);
                    }
                }
                else
                {
                    set.add(a[i]);
                }
            }
            out.println(ans);
        }
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
                catch (IOException e)
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