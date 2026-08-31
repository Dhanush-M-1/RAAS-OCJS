import java.util.Scanner;
import java.lang.Math;

public class Cincopontecial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        double r=Math.pow(10, 18);
        double s=2*Math.pow(10, 18);
        if (n >500)
        {
            System.out.println("25");
        } else {
            double res = Math.pow(5, n);
            //Long res2 = (new Double(res)).longValue();; 
            String cadena = String.valueOf((int)res);
            String cadena2 = cadena.substring(cadena.length() - 2);
            System.out.println(cadena2);
        }

    }

}