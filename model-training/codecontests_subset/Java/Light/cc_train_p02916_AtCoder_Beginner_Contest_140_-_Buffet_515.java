import java.util.Scanner;
public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int[] b = new int[a];
    int[] c = new int[a];
    int[] d = new int[a-1];
    int ans = 0;
    for(int i = 0;i < b.length;i++){
      b[i] = sc.nextInt();
      b[i]--;
    }
    for(int j = 0;j < c.length;j++){
      c[j] = sc.nextInt();
    }
    for(int x = 0;x < d.length;x++){
      d[x] = sc.nextInt();
    }
    for(int y = 0;y < c.length;y++){
      ans += c[b[y]];
      if(y < b.length-1 && b[y] == b[y+1]-1){
        ans += d[b[y]];
      }
    }  
    System.out.println(ans);
  }
}