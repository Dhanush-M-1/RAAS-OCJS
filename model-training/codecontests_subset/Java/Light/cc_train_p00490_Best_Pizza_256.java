import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int toping, topingPrice;
		int bestPizza = 0, sumPrice = 0, sumCalorie = 0;
		int [] calorie = new int [100];
		boolean flag = false;
		
		for (int i = 0; i < 100; i++) {
			calorie[i] = 0;
		}
		
		toping = sc.nextInt();
		sumPrice = sc.nextInt();
		topingPrice = sc.nextInt();
		
		sumCalorie = sc.nextInt();
		
		for (int i = 0; i < toping; i++) {
			calorie[i] = sc.nextInt();
		}
		
		//カロリーが高い順に単純ソート
		for (int i = 0; i < toping-1; i++) {
			for (int j = i + 1; j < toping; j++) {
				if (calorie[i] < calorie[j]) {
					int shel = calorie[i];
					calorie[i] = calorie[j];
					calorie[j] = shel;
				}
			}
		}
		
		for (int i = 0; i < toping && !flag; i++) {
			sumCalorie += calorie[i];
			sumPrice += topingPrice;
			
			if (bestPizza > (int)(sumCalorie / sumPrice)) {
				flag = true;
			}else {
				bestPizza = (int)(sumCalorie / sumPrice);
			}
		}
		
		System.out.printf("%d\n", bestPizza);

	}

}