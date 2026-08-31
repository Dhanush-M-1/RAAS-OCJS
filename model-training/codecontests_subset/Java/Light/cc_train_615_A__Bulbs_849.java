import java.util.Scanner;

public class A337 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), m = s.nextInt();
		boolean[] on = new boolean[m];
		for(int i = 0; i < n; i++) {
			int size = s.nextInt();
			for(int j = 0; j < size; j++) {
				int temp = s.nextInt();
				on[temp-1] = true;
			}
		}
		
		boolean flag = true;
		for(int i = 0; i < on.length; i++) {
			if(!on[i]) {
				flag = false;
				break;
			}
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
}
