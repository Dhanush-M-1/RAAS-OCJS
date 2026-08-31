import java.util.*;

public class Main {
	long N, P;
	List<Long> coords;
	long limit;
	long result = 1;

	Main() {
		Scanner in = new Scanner(System.in);
		N = in.nextLong();
		P = in.nextLong();
		in.close();
		calcLimit();
	}

	void calcLimit() {
		long times = N;
		limit = P;
		while (times >= 2) {
			limit = (long) Math.sqrt((double) limit);
			times /= 2;
		}
	}

	void calc() {
		for (long v = limit; v > 0; --v) {
			if (Math.pow(v, N) > P) {
				continue;
			}
			if (P % (long)Math.pow(v, N) == 0) {
				result = v;
				break;
			}
		}
	}

	public static void main(String[] args) {
		Main ins = new Main();
		ins.calc();
		System.out.println(ins.result);
	}

}