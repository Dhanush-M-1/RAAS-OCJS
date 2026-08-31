import java.util.Scanner;

public class Prob290D {
	public static void main(String[] Args) {
		Scanner scan = new Scanner(System.in);
		char[] arr = scan.nextLine().toLowerCase().toCharArray();
		int x = scan.nextInt();
		for (int i = 0; i < arr.length; i++)
			if (arr[i] - 'a' < x)
				arr[i] = (char) (arr[i] + 'A' - 'a');
		System.out.println(new String(arr));
	}
}
