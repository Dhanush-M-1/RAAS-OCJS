import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void   main (String [] args){
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t--!=0){

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            Integer att [] = new Integer[m];

            String string = scanner.next();

            int res [] = new int[26];

            for(int i=0;i<m;i++){

                att[i] = scanner.nextInt();

            }
            Arrays.sort(att);
           // System.out.println(Arrays.toString(att));
            for (int i=0;i<att[0];i++){
                res[string.charAt(i)-'a']+=m;

            }
            /*for (int i =0;i<26;i++){
                System.out.print(res[i]+" ");

            }
            System.out.println();*/

            for(int i =1;i<m;i++){
                for (int j=att[i-1];j<att[i];j++) {

                    res[string.charAt(j)-'a']+=m-i;
                }

            }
            /*for (int i =0;i<26;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();*/

            for (int i=0;i<string.length();i++){
                res[string.charAt(i)-'a']++;
            }

            for (int i =0;i<26;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
           //   System.out.print("ASDASD");

        }

    }
}