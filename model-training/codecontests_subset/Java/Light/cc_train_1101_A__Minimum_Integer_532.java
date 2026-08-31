import java.util.Scanner;

public class MinimumInteger{
	public static void main(String[] arguments){
		Scanner scan = new Scanner(System.in);
		int numberOfQuery = scan.nextInt();
		for(int i=0; i<numberOfQuery; i++){
			long left = scan.nextLong();
			long right = scan.nextLong();
			long division = scan.nextLong();

			long number = division;
			;
			while(!(number%division == 0 && (number<left || number > right))){
				number += division;
				if(number >= left && number <=right){
					number = right + (division - (right%division));
				}
			}
			System.out.println(number);
		}
	}
}