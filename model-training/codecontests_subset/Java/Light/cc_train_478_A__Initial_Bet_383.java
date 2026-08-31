import java.util.*;

public class A {
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int tot = 0;
        for (int i = 0; i < 5; i++ ) {
	    tot += sc.nextInt();
	}
	int ig = tot/5;
        if (ig > 0 && ig*5 == tot){
	    System.out.println(ig);
	} else System.out.println("-1");
	
    }
    
    
}
