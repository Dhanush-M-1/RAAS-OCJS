import java.util.*;
import java.io.*;
public class candles {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int start = in.nextInt();
		int inc = in.nextInt();
		int burnt = 0;
		int hours = start;
		int new1 = 0;
		int leftover = 0;
		while(start >= inc) {
			hours += start/inc;
			leftover = start%inc;
			start = ((start/inc)+leftover);
		}
		System.out.println(hours);
	}
}