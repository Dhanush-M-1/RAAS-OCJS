import java.util.*;
public class Main
{
    
    public static void main(String arg[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int c=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        int max=0;
        int ind=1;
        for(int i=0;i<n-1;i++)
        {
            int m=arr[i]-arr[i+1];
            if(m>0 && m>max)
            max=m;
        }
        
        int ans=max-c;
        if(ans>0)
        System.out.println(ans);
        else
        System.out.println(0);
}
}
