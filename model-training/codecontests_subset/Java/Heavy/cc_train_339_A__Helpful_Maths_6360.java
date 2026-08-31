import java.io.*;
import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String []args)
    {
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        int n=s.length();
        int arr[]=new int[(n+1)/2];
        int k=0;
        String xx;
        if(n>1)
        {
            for(int i=0;i<arr.length;i++)
            {
                xx=""+s.charAt(k);
                arr[i]=Integer.parseInt(xx);
                k=k+2;
            }
            Arrays.sort(arr);
            for(int i=0;i<arr.length-1;i++)
            {
                System.out.print(arr[i]+"+");
            }
            System.out.print(arr[((n+1)/2)-1]);
        }
        else
            System.out.println(s);
    }
}