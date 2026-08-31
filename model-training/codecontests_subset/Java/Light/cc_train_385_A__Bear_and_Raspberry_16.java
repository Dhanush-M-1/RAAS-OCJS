import java.util.*;

public class Main{
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int c=scan.nextInt();
        int prev=0;
        int i;
        int max=0;
        for(i=0;i<n;i++)
        {
            int a=scan.nextInt();
            max=Math.max(prev-a-c,max);
            prev=a;
        }
        System.out.println(max);
    }
}