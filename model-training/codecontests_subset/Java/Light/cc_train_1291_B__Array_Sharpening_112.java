import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        while(tt-->0)
        {
            int flag=1;
            int n=sc.nextInt();
            int a[]=new int[n];
            HashMap<Integer,Integer> forward=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                if(a[i]>=i)
                    forward.put(i,1);
                else
                    break;
            }
            //System.out.println(forward.values());
            int index=0;
            for(int i=n-1;i>=0;i--)
            {
                if(a[i]>=index)
                {
                    if(forward.get(i)!=null)
                    {
                        System.out.println("Yes");
                        flag=0;
                        break;
                    }
                }
                else    
                    break;
                index++;
            }
            if(flag==1)
                System.out.println("No");
        }
    }
}