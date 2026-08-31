import java.util.*;

public class Main{
  public static void main(String aargs[]){
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    String[] ss = {"AC","WA","TLE","RE"};
    int[] cnts = {0,0,0,0};
    
    for(int i = 0; i <= n; i++){
      String r = sc.nextLine();
      for(int j = 0; j < 4; j++){
        if(r.equals(ss[j])){
          cnts[j]++;
          break;
        }
      }
    }
    
    for(int i = 0; i < 4; i++){
      System.out.println(ss[i] + " x " + cnts[i]);
    }
    
  }
}