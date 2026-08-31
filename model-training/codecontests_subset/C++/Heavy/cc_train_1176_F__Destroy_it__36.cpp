#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int _inf = 0xc0c0c0c0;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const long long _INF = 0xc0c0c0c0c0c0c0c0;
const long long mod = (int)1e9 + 7;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long ksm(long long a, long long b, long long mod) {
  int ans = 1;
  while (b) {
    if (b & 1) ans = (ans * a) % mod;
    a = (a * a) % mod;
    b >>= 1;
  }
  return ans;
}
long long inv2(long long a, long long mod) { return ksm(a, mod - 2, mod); }
void exgcd(long long a, long long b, long long &x, long long &y, long long &d) {
  if (!b) {
    d = a;
    x = 1;
    y = 0;
  } else {
    exgcd(b, a % b, y, x, d);
    y -= x * (a / b);
  }
}
const int MAX_N = 200025;
long long dp[MAX_N][10];
priority_queue<long long> q[15];
long long k[200025], tmp[15], maxx[15];
int main() {
  int n;
  scanf("%d", &n);
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    int c, d;
    while (!q[1].empty()) q[1].pop();
    while (!q[2].empty()) q[2].pop();
    while (!q[3].empty()) q[3].pop();
    scanf("%d", &k[i]);
    for (int j = 1; j <= k[i]; ++j) {
      scanf("%d%d", &c, &d);
      q[c].push(d);
    }
    for (int j = 0; j < 10; ++j) dp[i][j] = dp[i - 1][j];
    for (int j = 1; j <= 6; ++j) tmp[j] = -inf;
    if (!q[1].empty()) tmp[1] = q[1].top();
    if (!q[2].empty()) tmp[2] = q[2].top();
    if (!q[3].empty()) tmp[3] = q[3].top();
    if (q[1].size() >= 2) {
      long long now = q[1].top();
      q[1].pop();
      tmp[4] = q[1].top() + now;
      maxx[4] = max(q[1].top(), now);
      q[1].push(now);
    }
    if (!q[1].empty() && !q[2].empty()) {
      maxx[5] = max(q[1].top(), q[2].top());
      tmp[5] = q[1].top() + q[2].top();
    }
    if (q[1].size() >= 3) {
      maxx[6] = 0;
      tmp[6] = q[1].top();
      maxx[6] = max(maxx[6], q[1].top());
      q[1].pop();
      tmp[6] += q[1].top();
      maxx[6] = max(maxx[6], q[1].top());
      q[1].pop();
      tmp[6] += q[1].top();
      maxx[6] = max(maxx[6], q[1].top());
      q[1].pop();
    }
    if (tmp[1] != -inf) {
      for (int j = 1; j <= 9; ++j)
        if (dp[i - 1][j - 1] != -1)
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + tmp[1]);
      if (dp[i - 1][9] != -1)
        dp[i][0] = max(dp[i][0], dp[i - 1][9] + tmp[1] * 2);
    }
    if (tmp[2] != -inf) {
      for (int j = 1; j <= 9; ++j)
        if (dp[i - 1][j - 1] != -1)
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + tmp[2]);
      if (dp[i - 1][9] != -1)
        dp[i][0] = max(dp[i][0], dp[i - 1][9] + tmp[2] * 2);
    }
    if (tmp[3] != -inf) {
      for (int j = 1; j <= 9; ++j)
        if (dp[i - 1][j - 1] != -1)
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + tmp[3]);
      if (dp[i - 1][9] != -1)
        dp[i][0] = max(dp[i][0], dp[i - 1][9] + tmp[3] * 2);
    }
    if (tmp[4] != -inf) {
      for (int j = 2; j <= 9; ++j)
        if (dp[i - 1][j - 2] != -1)
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 2] + tmp[4]);
      if (dp[i - 1][9] != -1)
        dp[i][1] = max(dp[i][1], dp[i - 1][9] + tmp[4] + maxx[4]);
      if (dp[i - 1][8] != -1)
        dp[i][0] = max(dp[i][0], dp[i - 1][8] + tmp[4] + maxx[4]);
    }
    if (tmp[5] != -inf) {
      for (int j = 2; j <= 9; ++j)
        if (dp[i - 1][j - 2] != -1)
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 2] + tmp[5]);
      if (dp[i - 1][9] != -1)
        dp[i][1] = max(dp[i][1], dp[i - 1][9] + tmp[5] + maxx[5]);
      if (dp[i - 1][8] != -1)
        dp[i][0] = max(dp[i][0], dp[i - 1][8] + tmp[5] + maxx[5]);
    }
    if (tmp[6] != -inf) {
      for (int j = 3; j <= 9; ++j)
        if (dp[i - 1][j - 3] != -1)
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 3] + tmp[6]);
      if (dp[i - 1][9] != -1)
        dp[i][2] = max(dp[i][2], dp[i - 1][9] + tmp[6] + maxx[6]);
      if (dp[i - 1][8] != -1)
        dp[i][1] = max(dp[i][1], dp[i - 1][8] + tmp[6] + maxx[6]);
      if (dp[i - 1][7] != -1)
        dp[i][0] = max(dp[i][0], dp[i - 1][7] + tmp[6] + maxx[6]);
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; ++i) ans = max(ans, dp[n][i]);
  printf("%lld\n", ans);
  return 0;
}
