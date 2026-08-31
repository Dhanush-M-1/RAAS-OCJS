import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long P = sc.nextLong();
        long num = 1;
        long max = 1;
        long pmax = P;
	if(N==1) {
            System.out.println(P);
            return;
        }
        for(long i = 1; num<=P;i++) {
            if(P%num == 0) {
                max = i;
            }
            num = (long)Math.pow(i+1,N);
        }
        System.out.println(max);
    }
}