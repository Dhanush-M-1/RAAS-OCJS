import java.util.Scanner;

public class A915 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner (System.in) ; 
        int n = in.nextInt() ; 
        int k = in.nextInt(); 
        int [] a = new int [n] ;
        int [] hours = new int [n] ;
        int h = 10001 ; 
        for ( int i=0 ; i<n ; i++ )
        {
            a[i] = in.nextInt() ;
            if ( k%a[i] == 0 && k/a[i] < h ) 
                h = k/a[i] ; 
        }
        System.out.println(h);
    }
    
}