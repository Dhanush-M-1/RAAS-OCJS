import java.util.Scanner;

public class bark {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String pass = scan.nextLine();
		int a = scan.nextInt();
		int first = 0;
		int second = 0;
		boolean wegood = false;
		for(int i = 0;i<a;i++){
			String s = scan.next();
			if(s.charAt(0) == pass.charAt(1)){
				first = 1;
			}
			if(s.charAt(1) == pass.charAt(0)){
				second = 1;
			}
			if(s.equals(pass)){
				wegood = true;
				break;
			}
		}
		if(wegood){
			System.out.println("YES");
		}
		else if(first == 1 && second == 1){
			System.out.println("YES");
		}else{
			System.out.println("NO");


		}
	}
}
