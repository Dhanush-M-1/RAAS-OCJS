import sun.reflect.generics.tree.Tree;

import javax.lang.model.type.IntersectionType;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String Args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long count = Math.abs(b - a);
        BigInteger bigInteger = (BigInteger.valueOf(0));
        long pred = 0;
        for (int i = 0; i < count / 2; i++) {
            pred = i + 1;
            bigInteger = bigInteger.add(BigInteger.valueOf(pred));
        }
        bigInteger = bigInteger.multiply(BigInteger.valueOf(2));
        bigInteger = bigInteger.add(BigInteger.valueOf((pred + 1) * (count % 2)));
        System.out.println(bigInteger);

    }
}
