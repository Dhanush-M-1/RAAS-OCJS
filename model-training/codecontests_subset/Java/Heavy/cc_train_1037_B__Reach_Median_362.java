import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
	
		public static void main(String[] args) {
			int n = 0;
			long s = 0;
			Scanner in = new Scanner(System.in);
			n = in.nextInt();
			s = in.nextLong();
			long [] a = new long[n];
			for(int i = 0; i < n; i++) {
				a[i] = in.nextLong();
			}
			//����������
			Arrays.sort(a);
			long cnt = 0;
			//���������� ������� ����� s � ������� �� �������, ������� ������ s
			if(a[n / 2] < s) {
				for(int i = n / 2; i < n && a[i] < s; i++) {
					cnt += s - a[i];
				}
			} else {
				for(int i = n / 2; i >= 0 && a[i] > s; i--) {
					cnt += a[i] - s;
				}
			}
			System.out.println(cnt);
	}
}
