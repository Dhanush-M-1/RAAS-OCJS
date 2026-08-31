
/**
 * Write a description of class Basic here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;

public class A_Problems
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Pair Of Toys:
        //System.out.println("First enter the mount of toys, then the cost.");
        /*long n = input.nextLong();
        long k = input.nextLong();
        long combos = pairOfToys(n, k);
        System.out.println(combos);*/
        
        //The Rank
        /*
        ArrayList<Integer> ar= new ArrayList<Integer>();
        int students = input.nextInt() - 1;
        int thomas = input.nextInt() + input.nextInt() + input.nextInt() + input.nextInt();
        for (int i = 0; i < students; i++) {
            ar.add(input.nextInt() + input.nextInt() + input.nextInt() + input.nextInt());
        }
        System.out.println(theRank(ar, thomas));*/
        
        //Tricky Alchemy
        /*System.out.println(trickyAlchemy(input.nextLong(), input.nextLong(),
            input.nextLong(), input.nextLong(), input.nextLong()));
        */
       
        //Modular Exponentiation
        //System.out.println(modularExponentiation(input.nextLong(), input.nextLong()));
        
        //Garden
        int n = input.nextInt();
        int k = input.nextInt();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            ar.add(input.nextInt());
        }
        System.out.println(garden(n, k, ar));
        
        
        
        
        input.close();
    }

    public static long pairOfToys(long n, long k) {
        long combos;
        long x;
        if (2*n-1 < k) {
            combos = 0;
        }
        else {
            if (k <= n) {
                x = k;
            }
            else {
                x = 2*n-k+2;
            }
            if (x%2 == 0) {
                combos = x/2 - 1;
            }
            else {
                combos = (x - 1) / 2;
            }
        }

        return combos;
    }
    
    public static int theRank(ArrayList<Integer> ar, int thomas) {
        int rank = 1;
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i) > thomas) {
                rank ++;
            }
        }
        return rank;
    }
    
    public static long trickyAlchemy(long yellowC, long blueC, long yellowB, long greenB, long blueB) {
        long missingC = 0;
        long neededBC = greenB + 3*blueB;
        long neededYC = greenB + 2*yellowB;
        
        if (neededBC > blueC) {
            missingC += (neededBC - blueC);
        }
        if (neededYC > yellowC) {
            missingC += (neededYC - yellowC);
        }
        
        return missingC;
    }
    
    public static long modularExponentiation(long n, long m) {
        long answer = 0;
        if (m > n) {
            long n2 = n;
            long x = 1;
            while (m >= x) {
                x *= 2;
                n2--;
                if (n2 == 0) {
                    answer = m % x;
                    break;
                }
            }
            if (n2 != 0) {
                answer = m;
            }
        }
        else {
            answer = m;
        }

        return answer;
    }
    
    public static int garden(int n, int k, ArrayList<Integer> ar) {
        int minHours = 100;
        ArrayList<Integer> acc = new ArrayList<Integer>();
        for (int i = 0; i < ar.size(); i++) {
            if (k % ar.get(i) == 0) {
                acc.add(ar.get(i));
            }
        }
        
        for (int i = 0; i < acc.size(); i++) {
            if (k/acc.get(i) < minHours) {
                minHours = k/acc.get(i);
            }
        }
        
        return minHours;
    }
}