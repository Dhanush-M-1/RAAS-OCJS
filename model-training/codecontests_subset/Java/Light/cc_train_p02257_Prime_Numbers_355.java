import java.util.*;
public class Main {
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums  = new int[n];
		for(int i=0;i<n;i++){
			nums[i] = sc.nextInt();
		}
		int count = 0;
		for(int x:nums){
			if(isPrime(x)){
				count++;
			}
		}
		System.out.println(count);
	}
	public static  boolean isPrime(int number){
		for(int i=2;i*i<=number;i++){
			if(number%i==0) return false;
		}
		return true;
	}
}