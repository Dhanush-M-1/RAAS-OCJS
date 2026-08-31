#include <bits/stdc++.h>
#pragma GCC optimize("-O3")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
using namespace std;
const long long MOD = 1e9 + 7;
const long long INF = 1e18;
const double E = 1e-8;
const double pi = acos(-1);
mt19937_64 rnd(time(0));
long long n, m, k, h, T;
long long dp[80][80];
bool tt[80][80];
pair<pair<long long, long long>, long long> a[1001];
long long binpow(long long h, long long r, long long md = MOD) {
  long long l = 1;
  while (r) {
    if (r & 1) l *= h, l %= md;
    h *= h;
    h %= md;
    r /= 2;
  }
  return l;
}
long long gcd(long long x, long long y) {
  if (x < y) swap(x, y);
  while (x && y) {
    x %= y;
    swap(x, y);
  }
  return x + y;
}
bool comp(pair<pair<long long, long long>, long long> x,
          pair<pair<long long, long long>, long long> y) {
  return x.first.second < y.first.second;
}
void solve() {
  cin >> n >> m;
  m = min(n, m);
  for (int i = 1; i <= n; i++) {
    cin >> a[i].first.first >> a[i].first.second;
    a[i].second = i;
  }
  sort(a + 1, a + n + 1, comp);
  for (int i = 0; i <= n; i++)
    for (int j = 0; j <= m; j++) dp[i][j] = -1e18;
  dp[0][0] = 0;
  for (int i = 0; i < n; i++)
    for (int j = 0; j <= m; j++) {
      if (dp[i + 1][j] < dp[i][j] + a[i + 1].first.second * (m - 1)) {
        dp[i + 1][j] =
            max(dp[i + 1][j], dp[i][j] + a[i + 1].first.second * (m - 1));
        tt[i + 1][j] = 0;
      }
      if (j < m && dp[i + 1][j + 1] < dp[i][j] + a[i + 1].first.first +
                                          a[i + 1].first.second * j) {
        dp[i + 1][j + 1] =
            max(dp[i + 1][j + 1],
                dp[i][j] + a[i + 1].first.first + a[i + 1].first.second * j);
        tt[i + 1][j + 1] = 1;
      }
    }
  long long p = m;
  vector<long long> v, v2;
  for (int i = n; i > 0; i--) {
    if (tt[i][p] == 0) {
      v2.push_back(a[i].second);
    } else {
      v.push_back(a[i].second);
      p--;
    }
  }
  reverse(v.begin(), v.end());
  cout << v.size() + v2.size() * 2 << "\n";
  for (int i = 0; i < v.size() - 1; i++) cout << v[i] << " ";
  for (int i = 0; i < v2.size(); i++) cout << v2[i] << " -" << v2[i] << " ";
  cout << v.back();
  cout << "\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
