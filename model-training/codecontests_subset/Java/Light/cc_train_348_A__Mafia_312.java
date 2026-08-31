import java.io.*;
import java.util.*;
public class Mafia 
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        //while(in.hasNext())
        {
        int n = in.nextInt();
        int max, temp;
        long sum=0;
        int count=0;
        max=0;
        for (int i = 0; i < n; i++) 
        {
            temp=in.nextInt();
            max=Math.max(temp, max);
            sum += temp;
        }
        //System.out.println(sum);
        count = (int)Math.ceil(sum/((double)n-1));
        if(count>=max)
        System.out.println(count);
        else
                System.out.println(max);
        }
    }

}