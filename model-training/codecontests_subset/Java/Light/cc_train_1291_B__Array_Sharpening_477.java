import java.util.Scanner;

public class B_616 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int u = 0; u < t; u++){
			int n = input.nextInt();
			int sf = n - 1;
			int sb = 0;
			for(int i = 0; i < n; i++){
				int a = input.nextInt();
				if(a < i){
					sf = Math.min(sf, i - 1);
				}
				if(a < n - i - 1){
					sb = i + 1;
				}
			}
			if(sf >= sb){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}

}
