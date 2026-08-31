import java.util.Scanner;
public class A615 
{
    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int arr[]=new int[m];
        for(int i=0;i<n;i++)
        {
            int f=input.nextInt();
            for(int j=0;j<f;j++)
            {
                int y=input.nextInt();
                arr[y-1]=1;
            }
        }
        int k=0;
        for(int i=0;i<m;i++)
        {
            if(arr[i]==1)
            {
                k++;
            }
        }
        if(k==m)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
