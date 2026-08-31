import java.io.IOException;
import java.util.*;

/**
 */
class Main {
	final static int N = 10;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int choho = 0;
		int hishi = 0;
		while (in.hasNext()) {
			String[] strArr = in.nextLine().split(",");
			int[] intArr = new int[strArr.length];
			for(int i=0;i<strArr.length;i++) {
				intArr[i] = Integer.parseInt(strArr[i]);
			}
			if(intArr[0] * intArr[0] + intArr[1] * intArr[1] == intArr[2] * intArr[2]) {
				choho++;
			} else if(intArr[0] == intArr[1]) {
				hishi++;
			}
		}
		System.out.println(choho);
		System.out.println(hishi);
	}
}