import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		int rectangle = 0, rhombus = 0;
		int a, b, c;
		while ((line = br.readLine()) != null) {
			a = Integer.parseInt(line.split(",")[0]);
			b = Integer.parseInt(line.split(",")[1]);
			c = Integer.parseInt(line.split(",")[2]);
			if (c * c == a * a + b * b)
				rectangle++;
			else if (a == b)
				rhombus++;
		}
		System.out.println(rectangle);
		System.out.println(rhombus);
	}
}