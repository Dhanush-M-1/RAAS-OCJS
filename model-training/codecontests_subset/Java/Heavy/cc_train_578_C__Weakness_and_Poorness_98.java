

import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class problem578C {


	public static void main(String[] str) throws IOException {
		new problem578C().run();

	}

	private static double check(ArrayList<Integer> arr, double x) {
		//predproschet

		// poisk max max and max min

		//max
		double min1 = 0;
		double max1 = 0;
		//min
		double min2 = 0;
		double max2 = 0;

		double last = 0;
		for (int i = 0; i < arr.size(); i++) {
			double e;
			if(i == 0){
				e = arr.get(i) - x;

			}else{
				e = last + arr.get(i)-x;
			}
			last = e;

			//max
			if (e < min1)
				min1 = e;
			if (e - min1 > max1)
				max1 = e - min1;
			//min

			if (e > min2)
				min2 = e;
			if ( e - min2 < max2)
				max2 = e - min2;
		}


		return max1 > abs(max2) ? max1 : abs(max2);
	}

	private static double tp(ArrayList<Integer> arr) {
		double l = -100000;
		double r = 100000;
		final double EPS = 0.0000001;
		double a1 = 10, a2 = 0;
		while (r - l > EPS || abs(a1-a2) > EPS) {
			double m1 = l + (r - l) / 3;
			double m2 = r - (r - l) / 3;
			a1 = check(arr, m1);
			a2 = check(arr, m2);
			//if(abs(a1-a2) < EPS) return a1;
			if (a1 > a2) {
				l = m1;
			} else {
				r = m2;
			}

		}


		return a1;
	}

	BufferedReader br;
	PrintWriter pw;
	StringTokenizer stok;

	private String nextToken() throws IOException {
		while (stok==null || !stok.hasMoreTokens()){
			stok = new StringTokenizer(br.readLine());
		}
		return stok.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public void run() throws IOException {
//        br=new BufferedReader(new FileReader("input.txt"));
//        pw=new PrintWriter("output.txt");
		br=new BufferedReader(new InputStreamReader(System.in));
		pw=new PrintWriter(new OutputStreamWriter(System.out));

		solve();
		pw.flush();
		pw.close();
	}

	private void solve() throws IOException {
		int n;
		//Time time = Time.
		//Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		n = nextInt();
		//n = 200000;
		for (int i = 0; i < n; i++) {
			arr.add(nextInt());
			//arr.add(0);
		}

		//double l = scanner.nextDouble();
		//System.out.println(check(arr, 0));

		System.out.println(tp(arr));
	}
}
