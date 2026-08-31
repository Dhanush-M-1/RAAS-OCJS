import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner kb = new Scanner( System.in);	
		
		while( true ) {
			int H = kb.nextInt();
			int W = kb.nextInt();
			
			if( 0==W && 0==H ) { break; }
			
			boolean cPattern=true;
			for( int i=0; i<H; i++ ) {
				cPattern= (0==(i%2))? true: false;
				for( int j=0; j<W; j++ ) {
					if( cPattern ) {
						System.out.print( "#" );
						cPattern=!cPattern;
					} else {
						System.out.print( "." );
						cPattern=!cPattern;
					}
				}
				System.out.print( "\n" );
			}
			System.out.print( "\n" );
		}
	}
}