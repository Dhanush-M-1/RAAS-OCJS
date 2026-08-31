
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0){break;}
			for(int i = 0; i < a; i++){
				String s = "";
				for(int k = 0; k < b; k++){
					if((i + k) % 2 == 0){
						s += "#";
					}else{
						s += ".";
					}
				}
				System.out.println(s);
			}
			System.out.println();
		}
	}
}

