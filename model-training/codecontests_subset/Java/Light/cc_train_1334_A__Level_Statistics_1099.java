import java.util.*;
public class E85A
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int ar[]=new int[n];
            int br[]=new int[n];
            for(int x=0;x<n;x++)
            {
                ar[x]=sc.nextInt();
                br[x]=sc.nextInt();
            }
            System.out.println(solve(ar,br,n));
        }
    }
    public static String solve(int ar[],int br[],int n)
    {
        if(ar[0]<br[0])
        {
            return "NO";
        }
        for(int x=1;x<n;x++)
        {
            if(ar[x]<ar[x-1]||br[x]<br[x-1]||ar[x]<br[x]||(ar[x]-ar[x-1])<(br[x]-br[x-1]))
            {
                return "NO";
            }
        }
        return "YES";
    }
}