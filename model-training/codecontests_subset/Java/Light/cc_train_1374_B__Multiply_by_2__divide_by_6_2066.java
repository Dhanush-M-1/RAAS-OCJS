//created by Whiplash99
import java.io.*;
import java.util.*;
public class B
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i;

        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();
        while(T-->0)
        {
            long N=Integer.parseInt(br.readLine().trim());
            if(N==1)
            {
                sb.append(0).append("\n");
                continue;
            }
            int count=0;
            while (N%3==0)
            {
                N/=3;
                count++;
            }
            int count2=0;
            while (N%2==0)
            {
                N/=2;
                count2++;
            }

            if(count==0||count2>count||N>1) sb.append(-1).append("\n");
            else sb.append(2*count-count2).append("\n");
        }
        System.out.println(sb);
    }
}