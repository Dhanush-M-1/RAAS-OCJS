import java.util.Scanner;
public class Coin{
	public static void main(String arg[]){
		Scanner sc=new Scanner(System.in);
		int sum=0;
		for(int i=0;i<5;i++){
		sum+=sc.nextInt();	
		}

		if(sum>0 && sum%5==0)System.out.println(sum/5);
		else System.out.println("-1");
	}
	
}