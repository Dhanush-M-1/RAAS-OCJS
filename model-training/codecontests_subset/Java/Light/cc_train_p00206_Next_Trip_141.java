import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int l=0, m=0, n=0;
		
		int saving = 0, totalMonth = 0;
		
		while(true) {
			
			l = sc.nextInt();
			if(l == 0) {
				return;
			}
			
			saving = 0;
			totalMonth = 0;
			 
			for(int i = 1; i<=12; i++) {
				m = sc.nextInt();
				n = sc.nextInt();
				saving += m-n;
				
				if(totalMonth == 0 && saving >= l) {
					totalMonth = i;
				}
			}
			
			if(totalMonth > 0) {
				System.out.println(totalMonth);
			} else {
				System.out.println("NA");
			}
				
		}

	}

}