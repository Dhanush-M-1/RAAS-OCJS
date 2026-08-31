import java.io.*;
import java.util.*;
public class test
{
    public static void main(String args[])
    {
        //System.out.println("Welcome");
        inputs in=new inputs(System.in);
        int n=in.nextInt(),k=in.nextInt(),
        s=in.nextInt(),t=in.nextInt();
        
        car cars[]=new car[n];
        
        for(int i=0;i<n;i++)
        {
            cars[i]=new car(in.nextInt(),in.nextInt());
        }
        Arrays.sort(cars);
        int ks[]=new int[k];
        
        for(int i=0;i<k;i++)
        {
            ks[i]=in.nextInt();
        }
        
        Arrays.sort(ks);
        
        int d[]=new int[k+2];
        
        d[0]=ks[0];
        d[k]=s-ks[k-1];
        d[k+1]=Integer.MAX_VALUE;
        for( int i=1;i<k;i++)
        {
            d[i]=ks[i]-ks[i-1];
        }
        
        Arrays.sort(d);
        int fre=1,cd=d[0];
        TreeSet<distance> set=new TreeSet<distance>();
        set.add(new distance(0,0,0));
        for(int i=1;i<=k+1;i++)
        {
            if(d[i]!=d[i-1])
            {
                set.add(new distance(d[i-1],fre,cd));
                
            }
            else
            {
                
            }
            cd+=d[i];
            fre++;
        }
        
        /*for(distance q:set)
        {
            out(""+q.d+"---"+q.f+"----"+q.cd);
        } */
        int j=-1;
        for(int i=0;i<n;i++)
        {
           if(d[k]>cars[i].v) continue;
           
           distance di=set.floor(new distance(cars[i].v/2,0,0));
           int value=3*s-2*di.cd-(k+1-di.f)*cars[i].v;
           //out("i="+i+" value="+value+" cd="+di.cd+" f="+di.f+" k="+k+" v="+cars[i].v+" s="+s);
           if(value<=t) { j=i; break; }
        }
        
        if(j==-1) { out("-1"); return; }
        int ans=Integer.MAX_VALUE;
        for(int i=j;i<n;i++)
        {
            //out("i="+i);
            ans=Math.min(cars[i].c,ans);
        }
        
        out(""+ans);
    }
    
    static void out(String s)
    {
        System.out.println(s);
    }
}

class inputs
{
    public BufferedReader reader;
    public StringTokenizer token;
    
    inputs(InputStream str)
    {
        reader=new BufferedReader(new InputStreamReader(str));
        token=null;
    }
    
    int nextInt()
    {
        while(token==null||!token.hasMoreTokens())
        {
            try { token=new StringTokenizer(reader.readLine());   }
            catch(IOException e){  throw new RuntimeException(e); }
        }
        return Integer.parseInt(token.nextToken());
    }
    
    String next()
    {
        while(token==null||!token.hasMoreTokens())
        {
            try { token=new StringTokenizer(reader.readLine());   }
            catch(IOException e){  throw new RuntimeException(e); }
        }
        return token.nextToken();
    }
    
}

class car implements Comparable<car>
{
    int c,v;
    car(int a,int b)
    {
        c=a;
        v=b;
    }
    
    public int compareTo(car z)
    {
        return this.v-z.v;
    }
}

class distance implements Comparable<distance>
{
    int d,f,cd;
    distance(int a,int b,int c)
    {
        d=a;
        f=b;
        cd=c;
    }
    
    public int compareTo(distance a)
    {
        return this.d-a.d;
    }
}