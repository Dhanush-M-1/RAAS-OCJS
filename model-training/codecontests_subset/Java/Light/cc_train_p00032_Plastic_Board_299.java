import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		int hishi = 0;
		int tyou = 0;
		String check;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((check=br.readLine()) != null) {
			String[] str = new String[3];
			str = check.split(",");
			int[] hen = new int[3];
			hen[0] = Integer.parseInt(str[0]);
			hen[1] = Integer.parseInt(str[1]);
			hen[2] = Integer.parseInt(str[2]);
			if(hen[0]*hen[0] + hen[1]*hen[1] == hen[2]*hen[2]) tyou++;
			if(hen[0] == hen[1] && (hen[0]+hen[1]>hen[2] || Math.abs(hen[0]-hen[1])<hen[2])) hishi++;
		}
		System.out.println(tyou +"\n" + hishi);
	}
}