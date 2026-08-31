#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 7;
const long long M = 15;
const long long xinc[] = {0, 0, 1, -1};
const long long yinc[] = {1, -1, 0, 0};
const long double PI = acos(-1.0);
long long n, dp[N][M], k, c, d;
void comp(long long k, vector<long long>& one, vector<long long>& two,
          vector<long long>& thr, long long& m1, vector<long long>& m2,
          vector<long long>& m3) {
  m1 = -1;
  if (k >= 1) {
    m1 = max(!thr.empty() ? thr[0] : -1, m1);
    m1 = max(!two.empty() ? two[0] : -1, m1);
    m1 = max(!one.empty() ? one[0] : -1, m1);
  }
  if (k >= 2) {
    if (two.size() > 0) {
      vector<long long> tmp;
      tmp.push_back(two[0]);
      if (one.size() >= 1) tmp.push_back(one[0]);
      if (one.size() >= 2) tmp.push_back(one[1]);
      sort((tmp).begin(), (tmp).end(), greater<long long>());
      if (tmp.size() >= 2) m2.push_back(tmp[0]), m2.push_back(tmp[1]);
    } else {
      if (one.size() >= 2) m2.push_back(one[0]), m2.push_back(one[1]);
    }
  }
  if (k >= 3) {
    if (one.size() >= 3) {
      m3.push_back(one[0]), m3.push_back(one[1]), m3.push_back(one[2]);
    }
  }
}
void solve() {
  memset(dp, -1, sizeof dp);
  cin >> n;
  dp[0][0] = 0;
  for (long long i = 1; i <= n; i++) {
    cin >> k;
    vector<long long> v[4], m2, m3;
    for (long long i = 0; i < k; i++) {
      cin >> c >> d;
      v[c].push_back(d);
    }
    for (long long i = 1; i <= 3; i++)
      sort((v[i]).begin(), (v[i]).end(), greater<long long>());
    long long m1;
    comp(k, v[1], v[2], v[3], m1, m2, m3);
    if (m1 != -1) {
      for (long long j = 0; j <= 9; j++)
        if (dp[i - 1][j] != -1) {
          dp[i][(j + 1) % 10] = dp[i - 1][j] + ((j + 1 != 10) ? m1 : 2 * m1);
        }
    }
    if (m2.size() == 2) {
      for (long long j = 0; j <= 9; j++)
        if (dp[i - 1][j] != -1) {
          long long last = dp[i][(j + 2) % 10];
          dp[i][(j + 2) % 10] = dp[i - 1][j] + m2[0] + m2[1];
          if (j + 1 == 10 || j + 2 == 10) dp[i][(j + 2) % 10] += m2[0];
          dp[i][(j + 2) % 10] = max(last, dp[i][(j + 2) % 10]);
        }
    }
    if (m3.size() == 3) {
      for (long long j = 0; j <= 9; j++)
        if (dp[i - 1][j] != -1) {
          long long last = dp[i][(j + 3) % 10];
          dp[i][(j + 3) % 10] = dp[i - 1][j] + m3[0] + m3[1] + m3[2];
          if (j + 1 == 10 || j + 2 == 10 || j + 3 == 10)
            dp[i][(j + 3) % 10] += m3[0];
          dp[i][(j + 3) % 10] = max(last, dp[i][(j + 3) % 10]);
        }
    }
    for (long long j = 0; j <= 9; j++) {
      dp[i][j] = max(dp[i][j], dp[i - 1][j]);
    }
  }
  long long ans = 0;
  for (long long i = 0; i <= 9; i++) ans = max(ans, dp[n][i]);
  cout << ans << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  t = 1;
  while (t--) solve();
  return 0;
}
