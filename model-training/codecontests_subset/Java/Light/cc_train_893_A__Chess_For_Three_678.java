import java.util.Scanner;
public class chess
{
    public static void main(String args[])
    {
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int a[]= new int[n];
        int x= 1, y=2, z=3, i, t, count=0;
        for(i=0; i<n; i++)
        {
            a[i]= s.nextInt();
            if(a[i]==x)
            {
                t=y;
                y=z;
                z=t;
            }
            else if(a[i]==y)
            {
                t=x;
                x=z;
                z=t;
            }
            else if(a[i]==z)
            {
                System.out.println("NO");
                break;
            }
            count++;
        }
        if(count==n)
        System.out.println("YES");
    }
}