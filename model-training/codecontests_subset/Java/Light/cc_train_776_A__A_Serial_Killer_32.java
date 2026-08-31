import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String[] array = new String[2];
		array = in.nextLine().split(" ");
		System.out.println(array[0] + " " + array[1]);
		int n = in.nextInt();
		in.nextLine();
		for(int i=0; i<n; i++) {
			String[] temp = in.nextLine().split(" ");
			if(array[0].equalsIgnoreCase(temp[0])) {
				array[0] = temp[1];
			}
			if(array[1].equalsIgnoreCase(temp[0])) {
				array[1] = temp[1];
			}
			System.out.println(array[0] + " " + array[1]);
		}
		in.close();
	}
	
}