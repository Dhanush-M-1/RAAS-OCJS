import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] cards = new String[52];
		Boolean[] flags = new Boolean[52];

		String[] suit = {"S","H","C","D"};

		for(int i=0 ; i<suit.length; i++) {
			for (int num=1; num<=13; num++){
				cards[i*13 + num-1] = suit[i] + " " + num;
				flags[i*13 + num-1] = false;
			}
		}

		for(int j = 0; j<N; j++){
			String set = br.readLine();
			for(int k = 0; k<cards.length; k++) {
				if(set.equals(cards[k])) {
						flags[k] = true;
						break;
				}
			}
		}

		for(int l=0 ; l<cards.length; l++) {
			if(!flags[l]){
				System.out.println(cards[l]);
			}
		}
	}
}