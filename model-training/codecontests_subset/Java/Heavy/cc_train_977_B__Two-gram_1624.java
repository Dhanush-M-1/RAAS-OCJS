import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = Integer.valueOf(scanner.nextLine());
		String input = scanner.nextLine();
		scanner.close();
		findTwoGram(size, input);
	}
	
	private static void findTwoGram(int size, String input) {
		Map<String, Integer> subStrings = new HashMap<String, Integer>();
		Integer max = 0;
		String twoGram = "";
		for(int i =0; i < size-1; i++) {
			String gram = input.substring(i, i+2);
			if (subStrings.containsKey(gram)) {
				subStrings.put(gram, subStrings.get(gram)+1);
			} else {
				subStrings.put(gram, 1);
			}
			if (subStrings.get(gram) > max) {
				max = subStrings.get(gram);
				twoGram = gram;
			}
		}
		System.out.println(twoGram);
	}
}