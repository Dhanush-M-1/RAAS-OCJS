import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] menu = new int[n];
    int[] point = new int[n];
    int[] bonus = new int[n];
    int sum = 0;
    
    for(int i = 0; i < n; i++){
      menu[i] = sc.nextInt();
    }
    for(int i = 0; i < n; i++){
      point[i] = sc.nextInt();
    }
    for(int i = 1; i < n; i++){
      bonus[i] = sc.nextInt();
    }
    
    for(int i = 0; i < n; i++){//計算
      sum += point[menu[i] - 1];
      if(i != 0 && (menu[i] == menu[i - 1] + 1)){
        sum += bonus[menu[i -1]];
      }
    }
         
    System.out.println(sum);
  } 
}