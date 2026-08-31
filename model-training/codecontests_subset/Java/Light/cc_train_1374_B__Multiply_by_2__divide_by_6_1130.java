import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t-->0) {
			int n = input.nextInt();
			boolean icd2 = true;
			int icd2Count = 0;
			boolean icd3 = true;
			int icd3Count = 0;
			while(icd2||icd3) {
				if(n%2==0) {
					n/=2;
					icd2Count++;
				}
				else {
					icd2 = false;
				}
				if(n%3==0) {
					n/=3;
					icd3Count++;
				}
				else {
					icd3 = false;
				}
			}
			if(icd2Count>icd3Count||n!=1) {
				System.out.println(-1);
			}
			else if(icd2Count==icd3Count) {
				System.out.println(icd2Count);
			}
			else {
				int ans;
				ans = 2*icd3Count-icd2Count;
				System.out.println(ans);
			}
		}
		input.close();
	}

}
