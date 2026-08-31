import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=1;//Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n=Integer.parseInt(br.readLine().trim());
            String s[]=br.readLine().trim().split(" ");
            int j=0,k=0;
            for(int i=0;i<n;i++)
                if(Integer.parseInt(s[i])%2==0) j++;
                else    k++;
            int a[]=new int[j];
            int b[]=new int[k];
            for(int i=0,l=0,m=0;i<n;i++)
                if(Integer.parseInt(s[i])%2==0)
                    a[l++]=Integer.parseInt(s[i]);
                else
                    b[m++]=Integer.parseInt(s[i]);
            Arrays.sort(a);
            Arrays.sort(b);
            int max=j;
            if(max<k)
                max=k;
            if(max==j)
            {
                int temp=j-k,sum=0;
                for(int i=0;i<temp-1;i++)
                    sum+=a[i];
                System.out.println(sum);
            }
            else
            {
                int temp=k-j,sum=0;
                for(int i=0;i<temp-1;i++)
                    sum+=b[i];
                System.out.println(sum);
            }
        }
    }
}
