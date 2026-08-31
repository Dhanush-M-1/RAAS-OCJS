import java.util.Scanner;
public class Main{
	private static boolean check(int number){
		if(number==2){	
			return true;
		}
		else if(number%2==0 || number<2){
			return false;
			}
		else
			for(int j = 3; j <=Math.sqrt(number);j+=2){
				if(number%j==0){
					return false;
				}
			}
		return true;
				
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		int[] number = new int[n]; 
		for(int i = 0 ; i < n ; i++){
			number[i]=scan.nextInt();
		}
		for(int i = 0; i < n ; i++){
			if(check(number[i])){
				count++;
			}
		}	
		System.out.println(count);
	}
}