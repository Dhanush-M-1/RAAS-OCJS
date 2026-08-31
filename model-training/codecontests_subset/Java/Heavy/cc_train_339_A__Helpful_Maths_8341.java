
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{

    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String sum="";
        char[] charray=s.toCharArray();
        for(char c:charray)
        {
            if(c!='+')
            {
                sum=sum+c;
            }
        }
        char[] str=sum.toCharArray();
        Arrays.sort(str);
        String sorted=new String(str);
        for(int i=0;i<sorted.length();i++)
        {
            if(i==sorted.length()-1)
                System.out.print(sorted.charAt(i));
            else
                System.out.print(sorted.charAt(i)+"+");

        }

    }

}