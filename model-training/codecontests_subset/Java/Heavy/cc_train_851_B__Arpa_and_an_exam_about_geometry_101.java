import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static Scanner in = new Scanner(System.in);
	static final double EPS = 1e-7;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long xa = Long.valueOf(st.nextToken());
		long ya = Long.valueOf(st.nextToken());
		long xb = Long.valueOf(st.nextToken());
		long yb = Long.valueOf(st.nextToken());
		long xc = Long.valueOf(st.nextToken());
		long yc = Long.valueOf(st.nextToken());

		if(dis(xa, ya, xb, yb) == dis(xc, yc, xb, yb) && Math.abs((yb-ya)*(xc-xb)-(yc-yb)*(xb-xa))!=0)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
	public static long dis(long x1, long y1, long x2, long y2){
		return (x1-x2)*(x1-x2) + (y1-y2) * (y1-y2);
	}
}