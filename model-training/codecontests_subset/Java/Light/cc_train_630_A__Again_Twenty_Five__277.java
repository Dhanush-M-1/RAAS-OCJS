import java.util.*;
import java.math.*;
public class AgainTwoFive {

    public static void main(String[] args) {
    	Scanner kbd = new Scanner(System.in);
        double n = kbd.nextDouble();
    	double x = 0;
    	if ( n >= 2 && n <= (2*Math.pow(10,18))){
    		x = Math.pow(5,n);
        String y = Double.toString(x);
		int index = y.indexOf('.');
    	System.out.println(25);
    	}
	}
}
