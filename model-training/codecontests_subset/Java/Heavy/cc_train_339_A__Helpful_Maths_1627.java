import java.util.*;
public class HelpfulMaths {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] arr = in.next().toCharArray();
		int one = 0;
		int two = 0;
		int three = 0;
		int plus = (arr.length) / 2;
		
			for(int i = 0; i < arr.length; i += 2 ){	
				
				if(arr.length == 1)
					System.out.print(arr[i]);		
				else if(arr[i] == '1')
					one++;				
				else if(arr[i] == '2')
					two++;				
				else if(arr[i] == '3')
					three++;	
			}
			
			while(one > 0){
				System.out.print("1");
				one--;
				if(plus > 0){
					System.out.print("+");
					plus--;
				}
			}
			while(two > 0){
				System.out.print("2");
				two--;
				if(plus > 0){
					System.out.print("+");
					plus--;
				}
			}
			while(three > 0){
				System.out.print("3");
				three--;
				if(plus > 0){
					System.out.print("+");
					plus--;
				}
			}
	}
}
