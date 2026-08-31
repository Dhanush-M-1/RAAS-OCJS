import java.util.*;
import java.lang.Math;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
	char key[] = {'k','e','y','e','n','c','e'};
    int key_count = 0;
    int st_count;
    int el = 0;
    boolean ans = false;
    boolean con = true;
    boolean con2;
    
    for(int i = 0;i < s.length() && con; i++){
    	if(s.charAt(i) == key[key_count] && el == 0) {
          key_count++;
          if(key_count == 7) {
            con = false;
          	ans = true;
          }
        } else if(el == 0) {
          el = 1;
          i = s.length() -(7-key_count)-1;
        }
      	else if(s.charAt(i) == key[key_count]){
          el = 2;
          key_count++;
          if(key_count == 7) {
            con = false;
          	ans = true;
          }
        }
      	else if(el == 2) con = false;    	
    }
     	
    if(ans) System.out.println("YES");
  	else System.out.println("NO");
  }
}
