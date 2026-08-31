#include <bits/stdc++.h>
using namespace std;
int n, m, T, k, d;
const long long big = 1000000007;
int ask(long long x, long long y) {
  cout << "? " << x << " " << y << "\n";
  fflush(stdout);
  int res;
  cin >> res;
  return res;
}
int main() {
  int a, b, c, e;
  int prev = ask(0, 0);
  a = 0;
  b = 0;
  long long x = 0;
  long long y = 0;
  for (int c1 = 29; c1 >= 0; c1--) {
    if (prev == 0) {
      e = ask(a + (1 << c1), b);
      if (e == -1) {
        x += (1 << c1);
        y += (1 << c1);
        a += (1 << c1);
        b += (1 << c1);
      }
    } else {
      if (prev == 1) {
        e = ask(a + (1 << c1), b + (1 << c1));
        if (e != prev) {
          x += (1 << c1);
          a += (1 << c1);
          prev = ask(a, b);
        } else {
          e = ask(a + (1 << c1), b);
          if (e != prev) {
            x += (1 << c1);
            y += (1 << c1);
            a += (1 << c1);
            b += (1 << c1);
          }
        }
      } else {
        e = ask(a + (1 << c1), b + (1 << c1));
        if (e != prev) {
          y += (1 << c1);
          b += (1 << c1);
          prev = ask(a, b);
        } else {
          e = ask(a, b + (1 << c1));
          if (e != prev) {
            x += (1 << c1);
            y += (1 << c1);
            a += (1 << c1);
            b += (1 << c1);
          }
        }
      }
    }
  }
  cout << "! " << x << " " << y << "\n";
  fflush(stdout);
  return 0;
}
