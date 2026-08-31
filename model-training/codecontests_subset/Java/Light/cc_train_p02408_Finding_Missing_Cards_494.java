import java.util.Scanner;

class Main{
	public static void main(String[] args) {
			try(Scanner sc = new Scanner(System.in)){
				final String[] patterns = {"S","H","C","D"};
				int length = sc.nextInt();
				boolean[][] cards = new boolean[4][13];
				for(int i = 0; i < 52; i++) {
					cards[i/13][i%13] = true;
				}
				for(int i = 0; i < length; i++) {
					String pattern = sc.next();
					int num = sc.nextInt();

					if(pattern.equals("S")) {
						cards[0][num-1] = false;
					}
					else if(pattern.equals("H")) {
						cards[1][num-1] = false;
					}
					else if(pattern.equals("C")) {
						cards[2][num-1] = false;
					}
					else if(pattern.equals("D")) {
						cards[3][num-1] = false;
					}
				}
				for(int i = 0; i < 52; i++) {
					if(cards[i/13][i%13])
						System.out.println(String.format("%s %d", patterns[i/13],i%13+1));
			}
		}
	}

}

