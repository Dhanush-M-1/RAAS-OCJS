import java.util.Scanner;

public class codeForcePblm1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		boolean flag = false;
		int diff = Math.abs(a-b);
		if(diff%2==1) {
			flag = true;
		}
		
		diff = diff/2;
		int ans = (diff*(diff+1));
		if(flag) {
			ans = ans + diff+1;
		}

		System.out.println(ans);
	}

}