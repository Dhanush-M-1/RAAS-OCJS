import java.util.Scanner;
 
 
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long p = in.nextLong();
        long w = in.nextLong();
        long d = in.nextLong();
        for(long i=0;i<w;i++) {
            if(p>=(i*d)){
                if((p-(i*d))%w==0){
                    if(((p-(i*d))/w)+(i)<=n) {
                        System.out.println(((p-(i*d))/w)+" "+i+" "+(n - (p-i*d)/w - i));
                        return ;
                    }
                }
            }
        }
        System.out.println("-1");
    }
}