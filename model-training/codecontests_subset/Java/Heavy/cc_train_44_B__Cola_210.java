//package Contest_44;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
//        Set<String> se = new HashSet<String>();
        int r = 0;
        for(int i = 0; i <= a; i+=2){
            int sum = i/2;
//            System.out.println("here 1 " + sum);
            if(sum>n) break;
            for(int j = 0; j <= b; j++){
                sum = i/2 + j;
//                System.out.println("here 2 " + sum);
                if(sum>n) break;
                if((n-sum)%2!=0) continue;
                int k = (n-sum)/2;
//                System.out.println("here 3 " + k);
                if(k>c) continue;
//                String res = i + " " + j + " " + k;
//                System.out.println("plus 1");
//                se.add(res);
                r++;
            }

        }
        System.out.println(r);
    }
}
