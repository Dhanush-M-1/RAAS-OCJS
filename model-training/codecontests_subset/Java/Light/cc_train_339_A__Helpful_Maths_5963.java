import java.util.Arrays;
import java.util.Scanner;


public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] line = in.nextLine().split("\\+");
		Arrays.sort(line);
		for(int i = 0; i < line.length; i++) {
			System.out.print(line[i]);
			if(i != line.length - 1) {
				System.out.print("+");
			}
		}
		System.out.println();
	}

}
