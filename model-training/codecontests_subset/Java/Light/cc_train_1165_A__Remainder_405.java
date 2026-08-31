import java.io.*;
import java.util.*;
import java.math.*;
public class cf
{
    public static void main(String[] args) 
    {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int x=in.nextInt();
        int y=in.nextInt();
        int i,c=0;
        String s=in.nextLine();s=in.nextLine();
        char[] str=s.toCharArray();
        for( i=s.length()-x;i<s.length()-y-1;i++)
        {
            if(str[i]=='1')
                c++;
        }
        if(str[i]!='1')
        {
            c++;
        }
        i++;
        for(;i<s.length();i++)
        {
            if(str[i]!='0')
                c++;
        }
        System.out.println(c);
    }
}