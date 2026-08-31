import java.util.*;

public class gffh {
	public static void main(String[] args) {
		Scanner scanny = new Scanner(System.in);
		int x = scanny.nextInt();
		int y = scanny.nextInt();
		int mid = (x+y)/2;
		int t = 0;
		int xx = mid-Math.min(x, y);
		int yy = Math.max(x, y)-mid;
		for (int i = 0; i <= xx; i++) t+=i;
		for (int i = 0; i <= yy; i++) t+=i;
		System.out.println(t);
	}
}