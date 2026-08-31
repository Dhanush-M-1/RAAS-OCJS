import java.util.*;


public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		    int H = sc.nextInt();
		    int W = sc.nextInt();
		    if (H == 0 && W == 0) break;
		    
		    for (int i = 1; i<=H; i++) {
		        for (int t= 1; t<=W; t++) {
		            if ((i + t) % 2 == 0 ) {
		                System.out.print("#");
		            } else {
		                System.out.print(".");
		            }
		        }
		    System.out.println("");
		    }
		    System.out.println("");
		}

		
    }
}
