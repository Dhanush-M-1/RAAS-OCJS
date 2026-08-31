import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Lucky 
{
    public static void main(String[] args) 
    {
        Scanner vicky=new Scanner(System.in);
       
        String s1=new String(vicky.next());
        String s2=new String(vicky.next());
        if(fun(s1).equals(fun(s2)))System.out.println("yes");
        else System.out.println("NO");
    }
    static String fun (String s)
    {
        int l=s.length();
        if((l&1)==1)
               return s;
        String s1=fun(s.substring(0,l/2));
        String s2=fun(s.substring(l/2));
        int j=0;
        while(j<l/2)
        {
            if(s1.charAt(j)==s2.charAt(j))j++;
            else if(s1.charAt(j)>s2.charAt(j))return s2+s1;
            else return s1+s2;
        }
        return s1+s2;
    }
}