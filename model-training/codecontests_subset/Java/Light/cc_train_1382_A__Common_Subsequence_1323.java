import com.sun.source.tree.Tree;

import javax.naming.spi.DirObjectFactory;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.file.LinkOption;
import java.util.*;


public class Main {











    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);


        try (PrintWriter or = new PrintWriter(System.out)) {

                int t = in.nextInt();
                outer:
                while (t-->0){


                  int n=in.nextInt();
                 int m =in.nextInt();
                 HashSet<Integer>set= new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        set.add(in.nextInt());
                    }
                    int ans=-1;
                    for (int i = 0; i < m; i++) {
                        int y =in.nextInt();
                        if (set.contains(y)){
                           ans=y;
                        }
                    }
                    or.println(ans!=-1?"YES\n1 "+ans:"NO");






                }




        }


    }
    static long  gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

}


