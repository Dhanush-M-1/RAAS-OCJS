import java.util.*;
public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    int b[] = new int[n];
    int c[] = new int[n-1];
    int total = 0;

    for(int i=0 ; i<n ; i++){
      a[i] = sc.nextInt();
    }
    for(int j=0 ; j<n ; j++){
      b[j] = sc.nextInt();
    }
    for(int k=0 ; k<n-1 ; k++){
      c[k] = sc.nextInt();
    }

    for(int l=0 ; l<n ; l++){
      total = total +b[l];
    }
    for(int m=0 ; m<n-1 ; m++){
      if(a[m]+1 == a[m+1]){
        total = total + c[a[m]-1];
      }
    }
    System.out.println(total);
  }
}
