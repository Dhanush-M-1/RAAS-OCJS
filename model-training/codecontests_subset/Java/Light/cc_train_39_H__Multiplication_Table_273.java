import java.util.*;

public class MultiplicationTable {
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		int r = reader.nextInt();
		for(int i = 1; i < r; i++){
			for(int j = 1; j < r; j++){
				System.out.print(Integer.toString(i*j,r) + " ");
			}
			System.out.println();
		}
	}
}
