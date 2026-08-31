import java.util.*;
public class time{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a1 = sc.nextInt();
		long a2 = sc.nextInt();
		long b1 = sc.nextInt();
		long b2 = sc.nextInt();
		long c1 = sc.nextInt();
		long c2 = sc.nextInt();
		long sqr = (b2 - a2) * (b2 - a2) + (b1 - a1)*(b1 - a1);
		long sqr1 =  (c2 - b2) * (c2 - b2) + (c1 - b1)*(c1 - b1);
		if(sqr == sqr1  && ((b2 - a2) * (c1 - b1) !=  (c2 - b2) * (b1 - a1) ) ){
				System.out.println("Yes");
			}
	
		
		else
			System.out.println("No");
		


	}
}