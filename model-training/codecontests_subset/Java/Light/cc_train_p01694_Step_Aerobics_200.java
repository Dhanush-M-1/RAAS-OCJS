
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;

		while (true) {
			int n = sc.nextInt();
			if(n==0) {
				break;
			}
			ans =0;
			List<String> step = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				step.add(sc.next());
			}

			for (int i = 0; i < n-1; i++) {
				if ((ans == 0 || ans % 2 == 0) && (step.get(i).equals("ru")
						&& step.get(i + 1).equals("lu")) || (step.get(i).equals("lu")
								&& step.get(i + 1).equals("ru"))) {
					ans++;
					i++;
				} else if (ans % 2 == 1 && (step.get(i).equals("rd")
						&& step.get(i + 1).equals("ld")) || (step.get(i).equals("ld")
								&& step.get(i + 1).equals("rd"))) {
					ans++;
					i++;
				}
			}
			System.out.println(ans);
		}

	}

}
