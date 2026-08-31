import java.util.*;
import java.io.*;

public class strrev
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        String s[]=in.nextLine().split("\\+");
        Arrays.sort(s);
        for(int i=0;i<s.length;i++)
        {
            System.out.print(s[i]);
            if(i<s.length-1)
                System.out.print("+");
        }
    }
}