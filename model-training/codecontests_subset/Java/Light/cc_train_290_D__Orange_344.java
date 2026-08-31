import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String st = s.nextLine();
		String in = s.nextLine();
		int n = Integer.parseInt(in);
		
		char a[] = st.toCharArray();
		
		for(int i = 0; i < st.length(); i++){
			if(a[i] <= 'Z'){
				a[i] += 'a'-'A';
			}
			if(a[i] < 'a'+n){
				a[i] += 'A'-'a';
			}
		}
		
		String r = "";
		for(char c : a){
			r+=c;
		}
		System.out.println(r);
		
	}
}
