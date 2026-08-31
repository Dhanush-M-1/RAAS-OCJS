
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Singleton {
 

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));




            String string = bufferedReader.readLine();
            List<Integer> list = new ArrayList<>();
            for (String g : string.split(" ")) {
                list.add(Integer.valueOf(g));
            }
            findNumber(list);




      
    }
    public static BigDecimal findNumber(List<Integer> list){
        BigDecimal bigDecimal1;
        BigDecimal bigDecimal2;
        int skip = 10;

        if (list.get(0) == 0 && list.get(1) == 0 && list.get(2) == 0)  {
            System.out.println("-1");
            return null;
        }
        if (list.get(0) == 0 && list.get(1) == 0 && list.get(2) != 0){
            System.out.println("0");
            return null;
        }
        if (list.get(0) != 0 && list.get(1) == 0 && list.get(2) == 0) {
            System.out.println("1");
            System.out.println("0.000000");

            return null;
        }
        if (list.get(0) == 0 && list.get(1) != 0 && list.get(2) == 0) {
            System.out.println("1");
            System.out.println("0.000000");

            return null;
        }
        if (list.get(0) == 0 && list.get(1) != 0 && list.get(2) != 0){
            bigDecimal1 =new BigDecimal((double)-1 * list.get(2)/list.get(1)).setScale(skip,BigDecimal.ROUND_HALF_UP);
            System.out.println("1");
            System.out.println(bigDecimal1);
            return null;
        }
        if (list.get(0) != 0 && list.get(1) == 0 && list.get(2) != 0){
            if ((list.get(0) > 0 && list.get(2) > 0) || (list.get(0) < 0 && list.get(2) < 0)){
                System.out.println("0");
                return null;
            }
            bigDecimal1 = new BigDecimal(-1 * Math.sqrt((double)-1 * list.get(2)/list.get(0)))
                    .setScale(skip,BigDecimal.ROUND_HALF_UP);
            bigDecimal2 = new BigDecimal( Math.sqrt((double)-1 * list.get(2)/list.get(0)))
                    .setScale(skip,BigDecimal.ROUND_HALF_UP);
            System.out.println("2");
            compar(bigDecimal1,bigDecimal2);
            return null;
        }
        if (list.get(2) == 0 && list.get(1) != 0 && list.get(0) != 0){
            bigDecimal1 =new BigDecimal((double)-1 * list.get(1)/list.get(0)).setScale(skip,BigDecimal.ROUND_UNNECESSARY);
            bigDecimal2 =new BigDecimal(0.0).setScale(skip,BigDecimal.ROUND_HALF_UP);
            System.out.println("2");
            compar(bigDecimal1,bigDecimal2);
            return null;
        }

try{





    long Discrim1 = (long)Math.pow(list.get(1),2) - 4 * (long)list.get(0) * (long)list.get(2);
    if (Discrim1 == 0l){
        System.out.println("1");
        System.out.println(new BigDecimal((-1 * list.get(1)) / (2 * list.get(0))).setScale(skip, BigDecimal.ROUND_HALF_UP));
        return null;
    }
    BigDecimal Discrim = new BigDecimal(Math.sqrt(Math.pow(list.get(1),2) - 4 * list.get(0) *
            list.get(2))).setScale(skip, BigDecimal.ROUND_HALF_UP);
    BigDecimal part1 = new BigDecimal(-1 * list.get(1)).setScale(skip, BigDecimal.ROUND_HALF_UP);
    BigDecimal part2 = new BigDecimal((2 * list.get(0))).setScale(skip, BigDecimal.ROUND_HALF_UP);
    bigDecimal1 = new BigDecimal((part1.doubleValue() + Discrim.doubleValue())/(part2.doubleValue()))
            .setScale(skip, BigDecimal.ROUND_HALF_UP);
    bigDecimal2 = new BigDecimal((part1.doubleValue() - Discrim.doubleValue())/(part2.doubleValue()))
            .setScale(skip, BigDecimal.ROUND_HALF_UP);

    if (bigDecimal1.equals(bigDecimal2)){
        System.out.println("1");
        System.out.println(bigDecimal2);
        return null;
    }
    System.out.println("2");
    compar(bigDecimal1,bigDecimal2);

}catch (NumberFormatException e){
    System.out.println("0");
}
    return null;
    }

    public static void compar(BigDecimal bigDecimal1, BigDecimal bigDecimal2){
        if(bigDecimal2.doubleValue() < bigDecimal1.doubleValue()) {
            System.out.println(bigDecimal2);
            System.out.println(bigDecimal1);
        }else{
            System.out.println(bigDecimal1);
            System.out.println(bigDecimal2);

        }
    }
}
