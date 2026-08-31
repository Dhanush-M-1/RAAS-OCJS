import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class B {
	public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		StringBuilder output = new StringBuilder();
		String newLine = System.lineSeparator();

		long ax = Integer.parseInt(tokenizer.nextToken());
		long ay = Integer.parseInt(tokenizer.nextToken());
		long bx = Integer.parseInt(tokenizer.nextToken());
		long by = Integer.parseInt(tokenizer.nextToken());
		long cx = Integer.parseInt(tokenizer.nextToken());
		long cy = Integer.parseInt(tokenizer.nextToken());
		P a = new P(ax, ay);
		P b = new P(bx, by);
		P c = new P(cx, cy);

		P first = b.sub(a);
		P second = c.sub(b);

		if (first.crossproduct(second) == 0 || first.length2() != second.length2()) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
	static class P {
		final long x, y;
		P(long x, long y)    { this.x = x; this.y = y; }
		P sub(P that)            { return new P(x - that.x, y - that.y); }
		P add(P that)            { return new P(x + that.x, y + that.y); }
		long dot(P that)       { return x * that.x + y * that.y; }
		P scale(long s)        { return new P(x * s, y * s); }
		// Use hypot() only if intermediate overflow must be avoided; very slow
		double length()          { return sqrt(x*x + y*y); }    
		long length2()         { return x * x + y * y; }
		double theta()           { return atan2(y, x); }    // from -pi to +pi
		double angleTo(P a)      { return acos(this.dot(a) / this.length() / a.length()); }
		boolean isOrigin()       { return x == 0 && y == 0; }
		public String toString() { return String.format("(%f,%f)", this.x, this.y); }
		static P origin()        { return new P(0, 0); }
		long det(P that)       { return this.x * that.y - this.y * that.x; }
		long crossproduct(P that) { return this.det(that); }
	}
}
