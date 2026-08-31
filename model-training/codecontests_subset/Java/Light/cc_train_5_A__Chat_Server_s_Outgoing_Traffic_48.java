import java.io.*;

public class Contest0005_A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		int ppl = 0;
		int traffic = 0;
		String s = "";
		while ((s = kb.readLine()) != null) {
			if (s.charAt(0) == '+') {
				ppl++;
				continue;
			}
			if (s.charAt(0) == '-') {
				ppl--;
				continue;
			}
			traffic += ppl * (s.substring(s.indexOf(":")).length() - 1);
		}
		System.out.println(traffic);
	}

}
