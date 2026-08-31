import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        long l=0;
        int count=0;
        String s;
        while(scan.hasNextLine())
        {
            s=scan.nextLine();
            if(s.charAt(0)=='+')
                count++;
            else if(s.charAt(0)=='-')
                count--;
            else
                l += count*(s.length()-s.indexOf(':')-1);
        }
        System.out.println(l);
    }
}