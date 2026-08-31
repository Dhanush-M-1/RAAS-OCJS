import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) {

	final Scanner stdin = new Scanner(System.in);

	int rect = 0;
	int rhombus = 0;
	
	while ( stdin.hasNextLine() ) {
	    final String[] input = stdin.nextLine().split(",");
	    int w = Integer.parseInt(input[0]);
	    int h = Integer.parseInt(input[1]);
	    int d = Integer.parseInt(input[2]);


	    if ( w * w + h * h == d * d ) {
		rect++;
	    } else if ( w == h ) {
		rhombus++;
	    }
	}

	System.out.println(rect);
	System.out.println(rhombus);
	
    }
    
}