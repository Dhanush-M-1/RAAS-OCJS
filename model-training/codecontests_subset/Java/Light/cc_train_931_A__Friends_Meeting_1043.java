import java.io.BufferedReader;
import java.io.InputStream;
import java.lang.*;
import java.util.*;
public class fan_chipu {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int x = Math.abs(n - m);
		int y = x / 2;
		x -= y;
		int ans = (x * (x + 1) + y * (y + 1)) / 2;
		System.out.println(ans);
		input.close();
	}
}