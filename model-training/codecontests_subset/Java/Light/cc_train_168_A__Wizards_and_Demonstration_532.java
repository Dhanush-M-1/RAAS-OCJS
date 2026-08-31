import java.io.*;
import java.util.Arrays;

public class icpc
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s[] = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);

        int z = (int)Math.ceil(((double)y/(double)100) * n);
        if(z-x>0)   
            System.out.println( z-x);
        else
            System.out.println("0");
    }
}