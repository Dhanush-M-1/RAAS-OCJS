import java.util.*;
import java.io.*;
public class cf
{
    static int n;
    static int arr[];
    public static void main(String[] args)
    {
        PrintWriter out= new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        int max=0;
        long sum=0;
        for(int i = 0 ;i<n;i++)
        {
             arr[i]=sc.nextInt();
             max=Math.max(max,arr[i]);
             sum+=arr[i];
        }
        System.out.println(Math.max(max,(long)(Math.ceil(sum*1.0/(n-1)))));
    }
}
    

 