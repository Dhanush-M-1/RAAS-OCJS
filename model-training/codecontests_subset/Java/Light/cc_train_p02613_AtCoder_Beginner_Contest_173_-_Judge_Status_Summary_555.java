import java.util.*;

class Main{
  public static void main(String[] args){
  	Scanner sc = new Scanner(System.in);
    
    int num = sc.nextInt();
    int[] counts = new int[4];
    String[] ans = {"AC","WA","TLE","RE"};
    String[] str = new String[num];
    for(int i = 0; i < num; i++){
    	str[i] = sc.next();
      	for(int j = 0; j < 4; j++){
        	if(ans[j].equals(str[i])){
            	counts[j]++;
            }
        }
    }

    for(int i = 0; i < 4; i++)
    	System.out.println(ans[i] + " x " + counts[i]);
    
  }
}