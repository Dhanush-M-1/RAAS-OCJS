import java.util.Scanner;

public class Helpful_math {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String T = sc.next();
		
		int[] numbers = new int[T.length()/2 +1];
		String res = "";
		int k =0;
		
		for(int i = 0; i<T.length(); i+=2) {
			numbers[k] = T.charAt(i)-48;
			k+=1;
		}
		
		for(int i =numbers.length -1; i>= 0; i--) {
			for( int j = 0; j< i; j++) {
				if(numbers[j] > numbers[j+1]) {
					int tmp =numbers[j+1];
					numbers[j+1] = numbers[j];
					numbers[j] = tmp;
				}
				
			}
		}
		res += numbers[0];
		for(int i = 1; i<numbers.length; i++) {
			res += "+" +numbers[i];
		}
		
		System.out.println(res);

		
		}

}
