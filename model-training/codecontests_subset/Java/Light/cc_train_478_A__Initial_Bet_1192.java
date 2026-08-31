
import java.util.*;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0;
		for(int i=0;i<5;i++){
			n += sc.nextInt();
		}
		if(n%5!=0||n==0) System.out.println(-1);
		else System.out.println(n/5);
		
	}
}
