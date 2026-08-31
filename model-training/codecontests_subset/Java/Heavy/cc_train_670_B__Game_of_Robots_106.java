import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
	
	private static StreamTokenizer inputReader = new StreamTokenizer(
			new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) {
		int n = nextInt();
		int k = nextInt();
		int[] ids = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			ids[i] = nextInt();
		}
		
		long[] sums = new long[n + 1];
		sums[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			sums[i] = sums[i - 1] + i;
		}
		
		int personPosition = 0;
		for (int i = 0; i <= n; i++) {
			if (k <= sums[i]) {
				personPosition = i;
				break;
			}
		}
		
		long saidBefore;
		if (personPosition % 2 == 0) {
			saidBefore = personPosition / 2 * (personPosition - 1);
		} else {
			saidBefore = (personPosition - 1) / 2 * personPosition;
		}
		
		int personSaid = (int) (k - saidBefore);
		int id = ids[personSaid];
		System.out.println(id);
	}
	
	public static int nextInt() {
		int a = -1;
		try {
			inputReader.nextToken();
			a = (int) inputReader.nval;
		} catch (Exception e) {
		}
		return a;
	}

}
