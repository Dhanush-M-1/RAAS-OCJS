
import java.util.*;
import java.io.*;
import java.math.*;
public class loser
{
    static class InputReader {
        public BufferedReader br;
        public StringTokenizer token;
        public InputReader(InputStream stream)
        {
            br=new BufferedReader(new InputStreamReader(stream),32768);
            token=null;
        }

        public String next()
        {
            while(token==null || !token.hasMoreTokens())
            {
                try
                {
                    token=new StringTokenizer(br.readLine());
                }
                catch(IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
            return token.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }

        public long nextLong()
        {
            return Long.parseLong(next());
        }
    }
    static class card{
        String s;
        int l;
        public card(String s,int i)
        {
            this.s=s;
            this.l=i;
        }
    }
    static class sort implements Comparator<card>
    {
        public int compare(card o1,card o2)
        {
            if(o1.l!=o2.l)
                return (o1.l-o2.l);
            else
                return o1.s.compareTo(o2.s);
        }
    }
    static void shuffle(long a[])
    {
        List<Long> l=new ArrayList<>();
        for(int i=0;i<a.length;i++)
            l.add(a[i]);
        Collections.shuffle(l);
        for(int i=0;i<a.length;i++)
            a[i]=l.get(i);
    }

    /*static long gcd(long a,long b)
    {
    if(b==0)
    return a;
    else
    return gcd(b,a%b);
    }*/
    /*static boolean valid(int i,int j)
    {
    if(i<4 && i>=0 && j<4 && j>=0)
    return true;
    else
    return false;
    }*/
    public  static void main(String[] args) 
    {
        InputReader sc=new InputReader(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        double y=sc.nextInt()*0.01;
        long d=(long)Math.ceil(y*n);
        if(d<=x)
        System.out.println(0);
        else
        System.out.println(d-x);
    }
}