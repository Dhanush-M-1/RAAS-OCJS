#include <bits/stdc++.h>
using namespace std;
const int INF = (1 << 30) + 7;
const int N = 1e5 + 7;
int main() {
  ios::sync_with_stdio(false);
  int q, l, r, d, ans;
  cin >> q;
  while (q--) {
    cin >> l >> r >> d;
    ans = (r / d + 1) * d;
    if (d < l)
      ans = d;
    else
      ans = (r / d + 1) * d;
    cout << ans << endl;
  }
  return 0;
}
