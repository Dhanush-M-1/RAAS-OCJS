import java.util.Scanner;
public class Mult2Mult6{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    
    while(t-- > 0) {
    	int n = sc.nextInt();
    	int c1 = 0, c2 = 0 ;
    	while( n%2 == 0) {
    		n /= 2 ; 
    		c1++;
    	}
    	while( n%3 == 0) {
    		n /= 3 ;
    		c2++ ;
    	}
    	if( n!= 1 || c1 > c2)
    		System.out.println("-1");
    	else 
    		System.out.println( 2 * c2 - c1 );
    }
  }
}