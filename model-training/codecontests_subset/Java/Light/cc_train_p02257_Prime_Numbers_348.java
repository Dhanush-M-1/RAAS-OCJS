import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner number = new Scanner(System.in);
		int a  = number.nextInt();
		double[] b = new double[a];
		int c = 0;
		double d;

		for(int i = 0;i < a;i++) {
			b[i] = number.nextInt();
			c++;
			d = b[i] / 3;
			for(double j = 2;j < Math.sqrt(b[i]) + 1;j++) {
				if(b[i] % 2 == 0 && b[i] > 2) {
					
					c--;
					break;
				}
				if(b[i] % j == 0 && b[i] != 2) {
				
					c--;
					break;
				}
				
			}
			
		}
		System.out.println(c);
	}
}

