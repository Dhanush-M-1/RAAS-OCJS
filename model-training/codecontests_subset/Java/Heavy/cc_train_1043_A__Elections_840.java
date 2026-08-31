import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Elections {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * System.out.println("Enter Number of students: ");
		 */ String n = br.readLine();
		int students = Integer.parseInt(n);
		/*
		 * System.out.println("Enter each Students vote to E: ");
		 */
		int[] votes = new int[students];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int sum=0;
		int pseudo_min_of_k=0;
		for (int i = 0; i < students; i++) {

			votes[i] = Integer.parseInt(tk.nextToken());
			sum=sum + votes[i];
			if (votes[i] > pseudo_min_of_k)
				pseudo_min_of_k = votes[i];
		}
		/*
		 * System.out.println("Arary Elements are: "); for (int i = 0; i < students;
		 * i++) { System.out.print(votes[i]+" "); } System.out.println(" ");
		 */
		

		int k =  (int)(2 * (sum) / students)+1;
		int actual_min_value = 0;
		if (pseudo_min_of_k > k)
			actual_min_value = pseudo_min_of_k;
		else
			actual_min_value = k;

		System.out.println(actual_min_value);

	}

}