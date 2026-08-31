import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static StreamTokenizer inputReader = new StreamTokenizer(
			new BufferedReader(new InputStreamReader(System.in)));

	public static int nextInt() {
		int a = -1;
		try {
			inputReader.nextToken();
			a = (int) inputReader.nval;
		} catch (Exception e) {
		}
		return a;
	}
	
	public static void main(String[] args) {
		int numberOfBooks = nextInt();
		int numberOfGenres = nextInt();
		
		int[] genresCounter = new int[numberOfGenres];
		
		for (int i = 0; i < numberOfBooks; i++) {
			genresCounter[nextInt() - 1]++;
		}
		
		int answer = 0;
		
		for (int i = 0; i < numberOfGenres; i++) {
			for (int j = i + 1; j < numberOfGenres; j++) {
				answer += (genresCounter[i] * genresCounter[j]);
			}
		}
		
		System.out.println(answer);
	}
}
