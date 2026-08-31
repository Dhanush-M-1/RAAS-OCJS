import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Reading {
	public static void main(String[] args) throws IOException {
		String[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
		int c = Integer.parseInt(input[0]),
		    v0 = Integer.parseInt(input[1]),
		    vn = Integer.parseInt(input[2]),
		    a = Integer.parseInt(input[3]),
		    l = Integer.parseInt(input[4]);
		
		int currentVelocity = v0,
		    readPages = 0,
		    i = 1;
		while(readPages < c) {
			readPages = readPages - l < 0 ? 0 : readPages - l;
			readPages += currentVelocity;
			currentVelocity = v0 + a * i <= vn ? v0 + a * i : vn;
			i++;
		}
		
		System.out.println(i - 1);
	}
}