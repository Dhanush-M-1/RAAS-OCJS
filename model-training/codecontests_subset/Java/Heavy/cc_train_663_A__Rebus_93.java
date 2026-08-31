import java.io.IOException;
import java.util.Arrays;

public class Main {

	static java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String line = "+ " + reader.readLine();
		
		String[] strings = line.split(" ");
		
		int positiveNumber = 0;
		int negativeNumber = 0;
		int questionNumber = Integer.parseInt(strings[strings.length - 1]);;
		
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals("+")) {
				positiveNumber++;
			}
			
			if (strings[i].equals("-")) {
				negativeNumber++;
			}
		}
		
		int[] negatives = new int[negativeNumber];
		int[] positives = new int[positiveNumber];
		
		for (int i = 0; i < positiveNumber; i++) {
			positives[i] = 1;
		}
		
		for (int i = 0; i < negativeNumber; i++) {
			negatives[i] = 1;
		}
		
		int diff = positiveNumber - negativeNumber - questionNumber;
		int negativIndex = 0;
		int positiveIndex = 0;
		
		
		while (diff > 0 && negativIndex < negativeNumber) {
			negatives[negativIndex]++;
			negativIndex++;
			negativIndex %= negativeNumber;
			diff--;
		}
		
		while (diff < 0 && positiveIndex < positiveNumber) {
			positives[positiveIndex]++;
			positiveIndex++;
			positiveIndex %= positiveNumber;
			diff++;
		}
		
		if (diff != 0) {
			System.out.println("Impossible");
			return;
		}
		
//		System.out.println("\npositives" + Arrays.toString(positives));
//		System.out.println("\nnegatives" + Arrays.toString(negatives));
		
		for (int i = 0; i < positiveNumber; i++) {
			if (positives[i] > questionNumber) {
				System.out.println("Impossible");
				return;
			}
		}
		
		for (int i = 0; i < negativeNumber; i++) {
			if (negatives[i] > questionNumber) {
				System.out.println("Impossible");
				return;
			}
		}
		
		System.out.println("Possible");
		StringBuilder builder = new StringBuilder();
		
		builder.append(positives[0]);
		positiveIndex = 1;
		negativIndex = 0;
		
		for (int i = 1; i < strings.length; i++) {
			if (strings[i].equals("+")) {
				builder.append(" + ");
				builder.append(positives[positiveIndex]);
				positiveIndex++;
			} else if (strings[i].equals("-")) {
				builder.append(" - ");
				builder.append(negatives[negativIndex]);
				negativIndex++;
			}  else if (strings[i].equals("?")) {
				continue;
			} else {
				builder.append(" " + strings[i]);
			}	
		}
		
		System.out.print(builder.toString());
	}

}
