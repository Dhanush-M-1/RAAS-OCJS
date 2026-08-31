import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int result ;
		if (A<10 && B<10){
			result = A*B;
		}else{
			result = -1;
		}
		System.out.println(result);
	}
}