
import java.util.Scanner;
 
public class _B_ {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
 
		for (int z = in.nextInt(); z > 0; z--) {
			long n = in.nextLong();
			int nb3=0,nb2=0;
			while(n%3==0) {n/=3;nb3++;}
			while(n%2==0) {n/=2;nb2++;}
			if (nb2>nb3||n>1)System.out.println(-1);else System.out.println(nb2+(nb3-nb2)*2);
		}
	}
}