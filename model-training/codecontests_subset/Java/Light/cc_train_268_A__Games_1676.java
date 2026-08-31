import java.util.Scanner;

public class games {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] home = new int[num];
		int [] away = new int[num];
		for(int i = 0; i < num; i++) {
			home[i] = sc.nextInt();
			away[i] = sc.nextInt();	
		}
		int count = 0;
		for(int i = 0; i < num; i++) {
			for(int x = 0; x < num; x++) {
				if(home[i] == away[x]) {
					count++;
				}
			}
			
		}
		System.out.println(count);
		
	}
}
