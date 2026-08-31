import java.util.Scanner;

public class Bucket{
    public static void main(String args[])
    {
        int n,i,k,min;
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        k=scan.nextInt();
        int a[] = new int[n];
        min = 106;
        for(i=0;i<n;i++)
        {
            a[i] = scan.nextInt();
            if((k%a[i] == 0) && ((k/a[i])<min))
            {
                min = k/a[i];
            }   
        }

        System.out.println(min);
        scan.close();
        
    }
}