import java.util.*;

public class Main{
	public static void main(String[] args) {
    	Scanner itr = new Scanner(System.in);
      	int n = itr.nextInt();
      
      	dfs("", 'a', n);
    
    }
  
  	public static void dfs(String s, char max, int n) {
    	if (n == s.length()) {
        	System.out.println(s);
          	return;
        }
      
      	for (int i = 0; i <= (max - 'a'); i++) {
          	char cur = (char) (i + 'a');
        	dfs(s + cur, (max == cur ? (char)(max + 1) : max), n);
        }
    }
}
