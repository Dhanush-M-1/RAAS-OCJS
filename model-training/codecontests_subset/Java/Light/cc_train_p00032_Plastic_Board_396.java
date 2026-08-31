import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rectangle = 0;
		int lozenge = 0;
		while(sc.hasNext()) {
			String[] sarr = sc.next().split(",");
			int[] x = new int[3];
			for(int i=0;i<3;i++) {
				x[i] = Integer.valueOf(sarr[i]);
			}
			if (x[0] * x[0] + x[1] * x[1] == x[2] * x[2]) {
				rectangle++;
			}
			if (x[0] == x[1]) {
				lozenge++;
			}
		}
		System.out.println(rectangle);
		System.out.println(lozenge);
	}
	
}