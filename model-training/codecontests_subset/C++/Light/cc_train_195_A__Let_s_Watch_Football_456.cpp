#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  while (cin >> a >> b >> c) {
    long long l = 0, r = 100000000;
    while (l <= r) {
      long long t = (l + r) / 2;
      long long w = b * t;
      long long d = b * t;
      bool ok = true;
      while (d < a * c) {
        if (w < a) {
          ok = false;
          break;
        }
        w -= a;
        w += b;
        d += b;
      }
      if (ok)
        r = t - 1;
      else
        l = t + 1;
    }
    cout << l - 1 << endl;
  }
  return 0;
}
