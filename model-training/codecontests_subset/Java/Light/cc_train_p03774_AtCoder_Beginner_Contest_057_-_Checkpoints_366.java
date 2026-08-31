import java.util.*;
import java.lang.Math;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
  		
      	int n = sc.nextInt();
      	int m = sc.nextInt();
      	int as[] = new int[n];
      	int bs[] = new int[n];
      	int cs[] = new int[m];
      	int ds[] = new int[m];
      	int ans[] = new int[n];
      	int min;
      	int istack;
      	
      	for(int i = 0;i < n;i++){
          as[i] = sc.nextInt();
          bs[i] = sc.nextInt();
        }
      	for(int i = 0;i < m;i++){
          cs[i] = sc.nextInt();
          ds[i] = sc.nextInt();
        }
      	for(int i = 0;i < n;i++){
          min = Math.abs(as[i]-cs[0]) + Math.abs(bs[i]-ds[0]);
          ans[i] = 0;
          for(int j = 1;j < m;j++){
          	istack = Math.abs(as[i]-cs[j]) + Math.abs(bs[i]-ds[j]);
            if(istack < min){
              min = istack;
              ans[i] = j;
            }
          }
        }
      	
      	for(int i = 0;i < n;i++) System.out.println(ans[i] + 1);
        
	}
}
