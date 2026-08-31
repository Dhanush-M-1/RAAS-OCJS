import java.util.*;
import java.io.*;

import static java.lang.Math.*;
import static java.lang.System.out;

@SuppressWarnings("unused")
public class Main {
	Scanner scan = new Scanner(System.in);
	PrintStream out = new PrintStream(System.out);
    char[][]  arr = new char[4][4];
	
	public static void main (String[] args) throws FileNotFoundException {new Main().run();}
	
	
	public void run ()  {
	    for (int i = 0; i < 4; i++) {
	    	String str = scan.next();
	    	for (int j = 0; j < 4; j++) {
	    		arr[i][j] = str.charAt(j);
	    	}
	    }
	    
	    
	    for (int i = 0; i < 4; i++) {
	    	does(arr[i][0], arr[i][1], arr[i][2]);
	    	does(arr[i][1], arr[i][2], arr[i][3]);
	    	does(arr[0][i], arr[1][i], arr[2][i]);
	    	does(arr[1][i], arr[2][i], arr[3][i]);
	    }
	    
	    does(arr[0][0], arr[1][1], arr[2][2]);
	    does(arr[1][1], arr[2][2], arr[3][3]);
	    does(arr[0][3], arr[1][2], arr[2][1]);
	    does(arr[1][2], arr[2][1], arr[3][0]);
	    
	    does(arr[0][1], arr[1][2], arr[2][3]);
	    does(arr[1][0], arr[2][1], arr[3][2]);
	    does(arr[2][0], arr[1][1], arr[0][2]);
	    does(arr[3][1], arr[2][2], arr[1][3]);
	    out.println("NO");
	    
	}
	
	public void does (char ch1, char ch2, char ch3) {
		if (ch1 == 'o' || ch2 == 'o' || ch3 == 'o') return;
		if (ch1 == '.' && ch2 == '.' && ch3 == '.') return;
		if ((ch1 == '.' && ch2 == '.') | (ch2 == '.' && ch3 == '.') | (ch1 == '.' && ch3 == '.')) return;
		out.println("YES");
		System.exit(0);
	}
}


