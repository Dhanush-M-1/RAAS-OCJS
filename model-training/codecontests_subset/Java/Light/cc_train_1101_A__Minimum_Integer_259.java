import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		for (int i = 0; i < n; i++) {
			long l = sc.nextLong();
			long r = sc.nextLong();
			long d = sc.nextLong();
			
			long x = d;
			long z = 1;
			
			if(d < l) {
				System.out.println(d);
				continue;
			}
		
			
			System.out.println((r/d+1)*d);
		}
		
		sc.close();
	}

}
