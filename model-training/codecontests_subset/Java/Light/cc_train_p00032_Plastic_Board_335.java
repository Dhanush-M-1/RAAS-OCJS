import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringTokenizer st;

		int rectangle = 0, rhombus = 0;
		int[] sides = new int[3];
		
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line, ",");
			for (int i = 0; i < 3; i++) {
				sides[i] = Integer.parseInt(st.nextToken());
			}
			if (sides[2] * sides[2] == sides[0] * sides[0] + sides[1]
					* sides[1])
				rectangle++;
			else if (sides[0] == sides[1])
				rhombus++;
		}
		System.out.println(rectangle + "\n" + rhombus);
	}
}