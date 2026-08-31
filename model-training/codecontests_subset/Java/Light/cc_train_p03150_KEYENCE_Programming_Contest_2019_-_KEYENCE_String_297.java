import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        String ans ="NO";
        
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                String a = s.substring(0,i);
                String b = s.substring(j,s.length());
                if(a.equals("keyence") || b.equals("keyence") || (a+b).equals("keyence")){
                    ans = "YES";
                }
            }
        }
		
		System.out.println(ans);
    }
}
