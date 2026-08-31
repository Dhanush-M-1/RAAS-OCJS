#include <bits/stdc++.h>
using namespace std;
int main() {
  long long q, l, r, d;
  cin >> q;
  for (long long i = 0; i < q; i += 1) {
    cin >> l >> r >> d;
    long long ans1 = d;
    if (ans1 > 0 && ans1 < l) {
      cout << ans1 << endl;
      continue;
    }
    long long ans = (r / d) * d;
    ans += d;
    cout << ans << endl;
  }
}
