import java.util.*;

public class phonenumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String bafry = sc.next();
		int[] digits = new int[n];
		int bayus = 0;
		for (int i = 0; i < n; i++) {
			digits[i] = Integer.parseInt(bafry.substring(i,i+1));
			if (digits[i] == 8) {
				bayus++;
			}
		}
		Arrays.sort(digits);
		int bobib = Math.min(bayus, n/11);
		System.out.println(bobib);

	}

}
