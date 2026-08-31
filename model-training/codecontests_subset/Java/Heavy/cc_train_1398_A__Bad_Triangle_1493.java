import java.util.*;
import java.io.*;
public class p1
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int q=0; q<testCases; q++)
        {
            int len = scan.nextInt();
            int[] lengths = new int[len];
            for(int i=0; i<len; i++)
                lengths[i] = scan.nextInt();
            int first = lengths[0];
            int second = lengths[1];
            int last = lengths[len-1];
            if(first+second <= last)
                System.out.println("1 2 " + len);
            else
                System.out.println("-1");
        }
    }
}
