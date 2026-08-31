import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	Scanner sc = new Scanner(System.in);

	void run() {
		for(;;){
			int n = sc.nextInt();
			if(n == 0){
				break;
			}
			
			String f[] = new String[n];
			boolean u = true;
			boolean l = false;
			boolean r = false;
			int count = 0;
			for(int i  =0 ; i < n ;i++){
				String str = sc.next();
				if(str.equals("lu")){
					l=true;
				}
				if(str.equals("ld")){
					l=false;
				}
				if(str.equals("ru")){
					r=true;
				}
				if(str.equals("rd")){
					r=false;
				}
				if(u && l && r){
					count++;
					u = false;
				}
				if(!u && !l && !r){
					count++;
					u=true;
				}
					
			}
			System.out.println(count);
		}
		
	}
}

