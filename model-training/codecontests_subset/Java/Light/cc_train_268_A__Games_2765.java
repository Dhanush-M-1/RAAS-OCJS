import java.util.Scanner;
import java.util.Arrays;
//import java.lang.Math;
public class mitul
{
    public static void main(String[] args)
    {  
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int count=0;
        int[] arr = new int[2*a];
        for(int i=0;i<2*a;i++)
        {
            arr[i]=scan.nextInt();
        }
        for(int i=0;i<2*a-1;)
        {
            for(int j=1;j<2*a;)
            {
                if(arr[i]==arr[j])
                {
                    count++;
                }
                j=j+2;
            }
            i=i+2;
        }
        System.out.println(count);
    }
}
        
        