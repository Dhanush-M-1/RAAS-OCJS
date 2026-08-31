import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	Scanner sc = new Scanner(System.in);
	int[] size;
	public void run(){
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			calc(n);
		}
	}
	public void calc(int n){
		size = new int[n];
		for(int i = 0; i < n; i++){
			String s = sc.next();
			size[i] = s.length();
		}
		int ans = 0;
		while(true){
			int i = ans;
			i = check(i, n, 5);
			if(i != -1) {
				i = check(i, n, 7);
				if(i != -1){
					i = check(i, n, 5);
					if(i != -1){
						i = check(i, n, 7);
						if(i != -1){
							i = check(i, n, 7);
							if(i != -1) break;
						}
					}
				}
			}
			ans+=1;	
		}
		System.out.println(ans+1);
	}
	
	public int check(int start, int n, int s){
		int sum = 0;
		for(int i = start; i < n; i++){
			sum += size[i];
			if(sum == s) return i+1;
			else if(sum > s) return -1;
		}
		return -1;
	}
	
	public static void main(String[] args){
		new Main().run();
	}
	
}