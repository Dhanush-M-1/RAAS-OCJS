
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	private void run() throws IOException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			int[][] map = new int[12][2];
			for (int i = 0; i < 12; i++) {
				map[i][0] = scanner.nextInt();
				map[i][1] = scanner.nextInt();
			}
			int sum = 0;
			int index = -1;
			for(int i = 0;i<12;i++){
				sum+= map[i][0]-map[i][1];
				if(sum>=n){
					index = i+1;
					break;
				}
			}
			System.out.println(index==-1?"NA":index);
		}
	}
}