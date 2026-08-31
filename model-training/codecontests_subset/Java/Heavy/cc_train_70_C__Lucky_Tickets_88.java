
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.*;
import java.math.BigInteger;
import static java.math.BigInteger.*;
import java.util.*;
public class C{
    class Pair
    {
        public int p,q;
        public Pair(int p,int q)
        {
            int g=BigInteger.valueOf(p).gcd(BigInteger.valueOf(q)).intValue();
            p/=g;
            q/=g;
            this.p=p;
            this.q=q;
        }
        public boolean equals(Object obj)
        {
            Pair other=(Pair)obj;
            return other.p==p && other.q==q;
        }
        public int hashCode()
        {
            return p*3217+q;
        }
    }
    void solve()throws Exception
    {               
        int maxx=nextInt();
        int maxy=nextInt();
        int w=nextInt();
        //double t1=System.currentTimeMillis();
        
        Pair[]all=new Pair[Math.max(maxx, maxy)+1];
        Pair[]other=new Pair[Math.max(maxx, maxy)+1];
        for(int i=1;i<all.length;i++)
        {
            all[i]=new Pair(i, rev(i));
            other[i]=new Pair(rev(i),i);
        
        }
        //System.out.println(System.currentTimeMillis());
        //double t2=System.currentTimeMillis();
        //System.out.println((t2-t1)/1000);
        HashMap<Pair, Integer>up=new HashMap<Pair, Integer>();
        HashMap<Pair, Integer>down=new HashMap<Pair, Integer>();
        for(int i=1;i<=maxx;i++)
        {
            if(!up.containsKey(all[i]))
                up.put(all[i], 1);
            else
                up.put(all[i], up.get(all[i])+1);
        }
        int start=-1;
        int cur=0;
        for(int i=1;;i++)
        {
            if(up.containsKey(other[i]))
                cur+=up.get(other[i]);
            if(!down.containsKey(other[i]))
                down.put(other[i], 1);
            else
                down.put(other[i], down.get(other[i])+1);
            if(cur>=w)
            {
                start=i;
                break;
            }
            if(i==maxy)
                break;
        }
        if(start==-1)
        {
            System.out.println(-1);
            return ;
        }
        //overflow
        int x=maxx;
        int y=start;
        long[]res=new long[]{x,y};      
        while(x>0)
        {
            if(down.containsKey(all[x]))
            {
                cur-=down.get(all[x]);
            }
            up.put(all[x], up.get(all[x])-1);
            if(up.get(all[x])==0)
                up.remove(all[x]);
            x--;
            while(cur<w)
            {
                y++;
                if(y==maxy+1)
                    break;
                if(up.containsKey(other[y]))
                    cur+=up.get(other[y]);
                if(!down.containsKey(other[y]))
                    down.put(other[y], 1);
                else
                    down.put(other[y], down.get(other[y])+1);
                
            }
            if(y==maxy+1)
                break;
            if(res[0]*res[1]>(long)x*y)
                res=new long[]{x,y};
        }       //
    
        
        System.out.println(res[0]+" "+res[1]);
    }
    
    int rev(int x)
    {
        StringBuilder sb=new StringBuilder(""+x);
        return Integer.parseInt(sb.reverse().toString());
    }

    BufferedReader reader;
    PrintWriter writer;
    StringTokenizer stk;
    void run()throws Exception
    {
        reader=new BufferedReader(new InputStreamReader(System.in));
        stk=null;
        writer=new PrintWriter(System.out);
        solve();
        reader.close();
        writer.close();
    }
    int nextInt()throws Exception
    {
        return Integer.parseInt(nextToken());
    }
    long nextLong()throws Exception
    {   
        return Long.parseLong(nextToken());
    }
    double nextDouble()throws Exception
    {       
        return Double.parseDouble(nextToken());
    }
    String nextString()throws Exception
    {
        return nextToken();
    }
    String nextLine()throws Exception
    {
        return reader.readLine();
    }
    String nextToken()throws Exception
    {
        if(stk==null || !stk.hasMoreTokens())
        {
            stk=new StringTokenizer(nextLine());
            return nextToken();
        }
        return stk.nextToken();
    }
    
    public static void main(String[]args) throws Exception
    {   
        new C().run();

    }
    
}