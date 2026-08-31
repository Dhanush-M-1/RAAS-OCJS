#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
void solve() {}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, k;
  cin >> n >> k;
  vector<long long> times[4];
  vector<long long> sums[4];
  for (long long i = 0; i < n; ++i) {
    long long t, a, b;
    cin >> t >> a >> b;
    times[a * 2 + b].push_back(t);
  }
  for (long long i = 0; i < 4; ++i) {
    sort(times[i].begin(), times[i].end());
    sums[i].push_back(0);
    for (auto it : times[i]) {
      sums[i].push_back(sums[i].back() + it);
    }
  }
  long long ans = INF;
  for (long long cnt = 0; cnt < min(k + 1, (long long)(sums[3].size()));
       ++cnt) {
    if (k - cnt < (long long)(sums[1].size()) &&
        k - cnt < (long long)(sums[2].size())) {
      ans = min(ans, sums[3][cnt] + sums[1][k - cnt] + sums[2][k - cnt]);
    }
  }
  if (ans == INF) ans = -1;
  cout << ans << "\n";
  return 0;
}
