import java.util.*;

public class Main{
	public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int[] st = new int[3];
      st[0] = sc.nextInt();
      st[1] = sc.nextInt();
      st[2] = sc.nextInt();
      
      if(st[0] == st[1] + st[2] || st[1] == st[0] + st[2] || st[2] == st[0] + st[1]){
        System.out.println("Yes");
      }else{
        System.out.println("No");
      }
    }
}