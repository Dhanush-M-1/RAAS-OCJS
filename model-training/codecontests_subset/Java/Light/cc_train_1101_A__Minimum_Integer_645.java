/* IMPORTANT: Multiple classes and nested static classes are supported */

//import for Scanner and other utility classes
import java.util.*;

public class vir {
    public static void main(String args[] ) throws Exception {
       
        //Scanner
        Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	while(t-- > 0){				
		long l = sc.nextLong();
		long r = sc.nextLong();
		long d = sc.nextLong();
		long x = d * 1;
		if(x>=l && x<=r){
			x = ((r/d)+1)*d;
		}
		System.out.println(x);
	}
    }
}
