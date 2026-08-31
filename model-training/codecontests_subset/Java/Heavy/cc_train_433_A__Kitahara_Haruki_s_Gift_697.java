import java.util.Scanner;
public class Main
{
    public static void main ( String args[])
    {
        Scanner in = new Scanner (System.in);
        int z=0,s1=0,s2=0,x=in.nextInt();
        int y [] = new int [x];
        for(int i=0;i<y.length;i++)
        {
            y[i]=in.nextInt();
        }
        for(int i=0;i<y.length;i++)
        {
            if(y[i]==100)s1++;
            else s2+=2;
            z++;
        }
        if(x%2==0)
        {
            if(((s1+s2)%2==0))
                System.out.println("YES");
            else
                System.out.println("NO");
    }
        else
        {
            if(((s1+s2)%2==0)&&s1!=0&&s2!=0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
}
}
