import java.util.*;
 
public class Main {
    Scanner sc = new Scanner(System.in);
 
    public static void main(String[] args) {
    	new Main(); 
    }
 
    public Main() {
    	new A().doIt();
    }
    class A{
    	void doIt(){
    		while(true){
    			int n = sc.nextInt();
    			if(n == 0)break;
    			boolean left = false;
    			boolean right = false;
    			boolean up = false;
    			int cnt = 0;
    			for(int i = 0;i < n;i++){
    				String str = sc.next();
    				if(str.equals("lu"))left = true;
    				else if(str.equals("ld"))left = false;
    				else if(str.equals("ru"))right = true;
    				else if(str.equals("rd"))right = false;
    				if(!up){
    					if(left && right){
    						cnt++;
    						up = true;
    					}
    				}else{
    					if(!left && !right){
    						cnt++;
    						up = false;
    					}
    				}
    			}
    			System.out.println(cnt);
    		}
    	}
    }
}