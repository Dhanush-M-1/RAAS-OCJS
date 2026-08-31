//package MyPackage.kfjf;


import java.util.*;

public class ComplexButNotBoring14ffv {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // Map <Integer,Integer> map=new HashMap <>();
        int freq8 = 0;
        String s = scan.next();
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '8')
                freq8++;
        }
        n = n - freq8;
      //  System.out.println(freq8+" "+n+" ");

        if (freq8 != 0) {
            int count = 0;
            while (n >= 10 && freq8 > 0) {


                freq8--;
                n -= 10;
                count++;
               // System.out.println(freq8+" "+n+" "+count);


            }
            if (n < 10&&n!=0 && freq8 > 1 && (10 - n) <= (freq8 - 1)) {

                count++; freq8--;
                freq8-=(10 - n);
                //System.out.println(freq8+" "+n+" "+count);


                count+=freq8/11;
              //  System.out.println(freq8+" "+n+" "+count);

                System.out.println(count);
                System.exit(0);
            }

            count+=freq8/11;
            //System.out.println(freq8+" "+n+" "+count);

            System.out.println(count);
        } else System.out.println("0");


    }

}