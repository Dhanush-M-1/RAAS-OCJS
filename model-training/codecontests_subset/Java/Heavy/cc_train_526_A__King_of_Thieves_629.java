import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String str = scan.next();
		int c1 = 0;
		int c2 = 0;
		int a1[] = new int[1000];
		
		int map1[] = new int[1000];
	
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '*') {
				a1[c1++] = i;
				map1[i] = 1;
			}
		}

		if (n < 5) {
			System.out.println("no");
			
		}
	
		else{
		int j = 0;
		int flag1 = 0;
		
		int cha = 0;
		for1: for (int i = 0; i <= c1 - 5; i++) {
			j=i+1;
			
			for (cha = a1[j] - a1[i]; cha <= a1[c1-2] - a1[i]; j++) {
				
				if (map1[a1[i]] == 1 && map1[a1[i] + cha] == 1
						&& map1[a1[i] + 2 * cha] == 1
						&& map1[a1[i] + 3 * cha] == 1
						&& map1[a1[i] + 4 * cha] == 1) {
					
					flag1=1;
					break for1;
				}
				
				cha = a1[j] - a1[i];
			}

		}
		

		if ((flag1) == 1) {
			System.out.println("yes");
		} 
		else if(str.equals("*****")){
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		}
	}
}
