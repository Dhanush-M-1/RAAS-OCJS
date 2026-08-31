import java.util.Scanner;

public class CF1236A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int c = s.nextInt();
			int ax =a;
			int bx = b;
			int cx= c;
			int stones = 0;
			int stones2 = 0;
			
				int num = c/2;
				int taken = num;
				if(num>b) {
					taken=b;
				}
				stones+=(taken*2)+taken;
				b=b-taken;
				int num1 = b/2;
				taken = num1;
				if(num1>a) {
					taken=a;
				}
				stones+=(taken*2)+taken;
			
				int numx = b/2;
				int takenx = numx;
				if(numx>ax) {
					takenx=ax;
				}
				stones2+=(takenx*2)+takenx;
				bx=bx-(takenx*2);
				int num1x = cx/2;
				takenx = num1x;
				if(num1x>bx) {
					takenx=bx;
				}
				stones2+=(takenx*2)+takenx;
			
			System.out.println(Math.max(stones, stones2));
		}

	}

}
