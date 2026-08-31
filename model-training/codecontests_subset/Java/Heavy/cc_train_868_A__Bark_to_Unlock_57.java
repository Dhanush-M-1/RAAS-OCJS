import java.util.Scanner;
public class BarkToUnlock{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String password = scan.nextLine();
		int n = scan.nextInt();	
		int temp1 = 0, temp2 = 0;
		String knownWord[] = new String[n]; 
		for(int i = 0; i < n; i++){
			knownWord[i] = scan.next();
			if (password.equals(knownWord[i])){
				System.out.println("YES");
				System.exit(0);
			}
			if (knownWord[i].charAt(0) == password.charAt(password.length() - 1)){
				temp1 = 1;
			}
			if (knownWord[i].charAt(knownWord[i].length() - 1) == password.charAt(0)){
				temp2 = 1;
			}
		}
		if (temp1 != 0 && temp2 != 0){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}
