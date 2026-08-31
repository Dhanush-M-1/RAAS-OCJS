import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int l=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
        if(r==l) sb.append(r);
        else sb.append(2);
        System.out.print(sb);
    }
}
