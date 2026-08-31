import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner stdin = new Scanner(new BufferedInputStream(System.in));

        int f = stdin.nextInt();
        int g = stdin.nextInt();

        int dist= Math.abs(f-g);
        int milieu;
        int t;
        if (dist%2==0){

                    if(f<g) {

                         milieu = (dist / 2) + f;
                         t= (milieu-f)*(milieu-f+1);

                    }
                    else {
                        milieu = (dist / 2) + g;
                        t= (milieu-g)*(milieu-g+1);
                    }
        }

        else {

                    if (f < g) {

                        milieu = (dist / 2) + f ;
                        t = ((milieu - f) * (milieu - f + 1) /2) +((g-milieu)*(g-milieu+1)/2);

                    } else {
                        milieu = (dist / 2) + g;
                        t = ((milieu - g) * (milieu - g + 1) /2) +((f-milieu)*(f-milieu+1)/2);
                    }


        }




        System.out.println(t);



    }
}