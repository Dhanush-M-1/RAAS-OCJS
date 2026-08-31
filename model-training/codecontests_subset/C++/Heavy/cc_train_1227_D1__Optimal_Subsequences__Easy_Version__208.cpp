#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e12;
long long a_s, b_s;
vector<long long> best(vector<long long> a, vector<long long> b) {
  a_s = 0;
  b_s = 0;
  bool flaga = true;
  bool flagb = true;
  for (long long i = 0; i < a.size(); ++i)
    if (a[i] < 0) flaga = false;
  for (long long i = 0; i < b.size(); ++i)
    if (b[i] < 0) flagb = false;
  if ((!flaga) && flagb) return b;
  if ((!flagb) && flaga) return a;
  if ((!flaga) && (!flagb)) {
    vector<long long> bad = {};
    for (long long i = 0; i < a.size(); ++i) bad.push_back(-INF);
    return bad;
  }
  for (long long i = 0; i < a.size(); ++i) a_s += a[i];
  for (long long i = 0; i < a.size(); ++i) b_s += b[i];
  if (a_s > b_s) return a;
  if (b_s > a_s) return b;
  for (long long i = 0; i < a.size(); ++i) {
    if (a[i] < b[i]) return a;
    if (b[i] < a[i]) return b;
  }
  return a;
}
signed main() {
  long long n;
  cin >> n;
  vector<long long> a(n);
  for (long long i = 0; i < n; ++i) cin >> a[i];
  long long m;
  cin >> m;
  vector<long long> k(m);
  vector<long long> pos(m);
  for (long long j = 0; j < m; ++j) cin >> k[j] >> pos[j];
  vector<vector<vector<long long>>> dp(
      n + 1, vector<vector<long long>>(n + 1, vector<long long>()));
  dp[0][0] = {};
  for (long long i = 1; i <= n; ++i)
    for (long long j = 0; j < i; ++j) dp[0][i].push_back(-INF);
  for (long long i = 1; i <= n; ++i) {
    for (long long j = 1; j <= n; ++j) {
      vector<long long> dp11 = dp[i - 1][j - 1];
      dp11.push_back(a[i - 1]);
      dp[i][j] = best(dp[i - 1][j], dp11);
    }
  }
  for (long long i = 0; i < m; ++i) cout << dp[n][k[i]][pos[i] - 1] << endl;
  return 0;
}
