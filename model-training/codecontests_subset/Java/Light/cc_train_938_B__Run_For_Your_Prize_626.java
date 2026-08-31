import java.util.*;
import java.awt.*;
public class first
{
    public static void main(String args[])
    {
        Scanner br=new Scanner(System.in);
        int n=br.nextInt();
        //int[] arr=new int[n];
        int min=1000000;
        
        int max=0;
        for(int i=0;i<n;i++)
        {
         int num=br.nextInt();
         min=Math.min(num-1,1000000-num);
         max=Math.max(max,min);
        }System.out.println(max);
    }
}