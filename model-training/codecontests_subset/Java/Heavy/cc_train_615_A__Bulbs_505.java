import java.util.Arrays;
import java.util.Scanner;

public class Bulbs {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
	boolean [] arr = new boolean [m] ;
	Arrays.fill(arr, false);
		
	for(int i=0; i<n;i++) {
		int button = scan.nextInt();
		
		for(int x=0;x<button;x++) {
			int bulb= scan.nextInt()-1;
			arr[bulb]=true;	
		}
		
		
	}
		boolean check= true;
	for(int y=0;y<arr.length;y++) {
		if(arr[y]==true) {
			
		}else {
			check = false;
		}
	}
		if(check==false) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		
	}

}
