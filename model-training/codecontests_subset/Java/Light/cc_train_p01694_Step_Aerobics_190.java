import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		while(true){
			int n = stdIn.nextInt();
			if(n==0) return;
			int[] step = new int[n];
			for(int i=0;i<n;i++){
				String s = stdIn.next();
				if(s.equals("lu")){
					step[i] = 1;
				}
				else if(s.equals("ru")){
					step[i] = 2;
				}
				else if(s.equals("ld")){
					step[i] = 3;
				}
				else if(s.equals("rd")){
					step[i] = 4;
				}
			}
			boolean groundLeft = true;
			boolean groundRight = true;
			boolean nextGround = false;
			int cnt = 0;
			for(int i=0;i<n;i++){
				if(step[i]==1){
					groundLeft = false;
				}
				else if(step[i]==2){
					groundRight = false;
				}
				else if(step[i]==3){
					groundLeft = true;
				}
				else if(step[i]==4){
					groundRight = true;
				}
				if(nextGround&&groundLeft&&groundRight){
					cnt++;
					nextGround = false;
				}
				else if(!nextGround&&!groundLeft&&!groundRight){
					cnt++;
					nextGround = true;
				}
			}
			System.out.println(cnt);
		}
	}
}