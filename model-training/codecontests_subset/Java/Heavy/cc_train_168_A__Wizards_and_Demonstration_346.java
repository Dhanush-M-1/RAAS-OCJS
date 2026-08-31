import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class WizardsAndDemonstration {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = Integer.parseInt(st.nextToken());
		int wizards = Integer.parseInt(st.nextToken());
		double requiredPrecentage = Double.parseDouble(st.nextToken())/100;
		double needed = Math.ceil((total*requiredPrecentage));
		if (needed <= wizards)
			System.out.println(0);
		else
			System.out.println((int) (needed-wizards));
	}

}
