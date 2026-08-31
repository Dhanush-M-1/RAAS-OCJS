#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC optimize("Ofast")
using namespace std;
long long n, m, a[300005];
vector<long long> v[300005];
map<long long, long long> viz;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n >> m;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (long long i = 1; i <= m; i++) {
    long long x, y;
    cin >> x >> y;
    v[x].push_back(y);
  }
  long long cnt = 1, ans = 0;
  viz[a[n]] = 1;
  for (long long i = n - 1; i >= 1; i--) {
    long long x = 0;
    for (auto it : v[a[i]]) {
      if (viz[it]) {
        x++;
      }
    }
    if (x < cnt) {
      viz[a[i]] = 1;
      cnt++;
    } else
      ans++;
  }
  cout << ans << '\n';
}
