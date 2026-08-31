import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n == 0) break;
				
				String f = "";
				int right = 0;
				int left = 0;
				int count = 0;
				int step = 0;
				
				for(int i=1; i<=n; i++) {
					f = sc.next();
					if(f.equals("ru")) {
						right++;
						step++;
					}
					else if(f.equals("lu")) {
						left++;
						step++;
					}
					else if(f.equals("rd")) {
						right--;
						step--;
					}
					else {
						left--;
						step--;
					}
					
					if(right == left && step ==2 || step == -2) {
						count++;
						step = 0;
					}
				}
				System.out.println(count);
			}
		}
	}
}
