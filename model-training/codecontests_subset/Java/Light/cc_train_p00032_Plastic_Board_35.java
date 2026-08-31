import java.util.*;

public class Main{
	private static final Scanner scan = new Scanner(System.in)
							.useDelimiter("[,\\s+]");

	public static void main(String[] args){
	int r = 0;
	int d = 0;
		while(scan.hasNext()){

			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			if((double)c == Math.hypot((double) a, (double) b)){
				r++;
			}
			if(a == b){
				d++;
			}
		}
		System.out.printf("%d\n", r);
		System.out.printf("%d\n", d);
	}
}