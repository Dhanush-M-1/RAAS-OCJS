#include <bits/stdc++.h>
using namespace std;
const long long M = 1e9 + 7;
long long IM = 1e17;
void PV(vector<long long> v) {
  for (long long i = 0; i < v.size(); i++) cout << v[i] << " ";
  cout << "\n";
}
void PA(long long v[], long long n) {
  for (long long i = 0; i < n; i++) cout << v[i] << " ";
  cout << "\n";
}
void IN(long long a[], long long n) {
  for (long long i = 0; i < n; i++) cin >> a[i];
}
inline void PTN(long long n = 1, long long a = 0, long long b = 0,
                long long c = 0) {
  if (n--) cout << a << " ";
  if (n--) cout << b << " ";
  if (n--) cout << c << " ";
  cout << "\n";
}
inline void open() {}
long long maxx(long long x, long long y, long long z) {
  return max(x, max(y, z));
}
long long dp[100005][3];
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  open();
  {
    long long n;
    cin >> n;
    vector<pair<long long, long long> > v;
    long long i, j, k, l, x, y;
    for (i = 0; i < n; i++) {
      cin >> x >> y;
      v.push_back({x, y});
    }
    v.push_back({IM, IM});
    long long ans = 0;
    dp[0][1] = 1;
    if (v[0].first + v[0].second < v[1].first) dp[0][2] = 1;
    for (i = 1; i < n; i++) {
      dp[i][1] = dp[i - 1][1];
      dp[i][2] = dp[i - 1][2];
      dp[i][0] = maxx(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]);
      if (v[i - 1].first < v[i].first - v[i].second)
        dp[i][1] = max(dp[i][1], dp[i - 1][0]) + 1;
      if (v[i - 1].first + v[i - 1].second < v[i].first - v[i].second)
        dp[i][1] = dp[i][0] + 1;
      if (v[i].first + v[i].second < v[i + 1].first) dp[i][2] = dp[i][0] + 1;
      ans = maxx(dp[i][0], dp[i][1], dp[i][2]);
    }
    ans = max(ans, 1ll);
    cout << ans << "\n";
  }
  return 0;
}
