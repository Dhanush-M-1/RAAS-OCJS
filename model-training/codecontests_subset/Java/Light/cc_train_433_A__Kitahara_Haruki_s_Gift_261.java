import java.util.*;

public class CodeForces433A{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int count_hundred = 0;
		int count_twohundred = 0;
		for(int i = 0;i<n;i++){
			int c = input.nextInt();
			if(c == 100){
				count_hundred++;
			}
			else{
				count_twohundred++;
			}
		}
		if(count_hundred%2 != 0){
			System.out.println("NO");
		}
		else{
			if(count_hundred == 0 && count_twohundred%2 != 0){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}
		}
	}
}