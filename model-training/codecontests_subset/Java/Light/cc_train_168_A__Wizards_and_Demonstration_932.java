
public class Main {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int pop = input.nextInt(); // >= 1
		int wiz = input.nextInt(); // <= pop
		int per = input.nextInt(); //  <= 10000

		if(per == 0){
			System.out.println(0);
			return;
		}
		
		int needed = pop * per/100;
		//if(needed % 1 != 0) needed = needed - (needed % 1) + 1;
		if((pop * per) % 100 != 0) needed++;
		
		int clones = (int)(needed) - wiz;
		if(clones < 0) clones = 0;
		
		System.out.println(clones);

	}
	
}
   	      	   		  	 		  							