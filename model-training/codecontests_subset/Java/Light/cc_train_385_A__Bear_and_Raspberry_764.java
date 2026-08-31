import java.util.*;
public class Bear {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int days = in.nextInt() ;
		int beginningKilos = in.nextInt();
		int[] day = new int[days];
		for(int i = 0 ; i < days ; i++){
			day[i] = in.nextInt() ;
		}
		in.close();
		int max = 0 ;
		for(int i = 0 ; i < days - 1 ; i++){
			int temp = day[i] - day[i + 1] - beginningKilos ;
			max = Math.max(max, temp);
		}
		System.out.println(max);
	}

}
