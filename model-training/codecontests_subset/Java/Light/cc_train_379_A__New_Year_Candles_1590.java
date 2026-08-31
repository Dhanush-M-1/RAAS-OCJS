import java.util.Scanner;

public class NewCandles{
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int newCandles = in.nextInt();
		int b = in.nextInt();
		int time = newCandles;
		int temp = 0;
		while(newCandles >= b){
			temp = newCandles % b;
			newCandles = newCandles / b;
			time += newCandles;
			newCandles = newCandles + temp; 
		}
		System.out.println(time);
	}
}