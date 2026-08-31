

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class F {

  static boolean LOCAL = System.getProperty("ONLINE_JUDGE") == null;
  public static void main(String[] args) throws Exception {
    new F().go();
  }

  Scanner in;
  String INPUT = "7\n" +
      "1\n" +
      "3 413253320\n" +
      "1\n" +
      "1 772368544\n" +
      "1\n" +
      "2 22412126\n" +
      "1\n" +
      "1 548792648\n" +
      "1\n" +
      "2 166750218\n" +
      "1\n" +
      "3 912143029\n" +
      "1\n" +
      "3 739148297";


  void go() {
    if (LOCAL) {
      System.setIn(new ByteArrayInputStream(INPUT.getBytes()));
    }
    in = new Scanner(System.in);
    long startTime = System.currentTimeMillis();
    solve();
    if (LOCAL) {
      System.out.printf("[%dms]", System.currentTimeMillis()-startTime);
    }
    in.close();
  }


  PrintWriter out = new PrintWriter(System.out);
  StringBuffer sb = new StringBuffer();

  void solve() {

    int n = in.nextInt();
    // if (n == 200000) System.out.println(n);

    int maxCards = 0;
    long[] sums = new long[10];

    for (int i = 0; i < n; i++) {
      int k = in.nextInt();
      //      if (n > 5 && k>1) System.out.println(k);

      List<Long> oneCards = new ArrayList<>();
      long twoCard = 0;
      long threeCard = 0;


      for (int j = 0; j < k; j++) {
        int c = in.nextInt();
        long d = in.nextLong();
        // if (n == 200000) System.out.printf("%d %d\n", c, d);

        if (c==1) {
          insertCard(oneCards, d);
        }
        if (c==2) {
          twoCard = Math.max(twoCard, d);
        }
        if (c==3) {
          threeCard = Math.max(threeCard, d);
        }
      }

      int nrCards = 1;
      long[][] cardSums = new long[4][2];

      long biggestCard = Math.max(biggest(oneCards), twoCard);
      biggestCard = Math.max(biggestCard, threeCard);
      cardSums[1][0] = biggestCard;
      cardSums[1][1] = biggestCard * 2;

      int nrOnes = oneCards.size();
      if (nrOnes >= 2 || (nrOnes == 1 && twoCard > 0)) {
        nrCards = 2;
        long high1 = 0;
        long high2 = 0;
        if (twoCard > 0 && twoCard >= secBiggest(oneCards)) {
          high1 = Math.max(biggest(oneCards), twoCard);
          high2 = Math.min(biggest(oneCards), twoCard);
        } else {
          high1 = biggest(oneCards);
          high2 = secBiggest(oneCards);
        }
        cardSums[2][0] = high1 + high2;
        cardSums[2][1] = 2*high1 + high2;
      }

      if (nrOnes == 3) {
        nrCards = 3;
        long h1 = oneCards.get(2);
        long h2 = oneCards.get(1);
        long h3 = oneCards.get(0);
        cardSums[3][0] = h1 + h2 + h3;
        cardSums[3][1] = 2*h1 + h2 + h3;
      }


      maxCards += nrCards;
      maxCards = Math.min(maxCards, 9);
      long[] sums1 = new long[10];
      long[] sums2 = new long[10];
      long[] sums3 = new long[10];

      //always do sums1
      for (int j=1; j <= maxCards; j++) {
        sums1[j] = sums[j-1]+cardSums[1][0];
        if (maxCards == 9) {
          sums1[0] = sums[9]+cardSums[1][1];
        }
      }

      if (nrCards == 2 || nrCards == 3) {
        for (int j=2; j <= maxCards; j++) {
          sums2[j] = sums[j-2]+cardSums[2][0];
          if (maxCards >= 8) {
            sums2[0] = sums[8]+cardSums[2][1];
          }
          if (maxCards == 9) {
            sums2[1] = sums[9]+cardSums[2][1];
          }
        }
      }

      if (nrCards == 3) {
        for (int j=3; j <= maxCards; j++) {
          sums3[j] = sums[j-3]+cardSums[3][0];
          if (maxCards >= 7) {
            sums3[0] = sums[7]+cardSums[3][1];
          }
          if (maxCards >= 8) {
            sums3[1] = sums[8]+cardSums[3][1];
          }
          if (maxCards == 9) {
            sums3[2] = sums[9]+cardSums[3][1];
          }
        }
      }


      for (int j = 0; j <= 9; j++) {
        long largestS = Math.max(sums1[j], sums2[j]);
        largestS = Math.max(largestS, sums3[j]);
        largestS = Math.max(largestS, sums[j]); // also have to take the largest of sums, same as playing 'zero' cards
        sums[j] = largestS;
      }
    }

    // if (n == 200000) showIntegerArray(sums);

    long largest = sums[0];
    for (int i = 1; i <= 9; i++) {
      largest = Math.max(largest, sums[i]);
    }

    System.out.println(largest);


  } // end of solve


  void insertCard(List<Long> oneCards, long damage) {
    if (oneCards.size() == 3 && damage <= oneCards.get(0)) {
      return;
    }
    if (oneCards.size() == 3) {
      oneCards.remove(0);
    }

    int index = 0;
    while (index < oneCards.size() && damage > oneCards.get(index)) {
      ++index;
    }
    oneCards.add(index, damage);
  }

  long biggest(List<Long> oneCards) {
    if (oneCards.size() == 0) {
      return -1;
    }
    return oneCards.get(oneCards.size()-1);
  }

  long secBiggest(List<Long> oneCards) {
    if (oneCards.size() < 2) {
      return -1;
    }
    return oneCards.get(oneCards.size()-2);
  }


  public static void showIntegerArray(long[] a) {
    for (long l : a) {
      System.out.println(l);
    }
  }



}




