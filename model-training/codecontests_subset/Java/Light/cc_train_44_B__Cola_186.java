import java.util.*;
public class cf44b {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt()*2;
		int c = in.nextInt();
		int b = in.nextInt();
		int a = in.nextInt();
		int t = 0;
		for(int aa=0; aa<=a; aa++)
			for(int bb=0; bb<=b; bb++) {
				int left = n-4*aa-2*bb;
				if(left >= 0 && left <= c)
					t++;
			}
		System.out.println(t);
	}
}
