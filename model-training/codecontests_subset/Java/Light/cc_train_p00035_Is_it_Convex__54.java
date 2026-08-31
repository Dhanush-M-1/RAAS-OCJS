import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str = br.readLine()) != null) {
			String ns[] = str.split(",");
			double d[][] = new double[4][2];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 2; j++) {
					d[i][j] = Double.parseDouble(ns[i * 2 + j]);
				}
			}
			int ret = 0;
			for(int i = 0; i < 4; i++) {
				if(((d[(i + 1) % 4][0] - d[i][0]) * (d[(i + 2) % 4][1] - d[(i + 1) % 4][1]) - 
						(d[(i + 1) % 4][1] - d[i][1]) * (d[(i + 2) % 4][0] - d[(i + 1) % 4][0])) > 0) {		
					ret += 1;
				} else {
					ret -= 1;
				}
			}
			
			if(Math.abs(ret) == 4) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}