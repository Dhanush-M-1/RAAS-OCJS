import java.util.*;
 
public class Main {
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
		String K = "keyence";
		String S = sc.next();
        boolean fl = false;
        int l = S.length();
      	
      	for(int i=7;0<=i;i--){
        	if(S.substring(0,i).equals(K.substring(0,i))){
        		if(S.substring(l-(7-i)).equals(K.substring(i))){
                	System.out.println("YES");
                    fl = true;
                  	break;
                }
            }        
        }
      	if(!fl){
          System.out.println("NO");
        }
     } 
}  