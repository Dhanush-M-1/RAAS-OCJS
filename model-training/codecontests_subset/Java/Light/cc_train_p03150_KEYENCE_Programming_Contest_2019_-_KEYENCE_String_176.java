import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = "NO";
        for(int i = 0; i < s.length(); i++){
        	for(int j = i; j < s.length(); j++){
            	String ans1 = s.substring(0, i);
                String ans2 = s.substring(j, s.length());
                String ans3 = ans1 + ans2;
                if(ans1.equals("keyence") || ans2.equals("keyence") || ans3.equals("keyence")){
                	ans = "YES";
                }
            }
        }
        System.out.println(ans);
    }
}