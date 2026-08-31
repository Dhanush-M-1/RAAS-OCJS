import java.util.*;
class Main{
  public static void main(String args[]){
    int tmp;
    int count = 0;
    int minj;
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int [] Array = new int[n];
    
    for(int i = 0; i<n; i++){
      Array[i] = sc.nextInt();
    }

    for(int i = 0; i<n; i++){
      minj = i;
      for(int j = i; j<n;j++){
        if(Array[j]<Array[minj]){
          minj = j;
        }
      }
      if(i != minj){
        tmp = Array[i];
        Array[i] = Array[minj];
        Array[minj] = tmp;
        count++;
      }
    }
    for(int i = 0; i<n-1; i++){
      System.out.printf("%d ",Array[i]);
    }
    System.out.println(Array[n-1]);
    System.out.println(count);
  }
}
