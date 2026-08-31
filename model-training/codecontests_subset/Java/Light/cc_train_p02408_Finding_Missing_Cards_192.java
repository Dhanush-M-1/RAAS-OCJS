import java.util.Scanner;

//20180508
//11

public class Main {
    public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int card = scanner.nextInt();
		int count = 0;
		boolean[][] check = new boolean[4][13+1];
		String[] types = new String[]{"S", "H", "C", "D"};

 		while (count != card) {
			String input_type = scanner.next();
			int input_number = scanner.nextInt();
			for(int t = 0;t < 4;t++) {
				for(int n = 1;n <= 13;n++) {
					if(n == input_number && types[t].equals(input_type)) {
						check[t][n] = true;
					}
				}
			}
			count++;
		}
    	scanner.close();

		for(int t = 0;t < 4;t++) {
			for(int n = 1;n <= 13;n++) {
				if(!check[t][n]) {
					System.out.printf("%s %d\n", types[t], n);
				}
			}
		}
    }
}
