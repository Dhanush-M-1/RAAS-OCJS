import java.util.*;
public class pon
{
    public static void main(String[] args)
    {
        String str="";
        Scanner k=new Scanner(System.in);
        int a=k.nextInt();
        str=k.next();
        int c=0;
        for(int i=0;i<a;i++)
        {
            if(str.charAt(i)=='8')
            c++;
        }
        int mnp=a/11;
        if(mnp<=c)
        System.out.println(mnp);
        else
        System.out.println(c);
    }
}

        
        
        
        