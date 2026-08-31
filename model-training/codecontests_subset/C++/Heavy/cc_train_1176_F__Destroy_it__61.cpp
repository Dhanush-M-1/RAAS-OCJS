#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
template <class T>
void read(T &val) {
  T x = 0;
  T bz = 1;
  char c;
  for (c = getchar(); (c < '0' || c > '9') && c != '-'; c = getchar())
    ;
  if (c == '-') {
    bz = -1;
    c = getchar();
  }
  for (; c >= '0' && c <= '9'; c = getchar()) x = x * 10 + c - 48;
  val = x * bz;
}
const int mod = 998244353;
const int maxn = 1e6 + 10;
int n, m, a[maxn], q, t, k;
long long dp[maxn][11];
void mx(long long &x, long long y) {
  if (x < y) x = y;
}
int main() {
  read(n);
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    int k;
    read(k);
    vector<int> c[4];
    for (int j = 1; j <= k; j++) {
      int x, y;
      read(x);
      read(y);
      c[x].push_back(y);
    }
    for (int j = 1; j <= 3; j++) {
      sort(c[j].begin(), c[j].end());
      reverse(c[j].begin(), c[j].end());
    }
    long long d[10][4];
    memset(d, -1, sizeof(d));
    int sz1 = min(int(c[1].size()), 3);
    for (int j = 0; j <= 9; j++) {
      if (dp[i - 1][j] == -1) continue;
      if (sz1 >= 1)
        mx(d[j][1], dp[i - 1][j] + c[1][0] + ((j + 1) > 9 ? c[1][0] : 0));
      if (sz1 >= 2)
        mx(d[j][2],
           dp[i - 1][j] + c[1][0] + c[1][1] + ((j + 2) > 9 ? c[1][0] : 0));
      if (sz1 >= 3)
        mx(d[j][3], dp[i - 1][j] + c[1][0] + c[1][1] + c[1][2] +
                        ((j + 3) > 9 ? c[1][0] : 0));
      if (c[2].size())
        mx(d[j][1], dp[i - 1][j] + c[2][0] + ((j + 1) > 9 ? c[2][0] : 0));
      if (c[3].size())
        mx(d[j][1], dp[i - 1][j] + c[3][0] + ((j + 1) > 9 ? c[3][0] : 0));
      if (sz1 && c[2].size())
        mx(d[j][2], dp[i - 1][j] + c[1][0] + c[2][0] +
                        ((j + 2) > 9 ? max(c[2][0], c[1][0]) : 0));
      mx(d[j][0], dp[i - 1][j]);
    }
    for (int j = 0; j <= 9; j++) {
      if (dp[i - 1][j] == -1) continue;
      for (int k = 0; k <= 3; k++) {
        if (d[j][k] == -1) continue;
        mx(dp[i][(j + k) % 10], d[j][k]);
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i <= 9; i++) mx(ans, dp[n][i]);
  printf("%lld\n", ans);
  return 0;
}
