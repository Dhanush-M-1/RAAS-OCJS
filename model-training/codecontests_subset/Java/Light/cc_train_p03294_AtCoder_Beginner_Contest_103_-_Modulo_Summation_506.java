import java.util.*;
public class Main{
 public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int N = sc.nextInt();
   int[] ai = new int[N];
   long sum = 0;
   for(int i = 0; i<N;i++) ai[i] = sc.nextInt();
   for(int i = 0; i<N;i++) sum += ai[i];
   System.out.println(sum-N);   
 }
}