import java.util.*;
import java.lang.*;
import java.math.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	void run(){
		for(;;){
			int n = sc.nextInt();
			
			if(n == 0){
				break;
			}
			int ans = 0;
			int data[] = new int[n];
			for(int i = 0; i < n ; i++){
				data[i] = sc.nextInt();
				for(int  j = 0 ; j < i; j++){
					if(data[i] < data[j]){
						ans+= 1;
					}
				}
			}
			System.out.println(ans);
			
		}
		
	}
	public static void main(String[] args){
		Main m = new Main();
		m.run();
	}
}