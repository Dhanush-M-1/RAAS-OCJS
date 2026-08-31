import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
      	//数値の入力
		String s = sc.next();
      	String ans = "NO";
		for(int i = 0; i < s.length(); i++){
          for(int j = 0; j < s.length(); j++){
        	String zen = s.substring(0,i);
            String go = s.substring(j,s.length());
            if(zen.equals("keyence") || go.equals("keyence") || (zen+go).equals("keyence")){
             ans = "YES";
            }
        }
        }
             System.out.println(ans);
     }
}