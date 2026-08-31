#include <bits/stdc++.h>
using namespace std;
int main() {
  long long ar, ai, br, bi, cr, ci;
  cin >> ar >> ai >> br >> bi >> cr >> ci;
  complex<long long> a(ar, ai), b(br, bi), c(cr, ci);
  complex<long long> e(1, 0), i(0, 1);
  for (long long alpha = 0; alpha < 4; alpha++, e *= i) {
    complex<long long> n = b - e * a;
    if (norm(c) == 0) {
      if (norm(n) == 0) {
        cout << "YES\n";
        return 0;
      }
    } else {
      complex<long long> d = n / c;
      if (c * d == n) {
        cout << "YES\n";
        return 0;
      }
    }
  }
  cout << "NO\n";
  return 0;
}
