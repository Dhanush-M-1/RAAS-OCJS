import java.util.Scanner;

public class phonenumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		
		String nums = sc.next();
		
		int numEights = 0;
		for(int i = 0; i < length; i++) {
			if(Integer.parseInt(nums.substring(i, i+1)) == 8)
				numEights++;
		}
		
		System.out.println(Math.min(length/11, numEights));
		sc.close();
	}

}
