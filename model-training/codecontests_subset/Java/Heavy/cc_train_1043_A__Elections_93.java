import java.util.Scanner;

public class Elections {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] n = new int[input.nextInt()];
		int highestA = 0;

		for(int i = 0; i < n.length; i++) {
			n[i] = input.nextInt();

			if(i == 0) {
				highestA = n[i];
			} else {
				if(n[i] > highestA) {
					highestA = n[i];
				}
			}
		}

		int elodreip = 0;

		for(int temp : n) {
			elodreip += temp;
		}

		int awruk = 0;
		int k = highestA;

		while(true) {
			awruk = 0;

			for(int temp : n) {
				awruk += (k - temp);
			}

			if(awruk > elodreip) {
				break;
			} else {
				k++;
			}
		}

		System.out.println(k);

	}

}