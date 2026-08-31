import java.util.Scanner;

public class Problem519B {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int iterator = n-2;
    long sum=0; 
    long prevSum=0;
    int count=0;
    while(n-- >=iterator) {
      for(int i=1; i<=(n+1); i++) {
        sum = sum + sc.nextLong();
      }
      if(count==0) {
        prevSum = sum;
      } else {
        System.out.println(prevSum-sum);
        prevSum = sum;
      }
      sum =0;
      count++;
    }
    sc.close();
  }
 }