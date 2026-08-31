import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		scanner.nextLine();
		
		char[] arr = scanner.nextLine().toCharArray();
		
		int count = 0; 
		
		if(arr[n - y - 1] != '1')
		    ++count; 
		    
		    
	    for(int i = n - x; i < n; ++i){
	        if(arr[i] != '0' && i != (n - y - 1))
	            ++count; 
	    }
	    
	    System.out.println(count); 
	    
	}
}