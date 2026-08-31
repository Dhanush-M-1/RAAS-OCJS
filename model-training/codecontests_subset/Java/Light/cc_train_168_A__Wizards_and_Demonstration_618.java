import java.util.*;

public class wizard
{
    public static void main(String[] args)
    {
        try
        {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int p=sc.nextInt();
        int sm=(int)Math.ceil((p/100.0)*n);
        if(sm>=k)
            System.out.println(sm-k);
        else
            System.out.println(0);
        }
        catch(Exception e)
        {
            return;
        }
    }
}
