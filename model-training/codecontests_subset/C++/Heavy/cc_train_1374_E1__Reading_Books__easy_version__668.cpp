#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const ll inf = 1e18;
const int N = 2 * 1e5 + 10;
ll res, n, k;
void solve() {
  ll tt, x, y;
  std::vector<ll> v, vv, vvv;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> tt >> x >> y;
    if (y == 1 && x == 1)
      v.push_back(tt);
    else if (y)
      vv.push_back(tt);
    else if (x)
      vvv.push_back(tt);
  }
  sort(vv.begin(), vv.end());
  sort(vvv.begin(), vvv.end());
  for (int i = 0; i < min((int)vv.size(), (int)vvv.size()); i++) {
    v.push_back(vv[i] + vvv[i]);
  }
  sort(v.begin(), v.end());
  if (v.size() < k) {
    cout << "-1\n";
    return;
  }
  ll ans = 0;
  for (int i = 0; i < k; i++) ans += v[i];
  cout << ans << "\n";
}
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  ll t = 1;
  while (t--) {
    solve();
  }
}
