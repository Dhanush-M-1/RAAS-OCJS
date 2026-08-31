#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    long long x = (r) / d;
    if (d >= l)
      cout << (x + 1) * d << endl;
    else
      cout << d << endl;
  }
}
