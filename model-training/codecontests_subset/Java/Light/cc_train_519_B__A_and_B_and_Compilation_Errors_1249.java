import java.io.FileOutputStream;
import java.util.* ;

 public class  bisection{

  public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        long n = sc.nextInt() ;
        long a = 0 ;
        long b = 0 ;
        long c = 0 ;
      for (int i = 0 ; i<n ; i++)
          a += sc.nextLong() ;

      for (int i = 0 ; i<n-1 ; i++)
          b += sc.nextLong() ;

      for (int i = 0 ; i<n-2 ; i++)
          c += sc.nextLong() ;

      System.out.println( a-b );
      System.out.println( b-c );
    }
}