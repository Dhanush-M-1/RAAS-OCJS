import java.util.Scanner;

public class MinimumInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		while (q-->0) {
			int l = s.nextInt();
			int r = s.nextInt();
			int d = s.nextInt();
			int ans = 0;
			if (l/d>=1&&l!=d) {
				for (int i = 1;d*i<l;i++) {
					if (d*i<l) {
						ans = d*i;
						break;
					}
				}
			}else {
				for (int i = r/d;;i++) {
					if (d*i>r) {
						ans = d*i;
						break;
					}
				}
			}
			System.out.println(ans);
		}
		s.close();
	}

}
