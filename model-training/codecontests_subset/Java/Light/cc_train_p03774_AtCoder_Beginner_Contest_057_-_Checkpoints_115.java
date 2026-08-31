import java.util.*;
public class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
  int N = sc.nextInt();
  int M = sc.nextInt();
  int[] s = new int[2*N];
  int[] c = new int[2*M];
  for(int i = 0;i < 2*N;i++)s[i] = sc.nextInt();
  for(int i = 0;i < 2*M;i++)c[i] = sc.nextInt();
  for(int i = 0;i < 2*N;i += 2){
    long min = 99999999999l;
    int ans = 0;
    for(int j = 0;j < 2*M;j +=2){
      if(Math.abs(s[i]-c[j])+Math.abs(s[i+1]-c[j+1]) < min){
        min = Math.abs(s[i]-c[j])+Math.abs(s[i+1]-c[j+1]);
        ans = (j/2)+1;
      }
    }
    System.out.println(ans);
  }
}}
