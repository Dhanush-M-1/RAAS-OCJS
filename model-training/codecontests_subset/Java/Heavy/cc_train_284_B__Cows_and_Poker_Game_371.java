// package Practice3.CF284;

import java.util.Scanner;

public class CF284A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        int p = s.nextInt();
//        System.out.println(sieveOfEratosthenes(p));

        int n = s.nextInt();
        String str = s.next();
        StringBuilder string1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(str.charAt(i) != 'F'){
                string1.append(str.charAt(i));
            }
        }

        int countA = 0;
        int countI = 0;
        for (int i = 0; i < string1.length() ;i++) {
            if(string1.charAt(i) == 'A'){
                countA++;
            }else{
                countI++;
            }
        }

        if (countA == string1.length()){
            System.out.println(string1.length());
        }else{
            if (countI == 1){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }


}
