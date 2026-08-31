import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String[] arr= {"AC","WA","TLE","RE"};
		int n = in.nextInt();
		int x[] = new int[4];
		while (n--!=0) {
			String string = in.next();
			if (string.equals("AC")) {
				x[0]++;
			}else if(string.equals("WA")) {
				x[1]++;
			}else if (string.equals("TLE")) {
				x[2]++;
			}else {
				x[3]++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+" x "+x[i]);
		}
	}
}