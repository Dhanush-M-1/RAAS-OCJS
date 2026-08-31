import java.util.*;
import java.lang.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            //Arrays.sort(arr);
            int k=-1;
            for(int i=2;i<n;i++)
            {
                if(arr[0]+arr[1]<=arr[i])
                {
                    k=i+1;
                    break;
                }
            }
            if(k==-1)
            System.out.println(k);
            else
            System.out.println(1+" "+2+" "+k);
        }
    }
}