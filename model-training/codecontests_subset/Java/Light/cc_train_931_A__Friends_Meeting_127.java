import java.util.*;
public class Main 
{
    public static void main(String argz[])
    {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        int m=inp.nextInt();
        int tired=0;
        int j=0;
        if(m>n)
        {
            if((m-n)==1)
            tired=1;
            else if((m-n)%2==0)
            {
                j=(m-n)/2;
                for(int i=1;i<=j;i++)
                {
                    tired=tired+2*i;
                }
            }
            else
            {
                j=(m-n)/2;
                tired=j+1;
                for(int k=1;k<=j;k++)
                {
                    tired=tired+2*k;
                }
            }
        }
        else
        {
            if((n-m)==1)
            tired=1;
            else if((n-m)%2==0)
            {
                j=(n-m)/2;
                for(int a=1;a<=j;a++)
                {
                    tired=tired+2*a;
                }
            }
            else
            {
                j=(n-m)/2;
                tired=j+1;
                for(int b=1;b<=j;b++)
                {
                    tired=tired+2*b;
                }
            }
        }
        System.out.println(tired);
    }
}