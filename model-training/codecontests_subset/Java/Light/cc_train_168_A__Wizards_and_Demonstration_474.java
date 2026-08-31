import java.util.Scanner;
public class code114_01 {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		double n = sc.nextDouble();
		int x = sc.nextInt();
		double y = sc.nextDouble();
		
		int needed = (int)Math.ceil((y*n)/100) - x;
		if(needed <= 0)
			System.out.println(0);
		else
			System.out.println(needed);
	}
}
