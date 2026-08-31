import java.util.Scanner;

public class MisterBAndBookReading {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt(), v0 = scan.nextInt(),
				v1 = scan.nextInt(), a = scan.nextInt(), l = scan.nextInt(), res = 0, i = 1;
		while(i<=c) {
			int pos = v0+(res)*a;
			if(res>0) i+=v1>(pos) ? pos-l : v1-l;
			else i+=v1>(pos) ? (pos) : v1;
			res++;
		}
		System.out.println(res);
	}
}