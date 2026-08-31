import java.util.Scanner;

public class BE38 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int aTime = 0;
		int bTime = 0;
		
		for(int i = 0; i < n; ++i) {
			int num = in.nextInt();
			
			if(num-1 <= 1000000 - num) aTime = num-1;
			else bTime = Math.max(bTime, 1000000 - num);
		}
		
		System.out.println(Math.max(aTime, bTime));
		
	}

}
