/**
 * Created by ankeet on 7/13/16.
 */
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.math.*;

public class D691 {

    public static BufferedReader read = null;
    public static PrintWriter out = null;
    public static StringTokenizer token = null;


    public static void solve()
    {
        int n = nint();
        int m = nint();
        int[] p = narr(n);
        DisjointSet ds = new DisjointSet(n);
        for(int i=0; i<m; i++)
        {
            ds.Union(nint()-1, nint()-1);
        }
        for(int i=0; i<n; i++) ds.Find(i);
        ArrayList<ArrayList<Integer>> ll = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) ll.add(new ArrayList<Integer>(0));
        for(int i=0; i<n; i++)
        {
            ll.get(ds.Find(i)).add(i);
        }
        for(int i=0; i<n; i++)
        {
            if(ll.get(i).size()>1)
            {
                Integer[] s = new Integer[ll.get(i).size()];
                for(int j=0; j<s.length; j++)
                {
                    s[j] = p[ll.get(i).get(j)];
                }
                Arrays.sort(s);
                for(int j=0; j<s.length; j++)
                {
                    p[ll.get(i).get(j)] = s[s.length-j-1];
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            out.print(p[i] + " ");
        }


    }

    public static void main(String[] args)
    {
        read = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
        out.close();

    }

    // i/o functions
    public static String next() // returns the next string
    {
        while(token == null || !token.hasMoreTokens())
        {
            try {
                token = new StringTokenizer(read.readLine());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return token.nextToken();
    }

    public static int nint()
    {
        return Integer.parseInt(next());
    }
    public static long nlong()
    {
        return Long.parseLong(next());
    }
    public static double ndouble()
    {
        return Double.parseDouble(next());
    }
    public static int[] narr(int n)
    {
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = nint();
        return a;
    }

    public static long[] nlarr(int n)
    {
        long[] a = new long[n];
        for(int i=0; i<n; i++) a[i] = nlong();
        return a;
    }


}


class DisjointSet {

    public int[] parent;
    private int[] rank; //for Union speedup
    //public int[] setSize;
    public DisjointSet(int size)
    {
        this.parent = new int[size];
        this.rank = new int[size];
        //this.setSize = new int[size];
        for(int i=0; i<size; i++)
        {
            this.parent[i] = i;
            this.rank[i] = 0;
            //this.setSize[i] = 1;
        }
    }

    public int Find(int i)
    {
        return this.parent[i] = (this.parent[i] == i ? i : Find(this.parent[i]));
    }

    public void Union(int p, int q)
    {
        int prep = Find(p);
        int qrep = Find(q);
        if(prep == qrep) return; // already in the same set

        if(this.rank[prep] < this.rank[qrep])
        {
            this.parent[prep] = qrep;
            //this.setSize[qrep] += this.setSize[prep];
        }
        else if(this.rank[prep] > this.rank[qrep])
        {
            this.parent[qrep] = prep;
            //this.setSize[prep] += this.setSize[qrep];
        }
        else
        {
            this.parent[prep] = qrep;
            //this.setSize[qrep] += this.setSize[prep];
            this.rank[qrep]++;
        }
    }


}
