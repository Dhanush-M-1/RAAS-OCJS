import java.text.DecimalFormat;
import java.util.*;

public class Problem
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            DecimalFormat df = new DecimalFormat("#.##########");
            double a=Math.cos(Math.toRadians(180.0/(4*n)));
            double b=Math.sin(Math.toRadians(180.0/(2*n)));
            double ans=a/b;
            System.out.println(df.format(ans));
        }

    }

}



