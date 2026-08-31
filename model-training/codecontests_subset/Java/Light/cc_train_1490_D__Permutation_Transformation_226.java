import java.util.*;
public class a
{
    public static void solve(int l,int r,int a[],int ans[],int depth,HashMap<Integer,Integer> h)
    {
        int max=Integer.MIN_VALUE;
        if(l>=r)
            return;
        for(int i=l;i<r;i++)
        {
            if(max<a[i])
                max=a[i];
        }
        ans[max]=depth;
        solve(l,h.get(max),a,ans,depth+1,h);
        solve(h.get(max)+1,r,a,ans,depth+1,h);

    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        
        int t=s.nextInt();
        //System.out.println("t "+t);
        while(t-->0)
        {
            int n=s.nextInt();
            int a[]=new int[n];
            int max=Integer.MIN_VALUE;
            HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
            for(int i=0;i<n;i++)
            {
                a[i]=s.nextInt();
                h.put(a[i],i);
            }
            
            int ans[]=new int[n+1];
            for(int  i=0;i<n;i++)
            {
                if(max<a[i])
                {
                    max=a[i];
                }
            }
            //System.out.println(max)
            int depth=0;
            ans[max]=depth;
            solve(0,h.get(max),a,ans,depth+1,h);
            solve(h.get(max)+1,n,a,ans,depth+1,h);
            for(int  i=0;i<n;i++)
                System.out.print(ans[a[i]]+" ");
            System.out.println();


        }
    }
}