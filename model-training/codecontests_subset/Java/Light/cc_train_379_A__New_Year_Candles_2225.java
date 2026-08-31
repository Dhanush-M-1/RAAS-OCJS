import java.util.Scanner;

public class NewYearCandles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a= scan.nextInt();
		int b=  scan.nextInt();
		int count = 0;
		int time = 0;
		while(a>0){
			count++;
			if(count == b){
				count = 0;
				a++;
			}
			
			time++;
			a--;
			
	
		}
		System.out.println(time);

	}

}
