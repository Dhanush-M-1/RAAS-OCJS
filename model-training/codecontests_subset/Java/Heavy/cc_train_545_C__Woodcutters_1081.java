import java.util.Scanner;


public class Woodcutters {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());
		int[] x = new int[n];
		int[] h = new int[n];
		
		for(int i = 0; i < n; i++) {
			String[] data = scanner.nextLine().split(" ");
			x[i] = Integer.valueOf(data[0]);
			h[i] = Integer.valueOf(data[1]);
			
		}
		
		if(x.length == 1) {
			System.out.println(1);
			return;
			
		}
		
		int count = 2;
		for(int i = 1; i < n - 1; i++) {
			int leftX = x[i - 1];
			int midX = x[i];
			int rightX = x[i + 1];
			int height = h[i];
			
			// Can fall left
			if(leftX < midX - height) {
				count++;
				
			}
			// Can fall right
			else if(rightX > midX + height) {
				count++;
				x[i] = midX + height;
				
			}
			
		}
		System.out.println(count);
		
	}

}
