import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int [] A = new int [a];
        int [] C = new int [a-1];
        for(int i=0;i<a;i++){A[i] = sc.nextInt();
                            }
		int ans = 0;
        for(int i=0;i<a;i++){int b = sc.nextInt();
                             ans+=b;
                            }
        for(int i=0;i<a-1;i++){C[i] = sc.nextInt();
                              }
         for(int i=0;i<a-1;i++){if(A[i+1]==A[i]+1){ans+=C[A[i]-1];}
                            }
		System.out.println(ans);
	}
}
