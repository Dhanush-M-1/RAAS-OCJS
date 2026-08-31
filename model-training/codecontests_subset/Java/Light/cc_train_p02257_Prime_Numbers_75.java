import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int primeNumber=0;
		int circle=input.nextInt();
		int[] list=new int[circle];
		for(int i=0;i<circle;i++){
			boolean isPrime=true;
			list[i]=input.nextInt();
			for(int j=2;j<=Math.sqrt(list[i]);j++){
				if(list[i]%j==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime){
				primeNumber++;
			}
		}
		
		System.out.println(primeNumber);
	}

}