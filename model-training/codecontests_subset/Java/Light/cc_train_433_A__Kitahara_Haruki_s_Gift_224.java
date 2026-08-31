import java.util.Scanner;

public class KitaharaHarukisGift {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int numberOf100 = 0;
		int numberOf200 = 0;
		
		for(int i = 0; i < n; i++) {
			int input = scanner.nextInt();
			
			if(input == 100)
				numberOf100++;
			else
				numberOf200++;
		}
		
		if(numberOf100 % 2 == 0 && (numberOf200 % 2 == 0 || (numberOf200 % 2 == 1 && numberOf100 >= 2)))
			System.out.println("YES");
		else 
			System.out.println("NO");
		
		scanner.close();
	}
}
