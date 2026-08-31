
import java.io.File;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Class1 {
    

    String solution;
    int num;
    char[] ca, cb, cc;
    
    public static void main(String[] args) {
        
        Scanner console=new Scanner(System.in);
        //try {
        //console=new Scanner(new File("c:/temp/input.txt"));
        //} catch (Exception e) {
        //    System.exit(-1);
        //}

        new Class1(console);
      
    }
    

    public Class1(Scanner console) {
        
        String a = console.nextLine();
        String b = console.nextLine();
        String c = console.nextLine();

        char [] ca = a.toCharArray();
        char [] cb = b.toCharArray();
        char [] cc = c.toCharArray();
        
        int[] numLA = new int[26];
        for (int i = 0; i < ca.length; i++) {
            //numLA[a.charAt(i)-'a']++;
            numLA[ca[i]-'a']++;
        }

        int[] numLB = new int[26];
        for (int i = 0; i < cb.length; i++) {
            numLB[cb[i]-'a']++;
        }

        int[] numLC = new int[26];
        for (int i = 0; i < cc.length; i++) {
            numLC[cc[i]-'a']++;
        }


        // calc max b
        int maxB = 1000000000;
        for (int i = 0; i < 26; i++) {
            if (numLB[i] > 0) {
                if (numLA[i]/numLB[i] < maxB) maxB = numLA[i]/numLB[i];
            }
        }

        int chosenB = 0;
        int chosenC = 0;
        for (int i = 0; i <= maxB; i++) {
            int maxC = 1000000000;
            for (int j = 0; j < 26; j++) {
                if (numLC[j] > 0) {
                    if ((numLA[j]-i*numLB[j])/numLC[j] < maxC) maxC = (numLA[j]-i*numLB[j])/numLC[j];
                }
            }
            if (i + maxC > chosenB + chosenC) {
                chosenB = i;
                chosenC = maxC;
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < chosenB; i++) {
            output = output.append(b);
        }
        for (int i = 0; i < chosenC; i++) {
            output = output.append(c);
        }

        for (int i = 0; i < 26; i++) {
            
            char[] chars = new char[100002];
            Arrays.fill(chars, (char)((char)'a'+(char)i));
            int reps = numLA[i] - chosenB*numLB[i] - chosenC*numLC[i];
            output.append(chars, 0, reps);

        }


        System.out.println(output);
    }


}