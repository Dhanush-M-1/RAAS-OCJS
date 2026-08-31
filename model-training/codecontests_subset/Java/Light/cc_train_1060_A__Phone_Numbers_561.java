import java.util.*;
public class Phone_Numbers
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        int n = s1.nextInt();
        String s = s1.next();
        int eight = 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i) == '8')
                eight++;
        if(eight == 0 || n < 11)
            System.out.println("0");
        else
            System.out.println(Math.min(n/11,eight));
        s1.close();
    }
}