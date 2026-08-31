import java.io.*;
import java.util.*;
public class Main {
    static long xvar=0;
    public static void main(String args[])
    {
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=input.nextInt();
        while(T-->0)
        {
            int n=input.nextInt();
            int m=input.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=input.nextInt();
            }
            int x[]=new int[m];
            for(int i=0;i<m;i++)
            {
                x[i]=input.nextInt();
            }
            Pair pre[]=new Pair[n];
            long max=Long.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                if(i==0)
                {
                    pre[i]=new Pair(a[i],0);
                }
                else
                {
                    pre[i]=new Pair(pre[i-1].val+a[i],i);
                }
                max=Math.max(max,pre[i].val);
            }
            long v=pre[n-1].val;
            if(v<=0)
            {
                TreeMap<Long,Integer> map=new TreeMap<>();
                long p=Long.MIN_VALUE;
                for(int i=0;i<n;i++)
                {
                    if(p<pre[i].val)
                    {
                        map.put(pre[i].val,i);
                        p=pre[i].val;
                    }
                }
                for(int i=0;i<m;i++)
                {
                    long y=x[i];
                    if(y>max)
                    {
                        out.print(-1+" ");
                    }
                    else
                    {
                        long k=map.ceilingKey(y);
                        int ind=map.get(k);
                        out.print(ind+" ");
                    }
                }
                out.println();
            }
            else
            {
                mergeSort(pre,0,n-1);
                int min=Integer.MAX_VALUE;
                for(int i=0;i<n;i++)
                {
                    min=Math.min(min,pre[i].index);
                    pre[i].index=min;
                }
                for(int i=0;i<m;i++)
                {
                    int y=x[i];
                    int ind=fun(pre,y,v);
                    ind=pre[ind].index;
                    long ans=ind+(xvar-1)*n;
                    out.print(ans+" ");
                }
                out.println();
            }
        }
        out.close();
    }
    public static int fun(Pair pre[],int y,long v)
    {
        long x=0;
        long val=pre[0].val;
        if(y<=val)
        {
            x=1;
        }
        else
        {
            long d=y-val;
            long q=d/v;
            if(d%v!=0)
            {
                q++;
            }
            q++;
            x=q;
        }
        xvar=x;
        int i=0,j=pre.length;
        while(i<j)
        {
            int mid=(i+j)/2;
            val=pre[mid].val;
            long x1=0;
            if(y<=val)
            {
                x1=1;
            }
            else
            {
                long d=y-val;
                long q=d/v;
                if(d%v!=0)
                {
                    q++;
                }
                q++;
                x1=q;
            }
            if(x1==x)
            {
                i=mid+1;
            }
            else
            {
                j=mid;
            }
        }
        return i-1;
    }
    public static void mergeSort(Pair a[],int p,int r)
    {
        if(p<r)
        {
            int q=(p+r)/2;
            mergeSort(a,p,q);
            mergeSort(a,q+1,r);
            merge(a,p,q,r);
        }
    }
    public static void merge(Pair a[],int p,int q,int r)
    {
        int n1=q-p+2;
        Pair L[]=new Pair[n1];
        int n2=r-q+1;
        Pair R[]=new Pair[n2];
        for(int i=p;i<=q;i++)
        {
            L[i-p]=a[i];
        }
        L[n1-1]=new Pair(Long.MIN_VALUE,0);
        for(int i=q+1;i<=r;i++)
        {
            R[i-q-1]=a[i];
        }
        R[n2-1]=new Pair(Long.MIN_VALUE,0);
        int x=0,y=0;
        for(int i=p;i<=r;i++)
        {
            if(L[x].val>=R[y].val)
            {
                a[i]=L[x];
                x++;
            }
            else
            {
                a[i]=R[y];
                y++;
            }
        }
    }
    static class Pair
    {
        long val;
        int index;
        Pair(long val,int index)
        {
            this.val=val;
            this.index=index;
        }
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
            String str="";
            try
            {
                str=br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}