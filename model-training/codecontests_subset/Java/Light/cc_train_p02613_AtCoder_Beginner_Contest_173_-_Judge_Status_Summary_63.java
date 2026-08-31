import java.util.*;
import java.util.function.*;
import java.math.*;
public class Main {
    public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int N = Integer.valueOf(s.next());
		int[] ret = new int[4];
		for(int i = 0; i < N; i++) {
			String now = s.next();
			switch(now) {
			case "AC":
				ret[0]++;
				break;
			case "WA":
				ret[1]++;
				break;
			case "TLE":
				ret[2]++;
				break;
			case "RE":
				ret[3]++;
				break;
			}
		}
		
		System.out.println("AC x " + ret[0]);
		System.out.println("WA x " + ret[1]);
		System.out.println("TLE x "+ ret[2]);
		System.out.println("RE x " + ret[3]);
	}
}