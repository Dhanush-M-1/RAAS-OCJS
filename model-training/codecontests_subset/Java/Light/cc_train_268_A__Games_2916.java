import java.util.ArrayList;
import java.util.Scanner;

public class Games {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int anzahl = scanner.nextInt();
		ArrayList<Integer> homee = new ArrayList<>();
		ArrayList<Integer> guestt = new ArrayList<>();
		int count = 0;
		for(int i = 0; i < anzahl; i++){
				homee.add(scanner.nextInt());
				guestt.add(scanner.nextInt());
		}
		for(int i = 0; i < homee.size(); i++) {
			for (int j = 0; j < guestt.size(); j++) {
				if(homee.get(i) == guestt.get(j)) {
					count++;
				}
			}	
		}
		System.out.println(count);
	}
}