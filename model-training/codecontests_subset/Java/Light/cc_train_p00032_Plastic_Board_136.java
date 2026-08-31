import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)
			throws NumberFormatException, IOException {
		// TODO ?????????????????????????????????????????????
//		Scanner sc = new Scanner(System.in);
//		sc.useDelimiter(",|\\r\\n");
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		int chohoke = 0;
		int hisi = 0;
//		while (sc.hasNext()) {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			int c = sc.nextInt();
//			if (a*a + b*b == c*c) chohoke++;
//			if (a == b) hisi++;
//		}
		for (String str; (str=br.readLine()) != null; /* Nothing to do */) {
			String[] data = str.split(",");
			int a = Integer.parseInt(data[0]);
			int b = Integer.parseInt(data[1]);
			int c = Integer.parseInt(data[2]);
			if (a*a + b*b == c*c) chohoke++;
			if (a == b) hisi++;
		}
		System.out.println(chohoke);
		System.out.println(hisi);
	}

}