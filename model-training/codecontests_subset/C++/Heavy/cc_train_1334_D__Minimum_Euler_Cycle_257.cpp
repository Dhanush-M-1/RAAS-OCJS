#include <bits/stdc++.h>
using ll = int64_t;
using namespace std;
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  cout << fixed << setprecision(20);
  ll T, n, l, r;
  cin >> T;
  for (int _ = 0, _Len = (T); _ < _Len; ++_) {
    cin >> n >> l >> r;
    ll index = 1;
    for (int i = 1, iLen = (n + 1); i < iLen; ++i) {
      if (index + (n - i) * 2 < l) {
        index += (n - i) * 2;
        continue;
      }
      for (int j = i + 1, jLen = (n + 1); j < jLen; ++j) {
        if (l <= index && index <= r) cout << i << (index < r ? " " : "\n");
        index++;
        if (l <= index && index <= r) cout << j << (index < r ? " " : "\n");
        index++;
        if (r < index) break;
      }
      if (r < index) break;
    }
    if (index == r) cout << 1 << "\n";
  }
}
