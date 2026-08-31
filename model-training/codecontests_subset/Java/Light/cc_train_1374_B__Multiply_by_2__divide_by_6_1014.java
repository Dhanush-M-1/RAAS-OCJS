import java.util.*;
public class multiply
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++)
        {
            int n=sc.nextInt();
            int c=0;
            while(n!=1)
            {
                if(n%3!=0)
                {
                    c=-1;
                    break;
                }
                if(n%6!=0)
                {
                    c=c+1;
                    n=2*n;
                }
                if(n%6==0)
                {
                    c=c+1;
                    n=n/6;
                }
            }
            System.out.println(c);
        }
    }
}