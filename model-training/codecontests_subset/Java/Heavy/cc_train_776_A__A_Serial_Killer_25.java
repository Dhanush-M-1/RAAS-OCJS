import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Sherlock {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		String[] murderList = new String[2];
		murderList[0] = tokenizer.nextToken();
		murderList[1] = tokenizer.nextToken();
		int n = Integer.parseInt(br.readLine());
		String output = "";
		output += murderList[0] + " " + murderList[1] + "\n";
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			String victim = tokenizer.nextToken();
			if (victim.equals(murderList[0]))
				murderList[0] = tokenizer.nextToken();
			else
				murderList[1] = tokenizer.nextToken();
			output += murderList[0] + " " + murderList[1] + "\n";
		}
		System.out.println(output);
	}
}