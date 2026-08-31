import java.util.Scanner;
import java.awt.image.BandedSampleModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class D {


    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int cases = sc.nextInt();


            long nodes[]=new long[2000002];
            long arr[]=new long[2000002];
            arr[0]=0;
            arr[1]=0;
            arr[2]=4;
            arr[3]=4;
            nodes[0]=1;
            nodes[1]=1;
            nodes[2]=3;
            for(int j=3;j<2000002;j++)
            {
                nodes[j]=2*nodes[j-2]%1000000007+nodes[j-1]%1000000007;
            }

            for(int j=3;j<2000002;j++)
            {
                arr[j]=arr[j-3]%1000000007+4*nodes[j-2]%1000000007;
            }
        for(int i=0;i<cases;i++)
        {
            int n = sc.nextInt();

            System.out.println(arr[n-1]%1000000007);
        }

    }
}
