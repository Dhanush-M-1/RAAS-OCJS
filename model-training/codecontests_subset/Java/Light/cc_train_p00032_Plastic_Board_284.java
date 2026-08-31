import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in).useDelimiter(System.getProperty("line.separator"));

    	int	side_01,
    	    side_02,
    	    diagonal,
    	    Rectangle = 0,
    	    Lozenge   = 0;

    	String[] s;
    	while(sc.hasNext()){
    		s = sc.next().split(",");
    		side_01  = Integer.parseInt(s[0]);
    		side_02  = Integer.parseInt(s[1]);
    		diagonal = Integer.parseInt(s[2]);

    		if(Math.pow(side_01, 2) + Math.pow(side_02, 2) == Math.pow(diagonal, 2)){
    			Rectangle++;
    		} else if (side_01 == side_02){
    			Lozenge++;
    		}
    	}
		System.out.println(Rectangle);
		System.out.println(Lozenge);
	}
}