import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = readInt(br);
		while (q-- > 0) {
			int n = readInt(br);
			int minEnd = 1_000_000_001;
			int maxStart = -1;
			while (n-- > 0) {
				int a = readInt(br);
				int b = readInt(br);
				if (a > maxStart) {
					maxStart = a;
				}
				if (b < minEnd) {
					minEnd = b;
				}
			}
			System.out.println(maxStart - minEnd < 0 ? 0 : maxStart - minEnd);
		}
	}
	
	static int readInt(BufferedReader br) throws IOException {
        int number = 0;
        boolean dig = false;
        for (int c = 0; (c = br.read()) != -1; ) {
            if (c >= '0' && c <= '9') {
                dig = true;
                number = number * 10 + c - '0';
            } else if (dig) {
                break;
            }
        }
        return number;
    }
}