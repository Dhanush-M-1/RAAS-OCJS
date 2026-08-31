import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kingOfThieves {

   public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str);

		str = br.readLine();
		int x = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++)
			if (str.charAt(i) == '*')
				cnt++;

		int A[] = new int[cnt];

		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '*')
				A[x++] = i + 1;
		}

		boolean f = false;

		for (int i = 0; i < cnt; i++) {
			for (int j = i + 1; j < cnt; j++) {
				int diff = A[j] - A[i];
				int r = A[j];
				int count = 1;
				for (int k = j + 1; k < cnt; k++) {
					if (r + diff == A[k]) {
						r = A[k];
						count++;
						if (count >= 4) {
							f = true;
							break;
						}
					}
				}
				if (f)
					break;
			}
			if (f)
				break;
		}

		if (f)
			System.out.println("yes");
		else
			System.out.println("no");

	}

}
