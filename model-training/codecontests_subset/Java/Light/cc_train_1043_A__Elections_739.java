import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] argh){
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int temp=0,sum=0,max=0;
        for(int i=0;i<n;i++)
        {
            int ai=s.nextInt();
            sum+=ai;
            if(ai>max)
                max=ai;
        }
        sum=2*sum+1;
        int k=(sum%n==0)? sum/n:sum/n+1;
        k=(max>k)? max:k;
        System.out.println(k);
        return;
    }
}