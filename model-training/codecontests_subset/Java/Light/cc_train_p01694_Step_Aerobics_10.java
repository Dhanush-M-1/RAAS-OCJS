
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		ArrayList<String> datas = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> result= new ArrayList<Integer>();

		
		while (true) {

			String s1 = new String(in.readLine());
			
			if(s1.equals("0")) break;
			
			String s2 = new String(in.readLine());

			boolean f = true;
			boolean ulf = false;
			boolean urf = false;

			String[] strs = s2.split(" ");
			int count = 0;

			for (String data : strs) {
				if (f) {
					if (data.equals("lu")) {
						ulf = true;
					} else if (data.equals("ru")) {
						urf = true;
					} else if (data.equals("ld")) {
						ulf = false;
					} else if (data.equals("rd")) {
						urf = false;
					}
					if (ulf && urf) {
						f = false;
						count++;
					}

				} else {
					if (data.equals("lu")) {
						ulf = true;
					} else if (data.equals("ru")) {
						urf = true;
					} else if (data.equals("ld")) {
						ulf = false;
					} else if (data.equals("rd")) {
						urf = false;
					}
					if (!ulf && !urf) {
						f = true;
						count++;
					}
				}
			}
			result.add(count);
		}
		for(Integer tes :result)
		System.out.println(tes);
	}
}
