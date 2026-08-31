import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int strLen = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		Map<String, Integer> gramCount = new HashMap<>();
		
		int maxAppearance = 1;
		String maxAppearGram = str.substring(0, 2);
		for(int i = 0; i < strLen - 1; i++) {
			String curGram = str.substring(i, i + 2);
			int gramAppearance = gramCount.containsKey(curGram) ? gramCount.get(curGram) : 0;
			gramAppearance++;
			gramCount.put(str.substring(i, i + 2), gramAppearance);
			if(gramAppearance > maxAppearance) {
				maxAppearance = gramAppearance;
				maxAppearGram = curGram;
			}
		}
		
		System.out.println(maxAppearGram);
	}
}
