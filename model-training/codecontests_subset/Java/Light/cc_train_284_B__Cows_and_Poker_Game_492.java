import java.util.Scanner;

public class Solution284B{

	public Solution284B() {


	}	


	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String line = sc.next();

		int countA = 0;
		int countI = 0;
		for (int i = 0 ; i < n ; i++) {
			if(line.charAt(i) == 'A') {
				countA++;
			}else if (line.charAt(i) == 'I') {
				countI++;
			}else{

			}
		}
		

		if(countI == 0){
			System.out.println(countA);		

		}else{
			if(countI == 1)
				System.out.println(1);
			else
				System.out.println(0);

		}

	}

}