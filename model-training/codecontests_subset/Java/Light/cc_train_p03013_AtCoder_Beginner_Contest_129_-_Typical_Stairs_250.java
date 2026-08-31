import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
        long [] ans = new long [a+1];
        if(b>0){int [] in = new int [b];
        for(int i=0;i<b;i++){
                             in[i] = sc.nextInt();
                            }
		int c = 0;
        long mod = 1000000007;
        ans [0] = 1;
        if(in[c]==1){c++;}
        else{ans[1]=1;}
        for(int i=2;i<=a;i++){if(c<b && in[c]==i){c++;}
                              else{ans[i]=(ans[i-1]+ans[i-2])%mod;}
                             }       
		System.out.println(ans[a]);}
        else{long mod = 1000000007;
        ans [0] = 1;
        ans [1] = 1;
        for(int i=2;i<=a;i++){
                              ans[i]=(ans[i-1]+ans[i-2])%mod;
                             }       
		System.out.println(ans[a]);}
	}
}