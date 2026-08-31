import java.io.*;
import java.util.*;
public class stats
{
    public static void main(String[] args)
    {
        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        for(int i = 0; i < n; ++i)
        {
            System.out.println(solve(f));
        }
    }
    
    public static String solve(Scanner f)
    {
        int n = f.nextInt();
        int p = 0;
        int c = 0;
        boolean flag = true;
        for(int i = 0; i < n; ++i)
        {
            int play = f.nextInt();
            int clear = f.nextInt();
            if(play < p)
                flag = false;
            if(clear < c)
                flag = false;
            if(play < clear)
                flag = false;
            if(play - p < clear - c)
                flag = false;
            p = play;
            c = clear;
        }
        if(flag)
            return "YES";
        return "NO";
    }
}