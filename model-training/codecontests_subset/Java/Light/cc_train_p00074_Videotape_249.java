import java.util.*;
import java.io.*;
import static java.lang.Math.*;

class Time {

    final int h;
    final int m;
    final int s;

    Time( int h, int m, int s ) {
	this.h = h;
	this.m = m;
	this.s = s;
    }

    Time( int s ) {
	this.h = s / 3600;
	s %= 3600;
	this.m = s / 60;
	s %= 60;
	this.s = s;
    }

    public int toSec() {
	return 3600 * h + 60 * m + s;
    }

    public String toString() {
	return String.format( "%02d:%02d:%02d", h, m, s );
    }
}

class Main {

    public static void main( final String[] args ) {

	final Scanner stdin = new Scanner( System.in );

	while ( true ) {

	    final int h = stdin.nextInt();
	    final int m = stdin.nextInt();
	    final int s = stdin.nextInt();

	    if ( h == -1 && m == -1 && s == -1 ) {
		break;
	    }
	    
	    Time t = new Time( h, m, s );
	    int rest = 7200 - t.toSec();
	    int rest3 = rest * 3;
	    System.out.println( new Time( rest ) );
	    System.out.println( new Time( rest3 ) );	    	    
	}	
    }
}