import java.util.Scanner;

public class Stoned {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int d = scan.nextInt();
		for(int j = 0; j<d; j++){
			int x = scan.nextInt();	
			int y = scan.nextInt();
			int z = scan.nextInt();
			int count = 0;
		while(z >= 2 && y >= 1){
			z = z-2;
			y = y-1;
			count = count + 3;
		}
		while(y >= 2 && x >=1){
			y = y-2;
			x = x-1;
			count = count + 3;
		}
		System.out.println(count);
		}
	}

}
