
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		char[] q = s.toCharArray();
		int bestcounter = 1;
		String word = "";
		for(int i = 0; i < n-1; i++) {
			String string = String.valueOf(q[i]) + String.valueOf(q[i+1]);
			int counter = 1;
			for(int j = i + 1; j < n-1; j++) {
				String sub = String.valueOf(q[j]) + String.valueOf(q[j+1]);
				if(string.equals(sub)) {
					counter++;
				}
			}
			if(counter > bestcounter) {
				bestcounter = counter;
				word = string;
			}
		}
		if(bestcounter == 1) System.out.println(s.substring(0,2));
		else System.out.println(word);

	}

}
