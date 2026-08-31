import java.util.*;

public class cf195a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		for(int i=0; i<1000010; i++)
			if((i+c)*b >= a*c) {
				System.out.println(i);
				return;
			}
	}
}
