import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		while(true) {
			int L = stdIn.nextInt();
			if(L == 0) {
				break;
			}
			boolean alr = false;
			int m = 0;
			for(int i = 0; i < 12; i++) {
				L -= stdIn.nextInt();
				L += stdIn.nextInt();
				if(L <= 0) {
					if(!alr) {
						alr = true;
						m = i+1;
					}
				}
				
				
				
			}
			
			if(!alr) {
				System.out.println("NA");
			}
			else {
				System.out.println(m);
			}
		}
	}
	

}