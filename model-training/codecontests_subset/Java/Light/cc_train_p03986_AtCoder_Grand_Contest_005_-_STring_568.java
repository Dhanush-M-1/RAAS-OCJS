import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String x = sc.next();
		
		sc.close();
		
		int s = 0;
		int erase = 0;
		
		for(int i = 0; i < x.length(); i++) {
			if(x.charAt(i) == 'S') {
				s++;
			} else {
				if(s != 0) {
					s--;
					erase += 2;
				}
			}
		}
		
		System.out.println(x.length() - erase);
		
		return;
	}
	
}