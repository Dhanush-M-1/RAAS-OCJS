

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public enum mark{

		S,
		H,
		C,
		D;

	}

	public static void main(String[] args) {

		List<String> allCard = new ArrayList<>();

		for(mark mark: mark.values()){

			for(int i = 1; i <= 13; i++) {

				allCard.add(String.valueOf(mark) + " " + i);

			}
		}

		Scanner in = new Scanner(System.in);

		int cardCount = in.nextInt();

		for(int i = 0; i <= cardCount; i++) {

			allCard.remove(in.nextLine());

		}

		for(String result: allCard) {

			System.out.println(result);

		}
	}
}