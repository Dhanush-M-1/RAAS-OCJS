import java.util.Scanner;


public class KitaharaHarukisGift {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int sum100 = 0;
		int sum200 = 0;
		int in = 0;
		if(n < 2) {
			System.out.println("NO");
			return;
		}
			
		while(scanner.hasNextInt()) {
			
			in = scanner.nextInt();
			if(in == 100)
				sum100++;
			else
				sum200++;
		}
		int total = sum100 + 2*sum200;
		
		if(total%2 == 1)
			System.out.println("NO");
		else {
			total /=2;
			if(total %2 == 0) {
				System.out.println("YES");
			}else if(sum100 >0 && sum100%2==0) {
				System.out.println("YES");
			} else
			{
				System.out.println("NO");
			}
		}
			
	}

}
