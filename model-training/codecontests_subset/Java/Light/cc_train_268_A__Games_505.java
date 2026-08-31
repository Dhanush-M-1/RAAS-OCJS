import java.util.*;;

public class ZZZ {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in) ;
		byte n = in.nextByte() ;
		int games = 0 ;
		int [][] teams = new int [n][2] ;
		for (int i = 0; i <  n ; i++) {
			for (int j = 0; j < 2 ; j++) {
				teams[i][j] = in.nextInt() ;
			}
		}
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n ; j++) {
				if (teams[j][0] == teams[i][1]) {
					games ++ ;
				}
			}
			}
		System.out.println(games);
		}
	}