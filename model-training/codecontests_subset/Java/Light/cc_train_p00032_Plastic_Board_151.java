import java.util.Scanner;

public class Main {

	Scanner sc;

	private Main(){
		sc = new Scanner( System.in );
	}

	private void run(){
		int rect = 0;
		int dia = 0;

		while( sc.hasNext() ){
			String str = sc.next();
			String[] sideStr = str.split( "," );
			int[] side = new int[ 3 ];

			for( int i = 0; i < sideStr.length; i++ ){
				side[ i ] = Integer.parseInt( sideStr[ i ]);
			}

			if( side[ 0 ] * side[ 0 ] + side[ 1 ] * side[ 1 ] == side[ 2 ] * side[ 2 ] ){
				rect++;
			}else if( side[ 0 ] == side[ 1 ] ){
				dia++;
			}
		}
		System.out.println( rect );
		System.out.println( dia );
	}

	public static void main( String[] args ){
		new Main().run();
	}
}