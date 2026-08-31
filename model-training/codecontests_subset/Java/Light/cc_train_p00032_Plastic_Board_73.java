import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int rect = 0, rhom = 0;
		while(sc.hasNextLine()) {
			String[] parsed = sc.nextLine().split(",");
			int a = Integer.parseInt(parsed[0]), b = Integer.parseInt(parsed[1]), c = Integer.parseInt(parsed[2]);
			if((a*a + b*b) == (c*c)) rect++;
			if((a == b)) rhom++;
		}
		System.out.println(rect);
		System.out.println(rhom);
	}

}