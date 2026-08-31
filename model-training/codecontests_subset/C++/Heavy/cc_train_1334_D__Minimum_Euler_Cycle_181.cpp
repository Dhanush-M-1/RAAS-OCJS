#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using PII = pair<int, int>;
using VI = vector<int>;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    ll l, r;
    cin >> n >> l >> r;
    ll pre = 1;
    VI ans;
    for (int s = 1; s < n; s++) {
      ll len = 2 * (n - s);
      if (l < pre + len && r >= pre) {
        for (int i = s + 1; i <= n; i++) {
          if (pre >= l && pre <= r) {
            ans.push_back(s);
          }
          pre++;
          if (pre >= l && pre <= r) {
            ans.push_back(i);
          }
          pre++;
        }
      } else {
        pre += len;
      }
    }
    if (r == n * 1ll * (n - 1) + 1) ans.push_back(1);
    for (int u : ans) cout << u << ' ';
    cout << '\n';
  }
  return 0;
}
