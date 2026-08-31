#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long q;
  cin >> q;
  while (q--) {
    long long a, b, c;
    cin >> a >> b >> c;
    long long ans = 0;
    for (long long i = 0; b > 0 && c > 1; i++) {
      ans += 3;
      b--;
      c -= 2;
    }
    for (long long i = 0; a > 0 && b > 1; i++) {
      ans += 3;
      a--;
      b -= 2;
    }
    cout << ans << endl;
  }
}
