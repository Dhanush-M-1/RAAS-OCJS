import java.util.*;
public class Main{
  public static Map<Long,Long> map = new HashMap<>();
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong();
    long P = sc.nextLong();
    bunkai(P);
    long ans = 1;
    for(Long n : map.keySet()){
      //System.out.println(n + ":" + map.get(n));
      if(map.get(n) >= N){
        long tmp = map.get(n) / N;
        ans *= pow(n, tmp);
      }
    }
    System.out.println(ans);
  }
  
  public static void bunkai(long n){
    while(n != 1){
      long num = sosuHantei(n);
      long count = 0;
      while(n % num == 0){
        count++;
        n /= num;
      }
      map.put(num, count);
    }
  }
  
  public static long sosuHantei(long n){
    for(long i = 2; i*i <= n; i++){
      if(n % i==0) return i;
    }
    return n;
  }
  
  public static long pow(long x, long y){
    long ans = 1;
    for(long i = 0; i < y; i++){
      ans *= x;
    }
    return ans;
  }
}
