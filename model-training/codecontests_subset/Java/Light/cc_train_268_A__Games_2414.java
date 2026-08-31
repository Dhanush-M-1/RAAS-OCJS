import java.util.*;

public class Main
{
    public static void main(String at[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        for(int i=0;i<n;i++){
        a[i]=in.nextInt();
        b[i]=in.nextInt();
        }
        
        
        int count=0;
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        if(i!=j && a[i]==b[j])
        count++;
        
        System.out.println(count);
    }
}