import java.awt.datatransfer.SystemFlavorMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int buttons = sc.nextInt();
        int bulbs = sc.nextInt();

        int[] fr = new int[101];
        int numberOfBulbsOn = 0;


        for (int i = 0; i < buttons; i++) {
            int x = sc.nextInt();
            for (int j = 0; j < x ; j++) {

                int entry = sc.nextInt();
                fr[entry] = 1;

            }

        }



         /*   for (int i = 0; i < fr.length; i++) {
                int[] temp = new int[bulbs];

                temp[i] = sc.nextInt();
                fr[temp[i] - 1] = 1;
                System.out.println(temp[i]);
            }
*/

        for (int i = 0; i < fr.length; i++) {
            numberOfBulbsOn = numberOfBulbsOn + fr[i];
           /* System.out.println(numberOfBulbsOn);
            System.out.println("fr[i] = " + fr[i]);*/




        }

        //System.out.println(numberOfBulbsOn);

        if (numberOfBulbsOn == bulbs) System.out.println("YES");
        else System.out.println("NO");


    }


}
/*


/*
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toLowerCase();
        String wordCap = word.toUpperCase();
        System.out.print(wordCap.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            System.out.print(word.charAt(i));
        }*/

/*
    Scanner sc = new Scanner(System.in);
    String word1 = sc.next().toLowerCase();
    String word2 = sc.next().toLowerCase();
    int word1V = 0 , word2V = 0;

        for (int i = 0; i < word1.length() ; i++) {
        word1V = word1V + word1.charAt(i);
        }

        for (int i = 0; i < word1.length() ; i++) {
        word2V = word2V + word2.charAt(i);
        }



        if ( word1V < word2V) System.out.print(-1);
        else if (word2V<word1V)System.out.print(1);
        else if(word1V == word2V) System.out.print(0);


   */
