import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(in);
		String line = buffer.readLine();
		int n = Integer.valueOf(line);
		line = buffer.readLine();
		Integer ochos = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '8')
				ochos++;
		}
		System.out.println(Math.min(ochos, n/11));
	}

}
