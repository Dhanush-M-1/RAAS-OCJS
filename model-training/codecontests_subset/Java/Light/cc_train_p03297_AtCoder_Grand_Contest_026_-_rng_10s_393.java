
import java.io.*;
import java.util.*;

public class Main {
    public static long gcd(long B,long D){
        if(B<D)
            return gcd(D,B);
        if(B%D==0)
            return D;
        return gcd(D,B%D);
    }
    public static void main(String arg[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            long D = Long.parseLong(st.nextToken());
            
            if(B>A){
                System.out.println("No");
            }else if(B>D){
                System.out.println("No");
            }else if(B==D){
                if(C>=B){
                    System.out.println("Yes");
                }else{
                    long r = A%B;
                    if(r<=C){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }
            }else{
                long g = gcd(B,D);
                long r = A % B;
                if (r > C) {
                    System.out.println("No");
                }else if(C<B-g){
                    System.out.println("No");
                }else if(D%C==0){
                    System.out.println("Yes");
                }else{
                    System.out.println("Yes");
                }
            }
        }
    }
}
