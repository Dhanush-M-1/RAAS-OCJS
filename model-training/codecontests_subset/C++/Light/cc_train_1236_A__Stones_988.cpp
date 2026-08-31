#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long t;
  cin >> t;
  while (t--) {
    long long x, y;
    long long a, b, c;
    cin >> a >> b >> c;
    long long maxm = 0;
    for (x = 0; x <= 100; ++x) {
      for (y = 0; y <= 100; ++y) {
        if (b < x + 2 * y) continue;
        if (a < y) continue;
        if (c < 2 * x) continue;
        maxm = max(maxm, 3 * (x + y));
      }
    }
    cout << maxm << endl;
  }
}
