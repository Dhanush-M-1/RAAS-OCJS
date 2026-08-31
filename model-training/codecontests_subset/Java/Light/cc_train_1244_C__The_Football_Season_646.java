import java.util.Scanner;

public class FootBall1244C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();
        long p = in.nextLong();
        long w = in.nextLong();
        long d = in.nextLong();

        for( int i = 0; i <= w; i++ ) {

            long t = p - d * i;
            if ( t % w != 0 ) {
                continue;
            }

            if ( t < 0 ) {
                continue;
            }

            long x = t/w;

            if (x + i > n){
                continue;
            }

            long z = n - x - i;

            System.out.println(x + " " + i + " " + z);
            return;
        }

        System.out.println(-1);

    }
}

  	 	 			 		   		 	  		 		