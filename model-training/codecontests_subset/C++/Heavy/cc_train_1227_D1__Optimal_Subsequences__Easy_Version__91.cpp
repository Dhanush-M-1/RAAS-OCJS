#include <bits/stdc++.h>
using namespace std;
const long long int no = 3e6 + 5, modulo = 1e9 + 7, inf = 1e18, N = 3e3 + 1;
long long int ar[no], br[no], cr[no];
void solve() {
  long long int n = 0, m = 0, a = 0, b = 0, c = 0, d = 0, x = 0, y = 0, z = 0,
                w = 0, k = 0;
  cin >> n;
  vector<long long int> vv;
  for (long long int i = 1; i < n + 1; i++) cin >> ar[i], vv.push_back(ar[i]);
  cin >> m;
  sort(vv.rbegin(), vv.rend());
  while (m--) {
    cin >> x >> y;
    a = vv[x - 1];
    vector<long long int> ans, v;
    map<long long int, long long int> mapp;
    for (long long int i = 0; i < x; i++) {
      if (vv[i] > a) v.push_back(vv[i]), mapp[vv[i]]++;
    }
    z = 0;
    for (long long int i = 1; i < n + 1; i++) {
      if (ans.size() == x) break;
      if (ar[i] == a && z < (x - v.size())) {
        ans.push_back(a);
        z++;
      } else if (mapp[ar[i]] > 0) {
        mapp[ar[i]]--;
        ans.push_back(ar[i]);
        if (mapp[ar[i]] == 0) mapp.erase(ar[i]);
      }
    }
    cout << ans[y - 1] << "\n";
  }
}
inline void runn() {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t = 1;
  for (long long int i = 1; i < t + 1; i++) {
    solve();
  }
}
