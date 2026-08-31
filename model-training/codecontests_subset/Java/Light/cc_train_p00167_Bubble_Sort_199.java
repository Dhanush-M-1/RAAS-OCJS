import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) {

	final Scanner stdin = new Scanner(System.in);

	while ( true ) {
	    final int n = stdin.nextInt();

	    if ( n == 0 ) {
		break;
	    }
	    
	    int[] array = new int[n];
	    for ( int i = 0; i < n; i++ ) {
		array[i] = stdin.nextInt();
	    }

	    int count = 0;
	    for ( int i = 0; i < n; i++ ) {
		for ( int j = 0; j < n - i - 1; j++ ) {
		    if ( array[j] > array[j + 1] ) {
			count++;
			final int copyOfAJ = array[j];
			array[j] = array[j + 1];
			array[j + 1] = copyOfAJ;
		    }
		}
	    }
	    System.out.println( count );
	}
	
    }
    
}