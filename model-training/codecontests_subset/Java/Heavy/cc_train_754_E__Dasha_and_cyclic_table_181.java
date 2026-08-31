import java.util.Scanner;

/**
 * Created by Svilen on 2017-02-26.
 */
public class Ejava {

  static class BitSet {

    int size;
    long[] words;

    BitSet(int size) {
      this.size = size;
      this.words = new long[(size + 63) / 64];
    }

    void setBit(int i) {
      words[i >>> 6] = words[i >>> 6] | (1L << (i & 63));
    }

    void unsetBit(int i) {
      words[i >>> 6] = words[i >>> 6] & ~(1L << (i & 63));
    }

    boolean getBit(int i) {
      return (words[i >>> 6] & ((1L << (i & 63)))) != 0L;
    }

    void shiftRight() {
      long bit0 = words[0] & 1L;
      words[0] = words[0] >>> 1;
      for (int i = 1; i < words.length; ++i) {
        long wordFirstBit = words[i] & 1L;
        words[i] = words[i] >>> 1;
        words[i - 1] = words[i - 1] | (wordFirstBit << 63);
      }
      if (bit0 != 0L) {
        setBit(size - 1);
      }
    }

    void and(BitSet other) {
      for (int i = 0; i < words.length; ++i) {
        words[i] = words[i] & other.words[i];
      }
    }

    void or(BitSet other) {
      for (int i = 0; i < words.length; ++i) {
        words[i] = words[i] | other.words[i];
      }
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("");
      for (int i = 0; i < size; ++i) {
        sb.append(getBit(i) ? '1' : '0');
      }
      return sb.toString();
    }

    BitSet copy() {
      BitSet newBS = new BitSet(0);
      newBS.words = words.clone();
      newBS.size = size;
      return newBS;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int an = sc.nextInt();
    int am = sc.nextInt();
    char[][] a = new char[an][];
    for (int i = 0; i < an; ++i) {
      a[i] = sc.next().toCharArray();
    }
    int tn = sc.nextInt();
    int tm = sc.nextInt();
    char[][] t = new char[tn][];
    for (int i = 0; i < tn; ++i) {
      t[i] = sc.next().toCharArray();
    }

    BitSet[] res = new BitSet[an];
    for (int i = 0; i < an; ++i) {
      res[i] = new BitSet(am);
      for (int j = 0; j < am; ++j) {
        res[i].setBit(j);
      }
    }

    BitSet[][][] H = new BitSet[26][an][am];
    for (int c = 0; c < 26; ++c) {
      for (int i = 0; i < an; ++i) {
        BitSet bs = new BitSet(am);
        for (int j = 0; j < am; ++j) {
          if (a[i][j] - 'a' == c) {
            bs.setBit(j);
          }
        }

        H[c][i][0] = bs;
        for (int shift = 1; shift < am; ++shift) {
          H[c][i][shift] = H[c][i][shift - 1].copy();
          H[c][i][shift].shiftRight();
        }
      }
    }

    for (int r = 0; r < tn; ++r) {
      for (int c = 0; c < tm; ++c) {
        int tc = t[r][c];
        if (tc != '?') {
          BitSet[][] hh = H[tc - 'a'];
          for (int i = 0; i < an; ++i) {
            res[i].and(hh[(i + r) % an][c % am]);
          }
        }
      }
    }

    for (int i = 0; i < an; ++i) {
      System.out.println(res[i]);
    }
  }
}
