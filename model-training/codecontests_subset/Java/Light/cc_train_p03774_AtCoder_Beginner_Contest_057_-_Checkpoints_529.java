import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] a = new int[ N ];
    int[] b = new int[ N ];
    for(int i = 0 ; i < N ;i ++){
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    int[] c = new int[ M ];
    int[] d = new int[ M ];
    for( int i = 0 ;i < M ; i ++ ){
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    int[] checkPointMin = new int[ N ] ;
    for(int i = 0 ;i  < N ; i ++){
      int distanceMin = 200000000;
      for(int j = 0 ; j < M ; j ++){
        int distance = Math.abs( a[i] - c[j] ) + Math.abs( b[i] - d[j] );
        if( distance < distanceMin ){
          distanceMin = distance;
          checkPointMin[i] = j;
        }
      }
    }
    for(int i = 0 ; i < N ; i ++){
      System.out.println( checkPointMin[i] + 1  );
    }
  }
}
