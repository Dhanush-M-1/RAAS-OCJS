import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int [] array = new int[3];
		for (int i = 0;i< array.length;i++) {
			array[i] = sc.nextInt();}
		Arrays.sort(array);
		
		if (array[0] + array[1] == array[2]) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
