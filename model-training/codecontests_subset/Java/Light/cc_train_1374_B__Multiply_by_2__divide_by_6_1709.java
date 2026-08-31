import java.io.*;
import java.util.*;
public class MultiplyTwoDivideSix
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int count=0;
            if(n%3!=0 && n!=1)
                System.out.println(-1);
            else if(n==1)
                System.out.println(0);
            else
            {
                while(n!=1)
                {
                    if(n%6==0)
                        n=n/6;
                    else if(n%3!=0 && n!=1)
                    {
                        count=-1;
                        break;
                    }
                    else
                        n=n*2;
                    count++;
                }
                if(count==-1)
                    System.out.println(-1);
                else
                    System.out.println(count);
            }
        }
    }
}