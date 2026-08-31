import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int L = sc.nextInt();
			if(L == 0)break;
			
			int count = 0;
			int sum = 0;
			int a = 0;
			boolean is = true;
			while(count < 12){
				sum += sc.nextInt() - sc.nextInt();
				count++;
				if(L <= sum && is){
					a = count;
					is = false;
				}
			}
			if(L <= sum)System.out.println(a);
			else System.out.println("NA");
		}
	}
}