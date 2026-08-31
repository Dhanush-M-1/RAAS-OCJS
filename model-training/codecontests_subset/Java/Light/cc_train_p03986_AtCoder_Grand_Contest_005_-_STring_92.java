import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String str = in.nextLine();
		int s = 0, t = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == 'S'){
				s++;
			}else if(str.charAt(i) == 'T' && s > 0){
				s--;
			}else{
				t++;
			}
		}
		System.out.println(s + t);
	}
}
