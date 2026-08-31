import java.util.Scanner;

public class t_2 {
	
	public static int find(int n) {
		
		int ans = 0;
		while(n!=1) {
			if (n%6==0) {
				n /=6;
				ans++;
			}
			else if((n*2)%6==0) {
				n /=3;
				ans+=2;
			}
			else {
				return -1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t>0) {
			int n = scn.nextInt();
			int ans = find(n);
			System.out.println(ans);
			t--;
		}

	}

}
