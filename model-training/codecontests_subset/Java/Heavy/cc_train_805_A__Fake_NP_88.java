import java.io.*;
import java.util.*;
public final class code
// class code
// public class Solution
{
static void solve()throws IOException
{
    int l=nextInt();
    int r=nextInt();
    if(l==r)
        out.println(l);
    else
        out.println(2);
}
///////////////////////////////////////////////////////////
public static void main(String args[])throws IOException
{
br=new BufferedReader(new InputStreamReader(System.in));
out=new PrintWriter(new BufferedOutputStream(System.out));
random=new Random();

solve();

// int t=nextInt();
// for(int i=1;i<=t;i++)
// {
// // out.print("Case #"+i+": ");
// solve();
// }

out.close();
}

static final long mod=(long)(1e9+7);
static final int inf=(int)(1e9+1);
// static final long inf=(long)(1e18);

static class Pair implements Comparable<Pair>
{
    int first,second;
    Pair(int a,int b)
    {
        first=a;
        second=b;
    }
    public int compareTo(Pair p)
    {
        return first-p.first;
    }
}

static int max(int ... a)
{
int ret=a[0];
for(int i=1;i<a.length;i++)
ret=Math.max(ret,a[i]);
return ret;
}
static int min(int ... a)
{
int ret=a[0];
for(int i=1;i<a.length;i++)
ret=Math.min(ret,a[i]);
return ret;
}
static void debug(Object ... a)
{
System.out.print("> ");
for(int i=0;i<a.length;i++)
System.out.print(a[i]+" ");
System.out.println();
}
static void debug(int a[]){debuga(Arrays.stream(a).boxed().toArray());}
static void debug(long a[]){debuga(Arrays.stream(a).boxed().toArray());}
static void debuga(Object a[])
{
System.out.print("> ");
for(int i=0;i<a.length;i++)
System.out.print(a[i]+" ");
System.out.println();
}
static Random random;
static BufferedReader br;
static StringTokenizer st;
static PrintWriter out;
static String nextToken()throws IOException
{
while(st==null || !st.hasMoreTokens())
st=new StringTokenizer(br.readLine());
return st.nextToken();
}
static String nextLine()throws IOException
{
return br.readLine();
}
static int nextInt()throws IOException
{
return Integer.parseInt(nextToken());
}
static long nextLong()throws IOException
{
return Long.parseLong(nextToken());
}
static double nextDouble()throws IOException
{
return Double.parseDouble(nextToken());
}
}