import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j,k;
        int r[]={1,-1,0,0,-1,-1,1,1};
        int c[]={0,0,-1,1,-1,1,1,-1};
        int sx=sc.nextInt();
        int sy=sc.nextInt();
        int ex=sc.nextInt();
        int ey=sc.nextInt();
        
        HashMap<Pair,Boolean> hm=new HashMap<>();
        int n=sc.nextInt();
        for(i=1;i<=n;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int C=sc.nextInt();
            for(j=b;j<=C;j++)
            hm.put(new Pair(a,j),true);
        }
        
        HashMap<Pair,Boolean> visited=new HashMap<>();
        Queue<Triplet> q=new LinkedList<>();
        q.add(new Triplet(sx,sy,0));
        visited.put(new Pair(sx,sy),true);
        
        while(!q.isEmpty())
        {
            Triplet P=q.poll();
            int x=P.a;
            int y=P.b;
            int cost=P.len;
            if(x==ex&&y==ey)
            {
                System.out.println(cost);
                return;
            }
            for(i=0;i<8;i++)
            {
                int dx=x+r[i];
                int dy=y+c[i];
                if(isValid(dx,dy,visited,hm))
                {
                    q.add(new Triplet(dx,dy,cost+1));
                    visited.put(new Pair(dx,dy),true);
                }
            }
        }
        System.out.println(-1);
    }
    public static boolean isValid(int x,int y,HashMap<Pair,Boolean> visited,HashMap<Pair,Boolean> hm)
    {
        if(hm.get(new Pair(x,y))!=null&&visited.get(new Pair(x,y))==null)
        return true;
        return false;
    }
}
class Pair
{
    int a,b;
    Pair(int x,int y)
    {
        a=x;
        b=y;
    }
    public boolean equals(Object obj) 
    {
		if(obj==null||obj.getClass()!=this.getClass()) 
        return false;
        Pair p=(Pair)obj;
        return (this.a==p.a&&this.b==p.b);
    }
	public int hashCode() 
	{
        return Objects.hash(a,b);
    }
}
class Triplet 
{
    int a,b,len;
    Triplet(int x,int y,int l)
    {
        a=x;
        b=y;
        len=l;
    }
}