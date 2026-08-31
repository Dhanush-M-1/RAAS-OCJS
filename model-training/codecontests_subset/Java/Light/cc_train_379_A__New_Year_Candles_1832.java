
import java.util.Scanner;

public class NewYearCandles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int light = 0;
		int burn = a;
		int sum = a;
		while(true){
			
			light = burn/b;
			burn = light +burn % b;
			sum+=light;
			
			if(light == 0 || burn ==0){
				System.out.println(sum);
				break;
			}
		}
		
	}

}
