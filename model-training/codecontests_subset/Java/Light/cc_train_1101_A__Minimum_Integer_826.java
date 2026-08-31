import java.util.Scanner;

public class CF1101A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();


        for(int i = 0; i < q; i++){
            long l = sc.nextLong();
            long r = sc.nextLong();
            long d = sc.nextLong();

            if(d < l){
                System.out.println(d);
            }else{
                long s = r / d;
                System.out.println(d * (s + 1));
            }
        }
    }
}