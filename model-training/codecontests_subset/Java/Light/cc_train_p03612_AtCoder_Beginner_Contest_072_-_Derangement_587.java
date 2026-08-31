import java.util.*;

public class Main {
	public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
      	int count  = Integer.valueOf(sc.nextLine());
      	String input = sc.nextLine();
      	String inputs[] = input.split(" ");
      	int[] values = new int[count];
      	int ans = 0;
      	for( int i= 0 ; i<count; i++){ 
        	values[i] = Integer.valueOf(inputs[i]);
        }
      	for( int i= 0 ; i<count; i++) 
        {
          	int value = values[i];
        	if(value==(i+1))
            {
             	 if(i!=(count-1))
                {
                  int a  = values[i+1];
                  values[i+1] = values[i];
                  values[i] = values[i+1];
                  
                } else {
                     int a = values[0];
                  	values[0] = values[i];
                  	values[i] = a;
                }
                ans++;    
            }
          	
        }
      System.out.println(ans);	
      
    }
}