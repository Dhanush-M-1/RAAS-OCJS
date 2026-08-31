
import java.util.Scanner;

/**
 *
 * @author Do
 */
public class ProblemB {
    public static void main(String[] args) {
	int countF=0,countA=0,countI=0;
	Scanner in=new Scanner(System.in);
	int n=in.nextInt(),i;
	String s=in.next();
	for (i=0;i<n;++i) {
	    if (s.charAt(i)=='A') ++countA;else if (s.charAt(i)=='F') ++countF;else ++countI;
	}
	if (countI>0) {
	    if (countI==1) System.out.println(1);
	    else System.out.println(0);
	}
	else System.out.println(countA);
    }
}
