#include <bits/stdc++.h>
using namespace std;
int aa = 12345677;
int bb = 789012;
int ask(int c, int d) {
  if (0) {
    if ((aa ^ c) > (bb ^ d)) return 1;
    if ((aa ^ c) == (bb ^ d)) return 0;
    if ((aa ^ c) < (bb ^ d)) return -1;
  }
  int res;
  cout << "? " << c << ' ' << d << endl;
  cout.flush();
  cin >> res;
  return res;
}
int a, b, r1, r2, r3;
int res[30];
int main() {
  fill(res, res + 30, -1000);
  for (int bit = 29; bit >= 0; bit--) {
    if (res[bit] != -1000) {
      r1 = res[bit];
    } else {
      r1 = ask(a, b);
    }
    if (r1 == 0) {
      for (int i = bit; i >= 0; i--) res[i] = 0;
      r3 = ask((a | (1 << bit)), b);
      if (r3 == 1) {
      } else {
        a |= (1 << bit);
        b |= (1 << bit);
      }
    } else {
      r2 = ask((a | (1 << bit)), (b | (1 << bit)));
      if (r1 == r2) {
        r3 = ask((a | (1 << bit)), b);
        if (r3 == 1) {
        } else {
          a |= (1 << bit);
          b |= (1 << bit);
        }
        if (r1 == 1) {
          if (bit) res[bit - 1] = 1;
        }
        if (r1 == -1) {
          if (bit) res[bit - 1] = -1;
        }
      } else {
        if (r1 == 1 && r2 == -1) {
          a |= (1 << bit);
        }
        if (r1 == -1 && r2 == 1) {
          b |= (1 << bit);
        }
      }
    }
  }
  cout << "! " << a << " " << b << endl;
}
