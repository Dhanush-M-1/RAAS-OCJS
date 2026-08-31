import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {		
	
		Scanner scan = new Scanner(System.in);

		int i , j , q = scan.nextInt();
		for (i = 0;i < q;i ++) {
			long l , r , d;
			l = scan.nextLong();
			r = scan.nextLong();
			d = scan.nextLong();
			if (d < l) {
				System.out.println(d);
			} else {				
				System.out.println((r / d + 1) * d);
			}			
		}
		
	
	}
    
}














