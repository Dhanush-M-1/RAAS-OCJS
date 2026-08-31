import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class r21822 {
	static int N, K, Answer;

	static ArrayList<ArrayList<Integer>> lst;

	static StreamTokenizer in;

	public static int readInt() throws IOException {
		in.nextToken();
		return (int) in.nval;
	}// incomplete

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("MaximalMatSubSeq.txt"));
		Reader reader = new BufferedReader(new InputStreamReader(System.in));
		in = new StreamTokenizer(reader);
		N = readInt();
		K = readInt();
		Answer = 0;
		if (N == K) {
			System.out.println(0);
		}
		else {
			fun();
		}
	}

	private static void fun() {
		int x2 = 0, x3 = 0, x5 = 0, y2 = 0, y3 = 0, y5 = 0, xn = 0, yn = 0;
		while (N != 1) {
			if (N % 2 == 0) {
				x2++;
				N /= 2;
			}
			else if (N % 3 == 0) {
				x3++;
				N /= 3;
			}
			else if (N % 5 == 0) {
				x5++;
				N /= 5;
			}
			else {
				xn = N;
				N /= N;
			}
		}
		while (K != 1) {
			if (K % 2 == 0) {
				y2++;
				K /= 2;
			}
			else if (K % 3 == 0) {
				y3++;
				K /= 3;
			}
			else if (K % 5 == 0) {
				y5++;
				K /= 5;
			}
			else {
				yn = K;
				K /= K;
			}
		}

		if (xn != yn) {
			System.out.println(-1);
		}
		else {
			Answer = Math.abs(x2 - y2) + Math.abs(x3 - y3) + Math.abs(x5 - y5);
			System.out.println(Answer);
		}

	}

}
