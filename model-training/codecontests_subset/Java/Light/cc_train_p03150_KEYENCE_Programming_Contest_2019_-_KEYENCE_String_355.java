import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		String a = sc.next();
        String s[] = a.split("");
        int i,j;
        String ans = "",ans2 = "";
        String check;
		if(a.equals("keyence")){
          System.out.println("YES");
          return;
        }
        
        
        for(i = 0;i < a.length();i++){
          for(j = i;j < a.length();j++){
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