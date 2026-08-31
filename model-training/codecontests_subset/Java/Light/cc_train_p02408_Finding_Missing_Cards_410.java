import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final String[] suits = {"S", "H", "C", "D"};
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] cards = new String[n];
		sc.nextLine();
		for(int i=0; i<n; i++){
			cards[i] = sc.nextLine();
		}
		
		for(int i=0; i<4; i++){
			for(int j=1; j<=13; j++){
				boolean flag_found = false;
				for(int k=0; k<n; k++){
					if(cards[k].equals(suits[i] + " " + j)){
						flag_found = true;
						break;
					}
				}
				if(flag_found == false){
					System.out.println(suits[i] + " " + j);
				}
			}
		}
		
	}

}