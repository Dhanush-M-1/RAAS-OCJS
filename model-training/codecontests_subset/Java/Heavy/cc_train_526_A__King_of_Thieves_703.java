import java.io.*;
import java.util.*;


public class A
{
    public static void main(String [] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        char [] map = reader.readLine().toCharArray();

        boolean res = false;
        for(int s = 0 ; s < n ; s++)
            if(map[s] == '*')
                for(int jumpLen = 1 ; jumpLen <= n ; jumpLen++)
                {
                    boolean good = true;
                    for(int k = 1 ; k <= 4 ; k++)
                        if(!(s + k*jumpLen < n && map[s+k*jumpLen] == '*'))
                            good = false;
                    if(good)
                        res = true;
                }

        if(res)
            writer.println("yes");
        else
            writer.println("no");

        writer.flush();
        writer.close();
    }
}