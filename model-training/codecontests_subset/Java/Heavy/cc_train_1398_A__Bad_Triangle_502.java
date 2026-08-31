import java.util.Scanner;
public class Main{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int itr = s.nextInt();
        int n,j;
        int arr[];
        for(int i=0;i<itr;i++)
        {
             n=s.nextInt();
             arr=new int[n];
             for(j=0;j<n;j++)
             {
                 arr[j]=s.nextInt();

             }
             for(j=0;j<n-2;j++)
             {
                 if( (arr[j]+arr[j+1]) > arr[n-1] )
                 {
                     continue;
                 }
                 else
                 {
                     System.out.println( (j+1)+" "+(j+2)+" "+ (n) );
                     break;
                 }
                 
             }
             if(j==n-2)
             {
                 System.out.println(-1);
             }
             
        }
    }
}