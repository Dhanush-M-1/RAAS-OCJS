import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
		String[] split = reader.readLine().split(" ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		int[] aDiv = new int[3];
		int[] bDiv = new int[3];
		int divisor = 2;
		while(true) {
			if(a % 2 == 0) {
				a = a / 2;
				aDiv[0]++;
			} else if (a % 3 == 0) {
				a = a / 3;
				aDiv[1]++;
			} else if (a % 5 == 0) {
				a = a / 5;
				aDiv[2]++;
			} else {
				break;
			}
		}
		while(true) {
			if(b % 2 == 0) {
				b = b / 2;
				bDiv[0]++;
			} else if (b % 3 == 0) {
				b = b / 3;
				bDiv[1]++;
			} else if (b % 5 == 0) {
				b = b / 5;
				bDiv[2]++;
			} else {
				break;
			}
		}
		//System.out.println(a + " " + b);
		if (a == b) {
			System.out.println(Math.abs(aDiv[0] - bDiv[0]) + Math.abs(aDiv[1] - bDiv[1]) + Math.abs(aDiv[2] - bDiv[2]));
		} else {
			System.out.println("-1");
		}
	}
}