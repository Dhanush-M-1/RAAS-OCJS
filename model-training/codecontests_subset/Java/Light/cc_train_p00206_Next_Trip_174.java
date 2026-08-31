import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf;

		try {
			while (!(buf = br.readLine()).equals("0")) {
				int sum = Integer.parseInt(buf);
				int m = 0;
				for (int i=0;i<12;i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					if (sum>0) {
						sum -= (Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken()));
						if (sum<=0) m = i+1;
					}
				}
				if (m==0) System.out.println("NA");
				else System.out.println(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}