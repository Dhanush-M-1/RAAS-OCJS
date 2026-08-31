import java.util.Scanner;
public class garden
{
    public static void main(String args[])
    {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        int i, j=0, rem, t, min;
        int a[]= new int[n];
        int b[]= new int[n];
        for(i=0; i<n; i++)
        {
            a[i]= s.nextInt();
            t=k%a[i];
            if(t==0 && a[i]<=k)
            {
                b[j]= (k/a[i]);
                j++;
            }
        }
        min=b[0];
        for(i=0; i<j; i++)
        {
            if(b[i]<min)
            {
                min= b[i];
            }
        }
        System.out.println(min);
    }
}
        
                
                