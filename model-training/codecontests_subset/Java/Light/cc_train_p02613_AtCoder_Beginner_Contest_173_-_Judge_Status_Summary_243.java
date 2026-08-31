import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
      	
      	int num = sc.nextInt();
      	int nums[] = new int[num];
      	int c[] = new int[4];
      	String str[] = {"AC","WA","TLE","RE"};
      	String stack;
      
      	for(int i = 0;i < 4;i++) c[i] = 0;
      
      	for(int i = 0;i < num;i++) {
          stack = sc.next();
          for(int j  = 0;j < 4;j++) {
          	if(str[j].equals(stack)) c[j]++; 
          }
       	}
      
      	for(int i = 0;i < 4;i++) System.out.println(str[i] +" x " +c[i]);
        
	}
}
