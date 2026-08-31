import java.util.*;
import java.io.*;
public class EvilTriangle 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);

        int T;
        T=in.nextInt();
        while((T--)>0)
        {
            //code comes here
            int N=in.nextInt();
            int arr[]=new int[N];
            for(int i=0;i<N;i++)
            {
                arr[i]=in.nextInt();
            }
            long sum=(long)(arr[0]+arr[1]);
            if(sum>arr[N-1])
            {
                out.println("-1");

            }
            else
            out.println("1 2 "+N);

        }   
        out.flush();
        in.close();
        out.close();
    }

    static void printSDA(int arr[])
    {
        int l=arr.length;
        for(int i=0;i<l;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

}