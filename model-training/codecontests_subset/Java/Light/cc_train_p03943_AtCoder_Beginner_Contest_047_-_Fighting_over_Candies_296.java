import java.util.*;
public class Main{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int max = Math.max(a,Math.max(b,c));
      if(max == a+b+c-max)System.out.println("Yes");
      else System.out.println("No");
    }
}