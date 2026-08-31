import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int distance = Math.abs(a - b);
		int aTired = 0;
		int bTired = 0;
		
		if(distance % 2 == 0) {
			aTired = calculateTiredness(distance / 2);
			bTired = calculateTiredness(distance / 2);
		}
		else {
			aTired = calculateTiredness((distance / 2) + 1);
			bTired = calculateTiredness(distance / 2);
		}
		System.out.println(aTired+bTired);
    }
	
	public static int calculateTiredness(int stepsTaken) {
		int sum = 0;
		for (int i = 1; i <= stepsTaken; i++) {
			sum += i;
		}
		return sum;
	}

}
