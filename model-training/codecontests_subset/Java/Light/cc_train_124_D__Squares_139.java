import java.io.*;
import java.util.*;

public class D implements Runnable {
	public static void main (String[] args) {new Thread(null, new D(), "_cf", 1 << 28).start();}

	public void run() {
		Scanner s = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("");

		long a = s.nextLong();
		long b = s.nextLong();
		long tx1 = s.nextLong(), ty1 = s.nextLong();
		long x1 = (tx1 - ty1), y1 = (tx1 + ty1);
		
		long tx2 = s.nextLong(), ty2 = s.nextLong();
		long x2 = (tx2 - ty2), y2 = (tx2 + ty2);

		long res = getCost(x1, x2, b);
		res = Math.max(res, getCost(y1, y2, a));
		
		out.println(res);
		
		out.close();
	}
	
	long getCost(long x1, long x2, long b) {
		long minX = Math.min(x1, x2), maxX = Math.max(x1, x2);

		if(minX < 0) minX += Math.abs(minX % (2 * b));
		else minX += 2*b - (minX % (2 * b));
		
		if(maxX > 0) maxX -= Math.abs(maxX % (2 * b));
		else maxX -= 2*b - (Math.abs(maxX) % (2 * b));

		long resX = 0;
		if(maxX < minX) {}
		else if(minX == maxX) resX++;
		else {
			resX = (maxX-minX)/(2*b)+1;
		}
		
		return resX;
	}
}