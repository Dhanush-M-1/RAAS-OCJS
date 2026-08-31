import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int[] arr = new int[4];
		Arrays.setAll(arr, i -> 0);
		for(int i=0;i<N;i++) {
			switch(sc.next()) {
			case "AC":
				arr[0]++;
				break;
			case "WA":
				arr[1]++;
				break;
			case "TLE":
				arr[2]++;
				break;
			case "RE":
				arr[3]++;
				break;
			}
		}
		System.out.println("AC x "+arr[0]);
		System.out.println("WA x "+arr[1]);
		System.out.println("TLE x "+arr[2]);
		System.out.println("RE x "+arr[3]);


	}
}