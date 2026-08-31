#include <bits/stdc++.h>
using namespace std;
int main() {
  int TESTS = 1;
  while (TESTS--) {
    long long i, j, k, l, m, n, c, d, v[31] = {0}, a, b;
    c = pow(2, 30) - 1;
    d = pow(2, 30) - 1;
    cout << "? " << c << " " << d << '\n';
    fflush(stdout);
    cin >> k;
    j = k * (-1);
    a = 0;
    b = 0;
    c = 0;
    d = 0;
    for (m = 29; m >= 0; m--) {
      c = c + pow(2, m);
      d = d + pow(2, m);
      cout << "? " << c << " " << d << '\n';
      fflush(stdout);
      cin >> k;
      if (k == 0) break;
      if (k != j && k != 0) {
        v[m] = 1;
        if (j == 1) {
          a = a + pow(2, m);
          c = c - pow(2, m);
        } else {
          b = b + pow(2, m);
          d -= pow(2, m);
        }
        cout << "? " << c << " " << d << '\n';
        fflush(stdout);
        cin >> k;
        j = k;
      }
    }
    c = a;
    d = b;
    for (i = 0; i <= 29; i++) {
      if (v[i] == 1) continue;
      c += pow(2, i);
      cout << "? " << c << " " << d << '\n';
      fflush(stdout);
      cin >> k;
      if (k == -1) {
        a += pow(2, i);
        b += pow(2, i);
      }
      c -= pow(2, i);
    }
    cout << "! " << a << " " << b << '\n';
    fflush(stdout);
  }
  return 0;
}
