import java.util.*;

public class Games{
  public static void main(String[] args){
    Scanner gd = new Scanner(System.in);
    int num = gd.nextInt();
    int[] home = new int[num];
    int[] away = new int[num];
    int count = 0;
    for(int i=0;i<num;i++){
      home[i] = gd.nextInt();
      away[i] = gd.nextInt();
    }
    for(int i=0;i<num;i++){
      for(int j=0;j<num;j++){
        if(i!=j){
          if(home[i]==away[j]){
            count++;
          }
        }
      }
    }
    System.out.println(count);
  }
}
