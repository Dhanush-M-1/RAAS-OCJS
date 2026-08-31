import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution
{
    static long fen[];
    static int n;
    public static void update(long x,int pos)
    {
        while(pos<=n)
        {
            fen[pos]+=x;
            pos=pos+(pos & -pos);
        }
    }
    public static long sum(int pos)
    {
        long sum=0;
        while(pos>0)
        {
            sum+=fen[pos];
            pos=pos- (pos & -pos);
        }
        return sum;
    }
    public static int binary(long x,int l,int r)
    {
        if(l==r)
            return l;
        else if(l+1==r)
        {
           if(sum(r)==x)
               return r;
           return l;
        }
        else
        {
            int mid=(l+r)/2;
            long z=sum(mid);
            if(z>x)
                return binary(x,l,mid-1);
            else
                return binary(x,mid,r);
        }
    }
    public static void main(String[] args) throws IOException{
        FastReader in=new FastReader(System.in);
        StringBuilder sb=new StringBuilder();
        int i,j;
        n=in.nextInt();
        long arr[]=new long[n];
        int ans[]=new int[n];
        fen=new long[n+1];
        for(i=0;i<n;i++)
            arr[i]=in.nextLong();
        for(i=0;i<n;i++)
            update(i,i+1);
        for(i=n-1;i>=0;i--)
        {
            ans[i]=binary(arr[i],1,n);
            update(-1*ans[i],ans[i]+1);
        }
        for(i=0;i<n;i++)
            sb.append(ans[i]).append(" ");
        System.out.print(sb);

    }
}
class Node implements Comparable<Node>
{
    int val;
    int pos;
    public Node(int v,int p)
    {
        val=v;
        pos=p;
    }
    public int compareTo(Node n)
    {
        if(this.val>n.val)
            return 1;
        else if(this.val<n.val)
            return -1;
        else
            return 0;
    }
}
class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    String nextLine() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c != 10 && c != 13; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    char nextChar() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        return (char) c;
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}