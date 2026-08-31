import java.util.*;

class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.next());
    int[] p = new int[n];
    long sum = 0;
    int count = 0;
    for(int i=0;i<n;i++){
      p[i] = Integer.parseInt(sc.next());
      if(p[i]==i+1){
        count++;
      }else{
        sum+=(count+1)/2;
        count = 0;
      }
    }
    sum+=(count+1)/2;
    System.out.println(sum);
  }
}
