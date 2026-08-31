import java.util.Scanner;

public class practice {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sc.next();
		String n = sc.next();
		
		int countA = 0;
		int countI = 0;
		for(int i = 0; i<n.length(); i++) {
			if(n.charAt(i) == 'A')
				countA++;
			else if(n.charAt(i) == 'I')
				countI++;
		}
		if(countI > 1) 
			System.out.println("0");
		else
			if(countI == 1)
				System.out.println(countI);
			else
				System.out.println(countA);

	}
}
