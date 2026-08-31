import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);// ??\?????????????????????
		int count = scanner.nextInt();
		int flag = 0;
		
		for(int i = 0; i < count; i++){
			int num = scanner.nextInt();
			for(int j = (int) Math.sqrt(num); 1 < j; j--){
				if(j == 1){
					break;
				}
				if(num % j == 0){
					flag++;
					break;
				} 
			}
		}
		System.out.println(count - flag);
	}
}