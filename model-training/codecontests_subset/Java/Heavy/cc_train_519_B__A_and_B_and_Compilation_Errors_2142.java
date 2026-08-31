import java.util.*;

public class ComErr
{
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n, x;
        
        n = scan.nextInt();
        
        //int[] a = new int[n];
        int a = 0, b = 0, c = 0;
        for(int i=0;i<n;i++){
            x = scan.nextInt();
            a+=x;
        }
        for(int i=0;i<n-1;i++){
            x = scan.nextInt();
            b+=x;
        }
        for(int i=0;i<n-2;i++){
            x = scan.nextInt();
            c+=x;
        }
        
        System.out.println(a-b);
        System.out.println(b-c);
        
        
        
    }
}