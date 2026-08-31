import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    static BigDecimal pow(BigDecimal a, BigDecimal b) {
        double bDouble = b.doubleValue();
        int integerPortion = (int) bDouble;
        double fractionalPortion = bDouble - integerPortion;
        BigDecimal aToIntegerPortion = a.pow(integerPortion);
        BigDecimal aToFractionalPortion = new BigDecimal(Math.pow(a.doubleValue(), fractionalPortion));
        return aToIntegerPortion.multiply(aToFractionalPortion);
    }
    
    static BigDecimal log(BigDecimal value) {
        return new BigDecimal(Math.log(value.doubleValue()));
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal x = new BigDecimal(sc.next());
        BigDecimal y = new BigDecimal(sc.next());
        BigDecimal z = new BigDecimal(sc.next());
        sc.close();
        
        BigDecimal[] logValues = {
                pow(y, z).multiply(log(x)),
                pow(z, y).multiply(log(x)),
                z.multiply(y).multiply(log(x)),
                y.multiply(z).multiply(log(x)),
                pow(x, z).multiply(log(y)),
                pow(z, x).multiply(log(y)),
                z.multiply(x).multiply(log(y)),
                x.multiply(z).multiply(log(y)),
                pow(x, y).multiply(log(z)),
                pow(y, x).multiply(log(z)),
                y.multiply(x).multiply(log(z)),
                x.multiply(y).multiply(log(z))
        };
        
        int greatestIndex = 0;
        for (int i = 1; i < logValues.length; i++) {
            if (logValues[i].compareTo(logValues[greatestIndex]) > 0) greatestIndex = i;
        }
        
        String[] valueRepresentations = {
                "x^y^z",
                "x^z^y",
                "(x^y)^z",
                "(x^z)^y",
                "y^x^z",
                "y^z^x",
                "(y^x)^z",
                "(y^z)^x",
                "z^x^y",
                "z^y^x",
                "(z^x)^y",
                "(z^y)^x"
        };
        
        System.out.print(valueRepresentations[greatestIndex]);
    }
}

                                                        