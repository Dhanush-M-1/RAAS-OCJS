import java.io.*;
import java.util.*;

public class PhoneNumbers
{

    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n=Integer.parseInt(st.nextToken());
        StringBuilder str=new StringBuilder(br.readLine());
        int count=0;
        for(int i=0;i<n;i++)
        {
            int ch=str.charAt(i)-48;
            if(ch==8)
                count++;
        }
        System.out.println(Math.min(count,n/11));
    }
}