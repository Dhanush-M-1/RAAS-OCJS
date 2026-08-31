import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int xx = sc.nextInt();
		int yy = sc.nextInt();
		
		if (1 <= xx && xx <=9 && 1<= yy && yy <= 9){
			System.out.print(xx * yy);
		}else{
			System.out.print("-1");
		}
	}
}