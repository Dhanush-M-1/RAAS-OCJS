import java.lang.*;
import java.util.*;
public class rem
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        StringBuffer a=new StringBuffer();
        a.append(sc.next());
        int c=0;
        int j=n-1;
        while(j>(n-y-1))
        {
            if(a.charAt(j)!='0')
            {
            a.insert(j--,'0');
            c++;
            }
            else
            {
                j--;
            }
        }
        if(a.charAt(j)!='1')
        {
        a.insert(j--,'1');
        c++;
        }
        else
        {
            j--;
        }
        while(j>(n-x-1))
        {
            if(a.charAt(j)!='0')
            {
            a.insert(j--,'0');
            c++;
            }
            else
            {
                j--;
            }
        }
            System.out.println(c);
        }
}   