import java.io.*;
import java.util.*;
public class B643 
{
    static HashMap<Integer,ArrayList<Integer>> map;
    static int pri[],c=0;
    static void dfs(int a,int b,int n,int last)
    {
        Stack st=new Stack();
            st.push(a);
            boolean vis[]=new boolean[n+1];vis[a]=true;
            while(st.size()!=0)
            {
                int x=(Integer)st.pop();
                System.out.print(x+" ");
                for(int j:map.get(x))
                {
                    if(j==b && x==last)
                        continue;
                    if(!vis[j])
                    {
                        vis[j]=true;
                        st.push(j);
                    }
                }
            }
            System.out.println();
    }
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        if(k<=n || n==4)
            System.out.println(-1);
        else
        {
            int arr[]=new int[n+1];
            map=new HashMap<>();
            for(int i=1;i<=n;i++)
            {
                map.put(i,new ArrayList<>());
            }
            map.get(a).add(c);
            map.get(c).add(a);
            map.get(b).add(d);
            map.get(d).add(b);
            arr[a]=arr[b]=arr[c]=arr[d]=1;
            int i=1,last=a,f=0;
            while(i<=n)
            {
                if(arr[i]==0)
                {
                    if(f==0)
                    {
                        map.get(a).add(i);
                        map.get(c).add(i);
                        map.get(i).add(a);map.get(i).add(c);
                        f=1;last=i;
                    }
                    else
                    {
                        map.get(i).add(last);
                        map.get(last).add(i);
                        last=i;
                    }
                }
                i++;
            }
            map.get(b).add(last);
            map.get(d).add(last);
            map.get(last).add(b);map.get(last).add(d);
            //System.out.println(map);
            int temp=map.get(a).remove(1);
            dfs(a,b,n,last);
            map.get(a).add(temp);
            map.get(c).remove(1);
            dfs(c,d,n,last);
            
        }
    }
}
