import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chess3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int pw = Integer.parseInt(br.readLine());
		int ps = 3;
		int pl = 0;
		String ret = "YES";
		if(pw == 3) {
			ret = "NO";
		} else {
			if(pw == 2) {
				pl = 1;
			} else if(pw == 1) {
				pl = 2;
			}
			for(int i = 1; i < n ; i++) {
				int cw = Integer.parseInt(br.readLine()); 
				if(cw == pl) {
					ret = "NO";
				} else {
					//				ps = pl;
					//				pl = pw;
					pw = cw;
					ps = pl;
					if(pw == 1) {
						pl = (ps == 2) ? 3 : 2;
					} else if(pw == 2) {
						pl = (ps == 3) ? 1 : 3;
					} else if(pw == 3) {
						pl = (ps == 1) ? 2 : 1;
					}
				}
			}
		}
		System.out.println(ret);
	}

}
