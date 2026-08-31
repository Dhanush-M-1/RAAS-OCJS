import java.util.Scanner;

public class A_educ_33 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		
		int a = 1, b = 2, s = 3;
		boolean valid = true;
		for(int i = 0; i < n; i++) {
			if(arr[i] == s) {
				valid = false;
				break;
			} else if(arr[i] == a){
				int temp = s;
				s = b;
				b = temp;
			} else {
				int temp = s;
				s = a;
				a = temp;
			}
		}
		if(valid) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
