import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

	 
		int n = sc.nextInt();
		int m = sc.nextInt();
	
		int count = n;
		int r = n % m;
		while(n > r){
			
			int res = n / m;
			int rem = n % m;
			count+= res;
			n /= m;
			n += rem;
			r = rem;
//			System.out.println(n);
			
		}
//		System.out.println(extra + " " + count + " ");
//		count += (extra / m);
		System.out.println(count);
		sc.close();
	}
}