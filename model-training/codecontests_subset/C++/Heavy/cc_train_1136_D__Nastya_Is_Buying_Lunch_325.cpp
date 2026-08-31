#include <bits/stdc++.h>
using namespace std;
long long n, m;
long long a[3000001], pos[3000003], dp[3000003];
long long x[3000001], y[3000003];
vector<vector<long long> > v;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m;
  v.resize(n);
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    pos[a[i]] = i;
  }
  for (long long i = 0; i < m; i++) {
    cin >> x[i] >> y[i];
    x[i] = pos[x[i]];
    y[i] = pos[y[i]];
    if (y[i] > x[i]) v[y[i]].push_back(x[i]);
  }
  long long ans = 0, kol = 0;
  for (long long i = n - 1; i >= 0; i--) {
    if (dp[i] == kol && i != n - 1) {
      ans++;
    } else {
      kol++;
      for (auto u : v[i])
        if (u < i) dp[u]++;
    }
  }
  cout << ans;
}
