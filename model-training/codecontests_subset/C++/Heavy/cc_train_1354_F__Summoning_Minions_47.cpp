#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e9 + 7;
const long long INF = 1LL << 60;
const long long mod = 1e9 + 7;
const long double eps = 1e-8;
const long double pi = acos(-1.0);
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
void solve() {
  long long n, k;
  cin >> n >> k;
  vector<long long> a(n), b(n);
  vector<pair<pair<long long, long long>, long long> > c(n);
  for (long long i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
    c[i] = {{a[i], b[i]}, i};
  }
  sort(c.begin(), c.end(),
       [&](pair<pair<long long, long long>, long long> x,
           pair<pair<long long, long long>, long long> y) {
         return x.first.second < y.first.second;
       });
  static long long dp[80][80];
  for (long long i = 0; i < 80; i++) {
    for (long long j = 0; j < 80; j++) {
      dp[i][j] = -INF;
    }
  }
  dp[0][0] = 0;
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j <= i; ++j) {
      if (dp[i][j] != -INF)
        chmax(dp[i + 1][j + 1],
              dp[i][j] + c[i].first.first + j * c[i].first.second);
      if (dp[i][j] != -INF)
        chmax(dp[i + 1][j], dp[i][j] + (k - 1) * c[i].first.second);
    }
  }
  long long cur = dp[n][k];
  long long p = n, q = k;
  vector<long long> s(n, -1);
  for (long long i = n - 1; i >= 0; --i) {
    if (p - 1 >= 0 && q - 1 >= 0) {
      if (dp[p - 1][q - 1] + c[i].first.first + (q - 1) * c[i].first.second ==
          cur) {
        s[i] = 0;
        p--;
        q--;
        cur = dp[p][q];
        continue;
      }
    }
    if (p - 1 >= 0) {
      if (dp[p - 1][q] + (k - 1) * c[i].first.second == cur) {
        s[i] = 1;
        --p;
        cur = dp[p][q];
      }
    }
  }
  vector<long long> ans, ba;
  long long last = -1;
  for (long long i = 0; i < n; i++) {
    if (s[i] == 0) {
      if ((long long)ans.size() < k - 1)
        ans.push_back(c[i].second + 1);
      else
        last = c[i].second;
    } else {
      ba.push_back(c[i].second + 1);
    }
  }
  for (long long x : ba) {
    ans.push_back(x);
    ans.push_back(-x);
  }
  ans.push_back(last + 1);
  cout << (long long)ans.size() << endl;
  for (long long i = 0; i < (long long)ans.size(); i++) {
    if (i) cout << " ";
    cout << ans[i];
  }
  cout << endl;
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long t;
  cin >> t;
  for (long long i = 0; i < t; i++) solve();
  return 0;
}
