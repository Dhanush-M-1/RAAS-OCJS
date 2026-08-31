import java.io.*;

//School Team Contest #2 (Winter Computer School 2010/11), B
public class Cola {

    public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("/home/kite/input.txt"));
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s[] = r.readLine().split("\\s+");
		int n = Integer.parseInt(s[0]);
		int a = Integer.parseInt(s[1]);
		int b = Integer.parseInt(s[2]);
		int c = Integer.parseInt(s[3]);
		int result = 0;
		for(int i = Math.min(n / 2, c); i >= 0; i--) {
			for(int j = Math.min(n - 2 * i, b); j >= 0; j--) {
				if((n - 2 * i - j) * 2 <= a)
					result++;
			}
		}
		System.out.println(result);
    }

}
