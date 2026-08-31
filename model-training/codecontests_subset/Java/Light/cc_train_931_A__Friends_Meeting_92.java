import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		while(in.hasNext()) {
			int f = in.nextInt();
			int s = in.nextInt();
			int tmp = f - s;
			if(tmp < 0) {
				tmp = -tmp;
			}
			if(tmp % 2 == 0) {
				int a = tmp/2;
				int res = (1+a)*a;
				System.out.println(res);
			}else {
				int b = tmp/2;
				int res = ((1+b)*b) + (b+1);
				System.out.println(res);
			}
		}

	}

}