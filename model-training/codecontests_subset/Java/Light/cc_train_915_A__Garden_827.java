import java.util.Scanner;

public class Garden {
	

	public static void main(String[] args) {
		int n , k ;
		Scanner sc = new Scanner ( System.in) ;
		n = sc.nextInt() ;
		k = sc.nextInt() ;
		int x = 0;
		int max = Integer.MIN_VALUE ;
		for( int i =0 ; i < n ; i++) {
			x = sc.nextInt() ;
			if ( k%x == 0 && x > max ) {
				max = x ;
			}
		}
		System.out.println(k/max);
	}
}
