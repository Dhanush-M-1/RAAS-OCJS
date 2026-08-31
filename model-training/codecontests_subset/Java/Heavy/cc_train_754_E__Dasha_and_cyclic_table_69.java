import java.util.Scanner;

public class Ejava {

/**
 * CodeForces
 * Codeforces Round #390 (Div. 2)
 * http://codeforces.com/contest/754
 * http://codeforces.com/contest/754/problem/E
 * E - Dasha and cyclic table
 *
 * Status: Accepted
 * Submission: http://codeforces.com/contest/754/submission/25065875
 * Date: 2017-02-26
 * Author: Svilen Marchev
 * Tags: brute force, cyclic tables, matrices, bit sets, optimization
 *
 * Complexity: O(N^4 / 64)
 * Niceness: 5/10
 * Analysis: http://codeforces.com/blog/entry/49637 (similar solution)
 */

/*
Svilen's Analysis:
-----------------------
Start from the very first, naive approach and start transforming it with the goal of having
bitwise matrix AND operations in the inner-most loop. Then we can optimize those bitwise operations
with bit sets.

The evolution of the solution can start from the naive O(N^4) solution:

    val res = Array(an, { BooleanArray(am, { true }) })
    for (i in 0 until an) {
      for (j in 0 until am) {
        for (r in 0 until tn) {
          for (c in 0 until tm) {
            if (t[r][c] != '?') {
              res[i][j] = res[i][j] && t[r][c] == a[(i + r) % an][(j + c) % am]
            }
          }
        }
      }
    }

Then move the second pair of for-loops as outer loops to avoid the complication of the if-statement:

    for (r in 0 until tn) {
      for (c in 0 until tm) {
        val tc = t[r][c]
        if (tc != '?') {
          for (i in 0 until an) {
            for (j in 0 until am) {
              res[i][j] = res[i][j] && tc == a[(i + r) % an][(j + c) % am]
            }
          }
        }
      }
    }

Now let's define a new function:
  H: 26 x N x M -> {true, false}
  H(c, i, j) = true  <=>  A[i][j] = c, where c is a letter in [a..z], and A is the matrix we are
searching into

    val H = Array(26, { c -> Array(an, { i -> BooleanArray(am, { j -> a[i][j] - 'a' == c }) }) })
    for (r in 0 until tn) {
      for (c in 0 until tm) {
        val tc = t[r][c]
        if (tc != '?') {
          for (i in 0 until an) {
            for (j in 0 until am) {
              res[i][j] = res[i][j] && H[tc - 'a'][(i + r) % an][(j + c) % am]
            }
          }
        }
      }
    }

Now let's define a new function, which is a "shift" of H:
  G: 26 x N x M x M -> {true, false}
  H(c, i, shiftJ, j) = true  <=> G(c, i, (j+shiftJ) mod M) = true
With it, we can cleanly express the operation in the inner-loop:

    val G = ...
    for (r in 0 until tn) {
      for (c in 0 until tm) {
        val tc = t[r][c]
        if (tc != '?') {
          for (i in 0 until an) {
            for (j in 0 until am) {
              res[i][j] = res[i][j] && G[tc - 'a'][(i + r) % an][c % am][j]
            }
          }
        }
      }
    }

Now we can complete remove the inner loop by using bit sets for res and G:

    val res = Array(an, { BitSet(m) })
    res.fill(1)
    val G = Array(26, { Array(an, { Array(am, { BitSet(am) }) }) })
    // Compute G efficiently using bitwise right shifts: see code for details

    for (r in 0 until tn) {
      for (c in 0 until tm) {
        val tc = t[r][c]
        if (tc != '?') {
          for (i in 0 until an) {
            res[i] = res[i] and G[tc - 'a'][(i + r) % an][c % am]
          }
        }
      }
    }

Time complexity: O(N^4 / 64).
*/

  static class BitSet {

    int size;
    long[] words;

    BitSet(int size) {
      this.size = size;
      this.words = new long[(size + 63) / 64];
    }

    void setBit(int i) {
      words[i >>> 6] |= 1L << (i & 63);
    }

    void unsetBit(int i) {
      words[i >>> 6] &= ~(1L << (i & 63));
    }

    boolean getBit(int i) {
      return (words[i >>> 6] & (1L << (i & 63))) != 0L;
    }

    void shiftRight() {
      long bit0 = words[0] & 1L;
      words[0] >>>= 1;
      for (int i = 1; i < words.length; ++i) {
        long wordFirstBit = words[i] & 1L;
        words[i] >>>= 1;
        words[i - 1] |= wordFirstBit << 63;
      }
      if (bit0 != 0L) {
        setBit(size - 1);
      }
    }

    void and(BitSet other) {
      for (int i = 0; i < words.length; ++i) {
        words[i] &= other.words[i];
      }
    }

    void or(BitSet other) {
      for (int i = 0; i < words.length; ++i) {
        words[i] |= other.words[i];
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
