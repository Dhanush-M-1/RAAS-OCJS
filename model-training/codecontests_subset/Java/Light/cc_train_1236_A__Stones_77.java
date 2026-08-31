import java.util.Scanner;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		while(sc.hasNext()){
			int b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt(), e = 0, sum = 0;
			e = Math.min(c, d / 2);
			sum = e * 3;
			e = Math.min(b, (c - e) / 2);
			sum = sum + e * 3;
			System.out.println(sum);
			
		}
	}
}
							  		  			   					 			 	