import java.util.Scanner;

public class A268_Games {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[][] teams = new int[num][2];
		
		for (int i = 0; i < num; i ++) {
			teams[i][0] = input.nextInt();
			teams[i][1] = input.nextInt();
		}
		
		int games = 0;
		
		for (int i = 0; i < num; i ++) {
			for (int j = 0; j < num; j ++) {
				hi:
				if (i == j) {
					break hi;
				}
				if (teams[i][0] == teams[j][1]) {
					games ++;
				}
				
			}
			
		}
		
		System.out.println(games);

	}

}
