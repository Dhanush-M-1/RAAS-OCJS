import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Games();
	}
	public static void Games() {
		Scanner scan = new Scanner(System.in);
		int games = scan.nextInt();
		scan.nextLine();
		int home[] = new int[games];
		int away[] = new int[games];
		int count = 0;
		for(int j = 0; j< games; j++) {
				home[j] = scan.nextInt();
				away[j] = scan.nextInt();
				scan.nextLine();
			}
		for(int j = 0; j< games; j++) {
			for(int i = 0; i< games; i++) {
				if(home[i] == away[j])
					count++;
			}
		}
		System.out.println(count);
	}
}