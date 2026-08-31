import java.util.Arrays;
import java.util.Scanner;

public class helpfulmaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String[] arr = str.split("\\+");
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			if(i == arr.length-1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i]+"+");
		}
	}

}
