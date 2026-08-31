#include <bits/stdc++.h>
using namespace std;
const long long N = 80;
const long long INF = 1e18 + 239;
long long dp[N][N];
long long wr[N][N];
void init() {
  for (long long i = 0; i < N; i++) {
    for (long long j = 0; j < N; j++) {
      dp[i][j] = -INF;
      wr[i][j] = -1;
    }
  }
  dp[0][0] = 0;
}
void solve(long long n, long long k, vector<long long> a, vector<long long> b,
           vector<long long> tind, long long &ans, vector<long long> &res) {
  vector<long long> ind(n);
  iota(ind.begin(), ind.end(), 0);
  sort(ind.begin(), ind.end(),
       [&](long long i, long long j) { return b[i] < b[j]; });
  init();
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j < n; j++) {
      if (dp[i][j] == -INF) continue;
      if (dp[i + 1][j] < dp[i][j] + (k)*b[ind[i]]) {
        dp[i + 1][j] = dp[i][j] + (k)*b[ind[i]];
        wr[i + 1][j] = 0;
      }
      if (j + 1 <= k) {
        if (dp[i + 1][j + 1] < dp[i][j] + j * b[ind[i]] + a[ind[i]]) {
          dp[i + 1][j + 1] = dp[i][j] + j * b[ind[i]] + a[ind[i]];
          wr[i + 1][j + 1] = 1;
        }
      }
    }
  }
  long long cans = dp[n][k];
  long long wans = k;
  ans = cans;
  res.clear();
  vector<long long> rv(n);
  for (long long i = n; i > 0; i--) {
    rv.push_back(wr[i][wans]);
    if (wr[i][wans] == 1) wans--;
  }
  reverse(rv.begin(), rv.end());
  for (long long i = 0; i < n; i++) {
    if (rv[i] == 1) {
      res.push_back((tind[ind[i]] + 1));
    }
  }
  for (long long i = 0; i < n; i++) {
    if (rv[i] != 1) {
      res.push_back((tind[ind[i]] + 1));
      res.push_back(-(tind[ind[i]] + 1));
    }
  }
}
void solve() {
  long long n, k;
  cin >> n >> k;
  vector<long long> a(n);
  vector<long long> b(n);
  for (long long i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  vector<long long> ind(n);
  iota(ind.begin(), ind.end(), 0);
  sort(ind.begin(), ind.end(),
       [&](long long i, long long j) { return b[i] > b[j]; });
  long long ans = -INF;
  vector<long long> res;
  {
    for (long long rs = 0; rs < n; rs++) {
      vector<long long> na, nb;
      vector<long long> tind;
      for (long long i = 0; i < n; i++) {
        if (i != rs) {
          na.push_back(a[ind[i]]);
          nb.push_back(b[ind[i]]);
          tind.push_back(ind[i]);
        }
      }
      long long tans = -INF;
      vector<long long> tv;
      solve(n - 1, k - 1, na, nb, tind, tans, tv);
      tv.push_back((ind[rs] + 1));
      tans += (k - 1) * b[ind[rs]];
      tans += a[ind[rs]];
      if (tans > ans) {
        ans = tans;
        res = tv;
      }
    }
  }
  cout << res.size() << endl;
  for (auto t : res) {
    cout << t << ' ';
  }
  cout << endl;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long q;
  cin >> q;
  while (q--) {
    solve();
  }
}
