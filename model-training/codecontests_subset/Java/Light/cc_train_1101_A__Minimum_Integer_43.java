import java.util.*;
public class om
{
    public static void main(String[]st)
    {
        Scanner scan=new Scanner(System.in);
        long q,i;
        long div,start,end,x;
        q=scan.nextLong();
        while(q!=0)
        {
            start=scan.nextLong();
            end=scan.nextLong();
            x=scan.nextLong();
            if(x < start)
                div=x;
            else
            {
                div=end/x + 1;
                div=div*x;
            }
            System.out.println(""+div);
            q--;
        }
    }
}