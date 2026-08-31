import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		byte[] eolb = System.getProperty("line.separator").getBytes();
		String[] val = br.readLine().trim().split(" ");

		int l = Integer.parseInt(val[0]);
		int r = Integer.parseInt(val[1]);
		int ans = (l == r) ? l : 2;
		bos.write(String.valueOf(ans).getBytes());
		bos.write(eolb);
		bos.flush();
	}
}
