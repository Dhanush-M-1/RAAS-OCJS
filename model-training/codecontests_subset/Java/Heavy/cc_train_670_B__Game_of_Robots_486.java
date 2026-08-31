import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Round350BGameOfRobots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			StringTokenizer tk = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(tk.nextToken());
			long k = Long.parseLong(tk.nextToken());

			tk = new StringTokenizer(br.readLine());
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(tk.nextToken());
			}
			long m = (long) Math.floor((Math.sqrt(8 * k) - 1) / 2);
			int ans = (int) (k - m * (m + 1) / 2);

			System.out.println(a[ans - 1]);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
