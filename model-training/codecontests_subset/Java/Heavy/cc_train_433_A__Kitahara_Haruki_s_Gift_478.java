import java.util.*;
public class haruki_gift
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a1[] = new int[n];
        int a2[] = new int[n];
        int na1 = 0, na2 = 0;
        for(int i=0 ; i<n ; i++)
        {
            int x = in.nextInt();
            if(x==100)
            {
                a1[na1]=x;
                na1++;
            }
            else
            {
                a2[na2]=x;
                na2++;
            }
        }
        if(na1==0&&na2%2!=0)
        System.out.println("NO");
        else if(na1==0&&na2%2==0)
        System.out.println("YES");
        else if(na1>0&&na1%2==0)
        System.out.println("YES");
        else if(na1>0&&na1%2!=0)
        System.out.println("NO");
    }
}
        
    