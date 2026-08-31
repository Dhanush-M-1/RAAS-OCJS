import java.util.*;
public class new_year_candles {
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		
		int a = console.nextInt();
		int b = console.nextInt();
		
		int totalHours = 0;
		int nonready = 0;
		int ready = a;
		
		while(nonready > b || ready > 0)
		{
			if(ready > 0){
				totalHours += ready;
				nonready += ready;
				ready = 0;
			}
			
			ready = nonready / b;
			nonready = nonready % b;
		}
		
		System.out.println(totalHours);
		console.close();
	}
}
