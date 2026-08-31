import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] arr = new int[53];
		scan.nextLine();
		
		String suit = "";
		int rank = 0;
		for (int i=1; i<=n; i++) {
			suit = scan.next();
			rank = scan.nextInt();
			if(suit.equals("S")) arr[rank] = rank;
			if(suit.equals("H")) arr[rank+13] = rank;
			if(suit.equals("C")) arr[rank+26] = rank;
			if(suit.equals("D")) arr[rank+39] = rank;
		}
		
		for (int i=1; i<=52; i++) {
			if(arr[i] == 0 && i <= 13)
				System.out.println("S " + i);
			if(arr[i] == 0 && i > 13 && i <=26)
				System.out.println("H " + (i-13));
			if(arr[i] == 0 && i > 26 && i <=39)
				System.out.println("C " + (i-26));
			if(arr[i] == 0 && i > 39 && i <=52)
				System.out.println("D " + (i-39));
		}
	}
}

