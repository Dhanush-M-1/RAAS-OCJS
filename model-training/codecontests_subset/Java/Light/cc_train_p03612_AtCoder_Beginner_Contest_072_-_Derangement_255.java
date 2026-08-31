import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int data[] = new int[N+1];
		int res = 0;
		int cnt = 0;
		for(int i = 1; i<=N; i++){
			int input = sc.nextInt();
			if(input == i && i !=N){
				int input2 = sc.nextInt();
				data[i] = input2;
				data[i+1] = input;
				i++;
				cnt++;
			}
			else if(input == i && i ==N){
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
