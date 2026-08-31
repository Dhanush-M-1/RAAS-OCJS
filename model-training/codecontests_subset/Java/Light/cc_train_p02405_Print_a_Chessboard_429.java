import java.util.*;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {
	    scan = new Scanner(System.in);
	    while(true) {
		    int h=scan.nextInt();
		    int w=scan.nextInt();

		    if(h == 0 && w == 0) return ;

		    for(int j = 0 ; j < h ; j ++) {
		    	for(int  i = 0; i < w; i++) {
		    		System.out.print((i + j) % 2 == 0  ? "#" : ".");
		    	}
		    	System.out.println();
		    }
		    System.out.println();
	    }
	}
}

