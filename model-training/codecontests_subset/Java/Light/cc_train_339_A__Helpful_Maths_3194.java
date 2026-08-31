import java.util.Arrays;
import java.util.Scanner;

public class helpfulmath {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String []num = str.split("\\+");
		int []numInt = new int[num.length];
		for(int i=0;i<num.length;i++){
			numInt[i] = Integer.parseInt(num[i]);
		}
		Arrays.sort(numInt);
		for (int i=0;i<num.length;i++){
			System.out.print(numInt[i]);
			if(i!=num.length-1){
				System.out.print("+");
			}
		}
	}
}
