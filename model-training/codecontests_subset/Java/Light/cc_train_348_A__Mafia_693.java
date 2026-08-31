import java.util.*;

public class NewEmpty
{
    public static void main(String[] args)
    {
        Scanner blabla=new Scanner(System.in);
        long a,b=0,max=0,z;
        int n=blabla.nextInt();
        for (int i=0; i<n; i++){
            a=blabla.nextLong();
            b+=a;
            if (a>max)max=a;
        }
        z=b/(n-1);
        if (b%(n-1)!=0)z++;
        z=Math.max(z,max);
        System.out.println(z);
    }
}