import java.util.Scanner;
public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		new AOJ2582().doIt();
	}
	class AOJ2582{
		void doIt(){
			while(true){
				int n = in.nextInt();
				if(n==0)break;
				String[] input = new String[n];
				for(int i=0;i<n;i++)input[i] = in.next();
				boolean right = false;
				boolean left = false;
				boolean status = false;
				int cnt = 0;
				for(int i=0;i<n;i++){
					if(input[i].equals("lu"))left = true;
					else if(input[i].equals("ru"))right = true;
					else if(input[i].equals("ld"))left = false;
					else if(input[i].equals("rd"))right = false;
					if(right == left && right != status){
						status = right;
						cnt++;
					}
				}
				System.out.println(cnt);
			}
		}
	}
}