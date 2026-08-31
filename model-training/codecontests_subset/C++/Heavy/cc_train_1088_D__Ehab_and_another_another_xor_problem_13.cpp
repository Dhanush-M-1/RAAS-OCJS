#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
int a = 0, b = 0;
int ask(int x, int y) {
  cout << "? " << (a | x) << " " << (b | y) << endl;
  int t;
  cin >> t;
  return t;
}
signed main() {
  ios::sync_with_stdio(false);
  cout.precision(17);
  int s = ask(0, 0);
  for (int i = 29; i >= 0; i--) {
    int t = ask(1 << i, 1 << i);
    if (t == s) {
      if (s >= 0) {
        t = ask(1 << i, 0);
        if (t < 0) {
          a ^= (1 << i);
          b ^= (1 << i);
        }
      } else {
        t = ask(0, 1 << i);
        if (t > 0) {
          a ^= (1 << i);
          b ^= (1 << i);
        }
      }
    } else {
      if (s > 0)
        a ^= (1 << i);
      else
        b ^= (1 << i);
      s = ask(0, 0);
    }
  }
  cout << "! " << a << " " << b << endl;
  ;
  return 0;
}
