import java.util.*;
public class A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		
		long data_need = C*(A-B);
		long time_need = (data_need+B-1)/B;
		
		System.out.println(time_need);
	}
}
