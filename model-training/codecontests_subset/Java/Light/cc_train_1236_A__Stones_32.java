import java.util.Scanner;
public class Code_Force_01 
{
    static int[] arr ;
    static int Cal(int a,int b,int c,int sum)
    {
        if(b>=1&&c>=2)
        {
             return Cal(a,b-1,c-2,sum+3);
        }
        if(a>=1&&b>=2)
        {
            return Cal(a-1,b-2,c,sum+3);
        }
        else
        {
        return sum;        
            }
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = Cal(sc.nextInt(),sc.nextInt(),sc.nextInt(),sum);
        }
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
    }
    
}
