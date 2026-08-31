#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 12;
const long long S = 30;
const double EPS = 1e-12;
const int INF = 1e9 + 10;
const int MOD = 998244353;
const double PI = acos(-1);
vector<map<int, vector<long long> > > a;
long long dp[10][N], z[2][3];
void getZ(int i) {
  for (int j = 0; j < 2; j++)
    for (int k = 0; k < 3; k++) z[j][k] = 0;
  if (a[i][1].size() > 2) {
    for (int j = 0; j < 3; j++) z[0][2] += a[i][1][j];
    for (int j = 0; j < 3; j++)
      if (!j)
        z[1][2] += a[i][1][j] * (long long)2;
      else
        z[1][2] += a[i][1][j];
  }
  if (a[i][1].size() > 0 && a[i][2].size() > 0) {
    z[0][1] = a[i][1][0] + a[i][2][0];
    z[1][1] = max(a[i][1][0], a[i][2][0]) * (long long)2 +
              min(a[i][1][0], a[i][2][0]);
  }
  if (a[i][1].size() > 1) {
    z[0][1] = max(z[0][1], a[i][1][0] + a[i][1][1]);
    z[1][1] = max(z[1][1], a[i][1][0] * (long long)2 + a[i][1][1]);
  }
  if (a[i][2].size() > 0) {
    z[0][0] = max(z[0][0], a[i][2][0]);
    z[1][0] = max(z[1][0], a[i][2][0] * (long long)2);
  }
  if (a[i][1].size() > 0) {
    z[0][0] = max(z[0][0], a[i][1][0]);
    z[1][0] = max(z[1][0], a[i][1][0] * (long long)2);
  }
  if (a[i][3].size() > 0) {
    z[0][0] = max(z[0][0], a[i][3][0]);
    z[1][0] = max(z[1][0], a[i][3][0] * (long long)2);
  }
}
int main() {
  long long t, n, m, c, d;
  cin >> n;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < 10; j++) dp[j][i] = -1;
  for (int i = 0; i < n; i++) {
    cin >> m;
    map<int, vector<long long> > buf;
    for (int j = 0; j < m; j++) {
      cin >> c >> d;
      buf[c].push_back(d);
    }
    sort(buf[1].begin(), buf[1].end());
    reverse(buf[1].begin(), buf[1].end());
    sort(buf[2].begin(), buf[2].end());
    reverse(buf[2].begin(), buf[2].end());
    sort(buf[3].begin(), buf[3].end());
    reverse(buf[3].begin(), buf[3].end());
    a.push_back(buf);
  }
  for (int i = 0; i < n; i++) {
    getZ(i);
    if (!i) {
      dp[0][i] = 0;
      if (z[0][0] > 0) dp[1][i] = z[0][0];
      if (z[0][1] > 0) dp[2][i] = z[0][1];
      if (z[0][2] > 0) dp[3][i] = z[0][2];
      continue;
    }
    for (int j = 0; j < 10; j++) {
      if (dp[j][i - 1] == -1) continue;
      dp[j][i] = max(dp[j][i - 1], dp[j][i]);
      for (int k = 0; k < 3; k++) {
        if (j + k + 1 < 10 && z[0][k] > 0)
          dp[(j + k + 1) % 10][i] =
              max(dp[(j + k + 1) % 10][i], dp[j][i - 1] + z[0][k]);
        if (j + k + 1 >= 10 && z[1][k] > 0)
          dp[(j + k + 1) % 10][i] =
              max(dp[(j + k + 1) % 10][i], dp[j][i - 1] + z[1][k]);
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; i++) ans = max(ans, dp[i][n - 1]);
  cout << ans << endl;
}
