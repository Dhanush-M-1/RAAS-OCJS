import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int sums = 0;
		for(int i = 0; i < 5; i++){
			sums += sc.nextInt();
		}

		if(sums % 5 == 0 && sums > 0){
			System.out.println(sums/5);
		}else{
			System.out.println(-1);
		}
 
 
	}
}