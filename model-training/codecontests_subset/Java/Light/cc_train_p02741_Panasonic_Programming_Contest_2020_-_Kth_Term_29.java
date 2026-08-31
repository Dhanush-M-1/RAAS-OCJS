import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    int K =sc.nextInt();
    if(K<=16){
    int M[] ={1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14};
    System.out.println(M[K-1]);}
    else{int N[] ={ 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};
    System.out.println(N[K-17]);}
  }
}