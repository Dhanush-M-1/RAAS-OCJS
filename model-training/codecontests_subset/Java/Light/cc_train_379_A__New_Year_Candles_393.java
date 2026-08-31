import java.util.Scanner;


public class NewYearCandles {
	
	public static void main(String[] args){
		Scanner ob = new Scanner(System.in);
		
		int a,b;
		
		a = ob.nextInt();
		b = ob.nextInt();
		
		int overCandles=0, hour=0;
		
		while(a>0){
			hour++;
			a--;
			overCandles++;
			if(overCandles==b){
				a++;
				overCandles=0;
			}
		}
		
		System.out.println(hour);
		
		ob.close();
	}

}
