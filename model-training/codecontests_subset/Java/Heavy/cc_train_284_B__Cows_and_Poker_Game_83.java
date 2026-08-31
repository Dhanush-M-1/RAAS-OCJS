import java.util.Scanner;


public class cf174B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String s = scan.nextLine();
		if(s.contains("I") == false){
			int count = 0;
			for(int i = 0; i < n; i++){
				if(s.charAt(i) == 'A'){
					count++;
				}
			}
			System.out.println(count);
		}
		else{
			int count = 0;
			for(int i = 0; i < n; i++){
				if(s.charAt(i) == 'I'){
					count++;
					if(count == 2){
						count = 0;
						break;
					}
					
				}
			}
			System.out.println(count);
		}
	}

}
