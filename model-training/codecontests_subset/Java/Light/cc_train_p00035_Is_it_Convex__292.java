import java.util.*;
import java.io.*;

class Main {

    static final int X = 0;
    static final int Y = 1;
    
    public static void main(String[] args) {

	final Scanner stdin = new Scanner(System.in);

	while( stdin.hasNextLine() ) {
	    String[] input = stdin.nextLine().split(",");

	    double[][] pos = new double[4][2];
	    for ( int i = 0; i < 4; i++ ) {
		for ( int j = 0; j < 2; j++ ) {
		    pos[i][j] = Double.parseDouble( input[i * 2 + j] );
		}
	    }

	    if ( solve( pos ) ) {
		System.out.println("YES");
	    } else {
		System.out.println("NO");
	    }
	}	
    }

    static boolean solve( double[][] pos ) {
	final boolean[] right = new boolean[4];
	
	for ( int i = 0; i < 4; i++ ) {
	    final int ni = (i + 1) % 4;
	    final int nni = (i + 2) % 4;
	    
	    final double dx1 = pos[ni][X] - pos[i][X];
	    final double dy1 = pos[ni][Y] - pos[i][Y];
	    final double dx2 = pos[nni][X] - pos[i][X];
	    final double dy2 = pos[nni][Y] - pos[i][Y];
	    
	    right[i] = dx2 * dy1 - dx1 * dy2 > 0;
	}

	return allSame( right );
    }

    static boolean allSame( boolean[] array ) {
	final boolean val = array[0];
	for ( boolean b : array ) {
	    if ( b != val ) {
		return false;
	    }
	}
	return true;
    }
    
}