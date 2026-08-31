
import java.util.*;
import java.io.*;
import java.math.*;
public class aprail152
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
        int up;
        int down;
        public card(int u,int d)
        {
            this.up=u;
            this.down=d;
        }
    }
    static class sort implements Comparator<card>
    {
        public int compare(card o1,card o2)
        {
            if(o1.down!=o2.down)
                return (o1.down-o2.down)*-1;
            else
                return (o1.up-o2.up)*-1;
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

    static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
    static long ans=1;
    static boolean v[]=new boolean[101];
    static void dfs(Integer so,Set<Integer> s[]){
        if(!v[so.intValue()])
        {
            v[so]=true;
            for(Integer h:s[so.intValue()])
            {
                if(!v[h.intValue()])
                    dfs(h,s);
            }
        }
    }
    static class Print{
        public PrintWriter out;
        Print(OutputStream o)
        {
            out=new PrintWriter(o);
        }
    }
    public static void main(String args[])
    {
        InputReader sc=new InputReader(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        char c[]=s.toCharArray();
        Arrays.sort(c);
        int f=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=c[i])
            {
                f=1;
                break;
            }
        }
        if(f==1)
        {
            int fi=1,la=0;char ch=s.charAt(0);
            for(int i=1;i<n;i++)
            {
                if(s.charAt(i)<ch)
                {
                    la=i+1;
                    break;
                }
                else
                {
                    ch=s.charAt(i);
                    fi=i+1;
                }
            }
            System.out.println("YES");
            System.out.println(fi+" "+la);
        }
        else
        System.out.println("NO");
    }
}
