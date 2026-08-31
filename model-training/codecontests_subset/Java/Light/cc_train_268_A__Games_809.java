import java.util.*;
public class solution
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int x=in.nextInt();
        int y[]=new int[x*2];
        int count=0;
        for(int i=0;i<x*2;i++)
        {
            y[i]=in.nextInt();
        }
        for(int i=0;i<x*2;i=i+2)
        {
            for(int j=0;j<x*2;j++)
            {
                if(y[i]==y[j] && j%2==1) count++;
            }
        }
        System.out.println(count);
    }
}
