import java.util.*;
  
public class Main {
    Scanner sc = new Scanner(System.in);
  
    public static void main(String[] args) {
        new Main(); 
    }
  
    public Main() {
        new TEST().doIt();
    }
    class TEST{
    	String c[] = {"S","H","C","D"};
        void doIt(){
        	int n = sc.nextInt();
        	boolean t[][] = new boolean [4][13];
        	for(int i = 0;i < n;i++){
        		String str = sc.next();
        		int num = sc.nextInt();
        		for(int j = 0;j < 4;j++){
        			if(str.equals(c[j])){
        				t[j][num-1] = true;
        			}
        		}
        	}
        	for(int i = 0;i < 4;i++){
        		for(int j = 0;j < 13;j++){
        			if(!t[i][j])System.out.println(c[i]+" "+(j+1));
        		}
        	}
        }
    }
}