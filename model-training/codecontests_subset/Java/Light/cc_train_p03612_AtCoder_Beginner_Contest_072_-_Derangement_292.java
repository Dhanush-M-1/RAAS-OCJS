import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] p = new boolean[n];
    for(int i = 0;i<n;i++){
      if(i+1==sc.nextInt()){
        p[i]=false;
      }else{
        p[i]=true;
      }
    }
    int count = 0;
    for(int i = 0;i<n-1;i++){
      if(p[i]==false&&p[i+1]==false){
        p[i]=true;
        p[i+1]=true;
        count++;
      }
    }
    for(int i = 0;i<n;i++){
      if(p[i]==false)count++;
    }
    System.out.println(count);
  }
}
