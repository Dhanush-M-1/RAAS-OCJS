import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
      	//数値の入力
		int n = sc.nextInt();
      	int sum = 0;
      
        int num[] = new int[n];
        for(int i = 0; i < n; i++){
        	sum += sc.nextInt();
        }
        System.out.println(sum-n);
     }
}