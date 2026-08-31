#include <bits/stdc++.h>
using namespace std;
int a, b, c, d, st, ed, tp, i;
int main() {
  a = b = c = d = 0;
  cout << "? " << a << " " << b << endl;
  fflush(stdout);
  cin >> st;
  for (i = 29; i >= 0; i--) {
    if (st == 0) {
      cout << "? " << (a ^ (1 << i)) << " " << b << endl;
      fflush(stdout);
      cin >> tp;
      if (tp < 0) {
        c += (1 << i);
        d += (1 << i);
      }
    } else {
      cout << "? " << (a ^ (1 << i)) << " " << (b ^ (1 << i)) << endl;
      fflush(stdout);
      cin >> ed;
      if (st < 0) {
        if (ed > 0) {
          d += (1 << i);
          a += (1 << i);
          cout << "? " << a << " " << b << endl;
          fflush(stdout);
          cin >> st;
        } else {
          cout << "? " << a << " " << (b ^ (1 << i)) << endl;
          fflush(stdout);
          cin >> tp;
          if (tp != ed) {
            c += (1 << i);
            d += (1 << i);
          }
        }
      } else {
        if (ed < 0) {
          c += (1 << i);
          b += (1 << i);
          cout << "? " << a << " " << b << endl;
          fflush(stdout);
          cin >> st;
        } else {
          cout << "? " << (a ^ (1 << i)) << " " << b << endl;
          fflush(stdout);
          cin >> tp;
          if (tp != ed) {
            c += (1 << i);
            d += (1 << i);
          }
        }
      }
    }
  }
  cout << "! " << c << " " << d << endl;
  fflush(stdout);
}
