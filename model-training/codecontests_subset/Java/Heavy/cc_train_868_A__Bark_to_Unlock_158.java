import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=sc.nextInt();
        sc.nextLine();
        String arr[]=new String[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.next();
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                String w=arr[i]+arr[j];
                for(int k=0;k<3;k++)
                {
                    String sub=w.substring(k,k+2);
                    if(sub.compareTo(s)==0)
                    {
                        System.out.println("YES");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("NO");
    }
}