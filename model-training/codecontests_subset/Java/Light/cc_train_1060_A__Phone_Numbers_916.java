import java.util.Scanner;

public class A1060 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), i;
		char[] s = in.next().toCharArray();
		int[] num = new int[10];
		long ans = 0;
		long pos = 0;
		
		for(i = 0; i < n; ++i)
			num[s[i] - '0']++;
		
		if(num[8] == 0 || n < 11) {
			System.out.println(0);
			System.exit(0);
		}
		
		pos = (n - num[8]) / 10;
		
		if(pos >= num[8]) {
			System.out.println(num[8]);
			System.exit(0);
		}
		
		ans += pos;
		
		ans += (n - 11 * pos) / 11;
		
		System.out.println(ans);
		
	}

}
