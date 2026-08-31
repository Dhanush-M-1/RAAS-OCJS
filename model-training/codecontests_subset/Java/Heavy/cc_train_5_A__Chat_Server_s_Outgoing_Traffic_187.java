import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String input;
		char f, plus, minus;
		plus = '+';
		minus = '-';
		int k = 0;
		int bits = 0;
		int x = 0;
		int current = 0;
		
		while(in.hasNext()){
			input = in.nextLine();
			f = input.charAt(0);
			
			if(f == plus){
				 k++;
			}else{
			    if(f == minus){
				     k--;
			    }
			}
			    if(f != plus){
			    	if(f != minus){
			    		x = input.indexOf(':');
			    	    current = input.length() - x - 1;
			    	    bits = bits + current*k;
			    	}
			    				    	
			    }
			}
			
		System.out.println(bits);
		
	}

  }
