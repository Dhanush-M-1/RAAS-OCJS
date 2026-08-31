import java.util.*;
public class cf42
{
    static ArrayList<ArrayList<Integer>> adj;
    static boolean visited[];static int count;
    public static void main(String ars[])
    {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        while(q-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int i=0;
           adj = new ArrayList<>();
           for (int u = 0; u < n; ++u) {
               adj.add(new ArrayList<>());     
            }
            for(i=0;i<m;i++)
            {
                int x=sc.nextInt();
                int y=sc.nextInt();
                adj.get(x-1).add(y-1);
                adj.get(y-1).add(x-1);
            }/*
            for(int k1=0;k1<n;k1++)
			{
			    if(adj.get(k1)!=null)
			    {
			    for(int m1=0;m1<adj.get(k1).size();m1++)
			    {
			        System.out.print(adj.get(k1).get(m1)+" ");
			     }
			    }
			     System.out.println();
			 }*/
            visited=new boolean[n];
            count=0;
            dfs(a-1,b-1);
            int u=n-count-1;
            //System.out.println(" count1= "+count);
		//	System.out.println(" u= "+u);
            visited=new boolean[n];
            count=0;
            dfs(b-1,a-1);
            int v=n-count-1;
            //System.out.println(" count2= "+count);
		//	System.out.println(" v= "+v);
            System.out.println((long)u*v);
        }
    }
    static void dfs(int s,int t)
        {
            visited[s]=true;
            count++;
            //System.out.println(" curr= "+s);
	    //System.out.println(" ex= "+t);
	    //System.out.println(" count= "+count);
            for(int i=0;i<adj.get(s).size();i++)
            {
                int next=adj.get(s).get(i);
             //   System.out.println(" next= "+next);
                if(!visited[next]&&next!=t)
                {
                    dfs(next,t);
                }
            }
        }
    }
            