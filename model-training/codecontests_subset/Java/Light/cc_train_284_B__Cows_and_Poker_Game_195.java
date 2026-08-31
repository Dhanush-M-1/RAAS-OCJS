import java.util.*;

public class B {
	public static void main(String [] args){
		try (Scanner s = new Scanner(System.in)){
			final int n = s.nextInt();
			final String status = s.next();
			int allin = 0;
			int in = 0;
			int folded = 0;
			for (int i = 0; i < status.length(); ++i){
				if (status.charAt(i) == 'A'){
					allin++;
				}else if (status.charAt(i) == 'I'){
					in++;
				}else{
					folded++;
				}
			}
			if (in == 0){
				System.out.println(allin);
			}else if (in == 1){
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}
}
