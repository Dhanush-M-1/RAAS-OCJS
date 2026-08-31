import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

	static class RMQ {
		final long[] data;
		int pow;
		long limit;

		public RMQ(int n, long limit) {
			this.limit = limit;
			pow = 1;
			while (pow < n) {
				pow *= 2;
			}
			data = new long[2 * pow];
		}

		void update(int node, long value) {
			node += pow;
			data[node] = Math.min(data[node] + value, limit);
			node /= 2;
			while (node > 0) {
				data[node] = data[2 * node] + data[2 * node + 1];
				node /= 2;
			}
		}

		long get(int left, int right) {
			left += pow;
			right += pow;
			long res = 0;
			while (left < right) {
				if (left % 2 == 1) {
					res = res + data[left++];
				}
				if (right % 2 == 1) {
					res = res + data[--right];
				}
				left /= 2;
				right /= 2;
			}
			return res;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		RMQ armq = new RMQ(n, a);
		RMQ brmq = new RMQ(n, b);

		for (int i = 0; i < q; i++) {
			StringTokenizer qst = new StringTokenizer(br.readLine());
			String type = qst.nextToken();
			if (type.equals("1")) {
				int di = Integer.parseInt(qst.nextToken()) - 1;
				int ai = Integer.parseInt(qst.nextToken());
				armq.update(di, ai);
				brmq.update(di, ai);
			} else {
				int p = Integer.parseInt(qst.nextToken()) - 1;
				int ret = 0;
				if (p > 0) {
					int bleft = 0;
					ret += brmq.get(bleft, p);
				}
				int aleft = p + k;
				if (aleft <= n - 1) {
					ret += armq.get(aleft, n);
				}
				out.println(ret);
			}
		}
		out.close();
	}

}
