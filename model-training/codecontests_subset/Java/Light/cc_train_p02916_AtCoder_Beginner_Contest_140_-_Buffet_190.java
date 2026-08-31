import java.util.*;

class Main{
  static Scanner sc = new Scanner(System.in);
  public static void main(String args[]){
    int n = sc.nextInt();
    int a[] = new int[n];
    int b = 0;
    int c[] = new int[n-1];
    for(int i=0;i<n;i++){
      a[i]=sc.nextInt();
    }
    for(int i=0;i<n;i++){
      b+=sc.nextInt();
    }
    for(int i=0;i<n-1;i++){
      c[i]=sc.nextInt();
    }
    int man=0;
    for(int i=0;i<n-1;i++){
      if(a[i]+1==a[i+1]){
        man+=c[a[i]-1];
      }
    }
    System.out.println(man+b);
  }
}