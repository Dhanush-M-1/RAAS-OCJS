import java.util.*;

public class Main {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			if(n==0) return ;
			int total = 0;
			boolean flag = false;
			for(int i=0; i<12; i++){
				int plus = in.nextInt(), minus = in.nextInt();
				total += plus - minus;
				if(total >= n && !flag){
					System.out.println(i+1);
					flag = true;
				}
			}
			if(!flag) System.out.println("NA");
		}
	}
}