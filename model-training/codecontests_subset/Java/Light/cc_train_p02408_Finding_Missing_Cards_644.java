import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] c = new int[4][13];
		for( int i = 0 ; i < num ; i++ ) {
			String[] card = br.readLine().split(" ");
			int j = Integer.parseInt(card[1]);
			switch(card[0]) {
				case "S":
				c[0][j-1] = 1;
				break;
				case "H":
				c[1][j-1] = 1;
				break;
				case "C":
				c[2][j-1] = 1;
				break;
				case "D":
				c[3][j-1] = 1;
				break;
				default:
				/* do nothing */
			}
		}
		String[] color = { "S ", "H ", "C ", "D "};
		for( int i = 0 ; i < 4 ; i++ ) {
			String s = color[i];
			for( int j = 0 ; j < 13 ; j++ ) {
				if ( c[i][j] == 0 ) {
					System.out.println( s + (j+1) );
				}
			}
		}
	}
}