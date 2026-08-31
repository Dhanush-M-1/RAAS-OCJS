import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
        String s[] = a.split("");
        String ans;
        String ans2;
        String check;
        for(int i = 0; i < a.length(); i++){
          for(int j = i; j < a.length(); j++){
            ans = a.substring(0, i);
            ans2 = a.substring(j, a.length());
            check = ans + ans2;           
       	    if(check.equals("keyence")){
          	 System.out.println("YES");
         	 return;
      	 	 }else if(ans.equals("keyence")){
          	 System.out.println("YES");
         	 return;
            }else if(ans2.equals("keyence")){
          	 System.out.println("YES");
         	 return;
            }
          }
        }
        System.out.println("NO");
    }
}