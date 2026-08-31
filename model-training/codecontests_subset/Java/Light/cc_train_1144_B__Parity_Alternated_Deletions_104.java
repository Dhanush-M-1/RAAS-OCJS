import java.util.Arrays;
import java.util.Scanner;

public class BaiB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] chan = new int[n];
		int[] le = new int[n];
		int demc = 0, deml = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if (a % 2 == 0) {
				chan[demc++] = a;
			} else {
				le[deml++] = a;
			}
		}
		Arrays.sort(le, 0, deml);
		Arrays.sort(chan, 0, demc);
		long kq=0;
		if(deml>demc)
		{
			for(int i=0; i<deml-demc-1; i++) kq+=le[i];
		}
		else
		{
			if(demc>deml)
			for(int i=0; i<demc-deml-1; i++) kq+=chan[i];
		}
		System.out.println(kq);
	}
}
