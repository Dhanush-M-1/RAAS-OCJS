#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:102400000,102400000")
inline void RI(int &x) {
  char c;
  while ((c = getchar()) < '0' || c > '9')
    ;
  x = c - '0';
  while ((c = getchar()) >= '0' && c <= '9') x = (x << 3) + (x << 1) + c - '0';
}
inline void Out(int a) {
  if (a > 9) Out(a / 10);
  putchar(a % 10 + '0');
}
const int inf = 0x3f3f3f3f;
const double pi = acos(-1.0);
const double dnf = 1e18;
const double eps = 1e-12;
const long long mod = 1000000007;
const int maxn = 200010;
const int maxk = 110;
int n;
int x[maxn], h[maxn], dp[maxn][3];
int main() {
  while (cin >> n) {
    for (int i = 1; i <= n; i++) scanf("%d%d", &x[i], &h[i]);
    memset(dp, -inf, sizeof(dp));
    dp[1][0] = dp[1][1] = dp[1][2] = 1;
    for (int i = 2; i <= n; i++) {
      if (x[i] - h[i] > x[i - 1] + h[i - 1])
        dp[i][0] = max(dp[i][0], dp[i - 1][2] + 1);
      if (x[i] - h[i] > x[i - 1]) {
        dp[i][0] = max(dp[i][0], dp[i - 1][0] + 1);
        dp[i][0] = max(dp[i][0], dp[i - 1][1] + 1);
      }
      if (x[i] > x[i - 1] + h[i - 1]) dp[i][1] = max(dp[i][1], dp[i - 1][2]);
      dp[i][1] = max(dp[i][1], dp[i - 1][0]);
      dp[i][1] = max(dp[i][1], dp[i - 1][1]);
      if (x[i] > x[i - 1] + h[i - 1])
        dp[i][2] = max(dp[i][2], dp[i - 1][2] + 1);
      dp[i][2] = max(dp[i][2], dp[i - 1][0] + 1);
      dp[i][2] = max(dp[i][2], dp[i - 1][1] + 1);
    }
    int ans = 0;
    for (int i = 0; i < 3; i++) ans = max(ans, dp[n][i]);
    cout << ans << endl;
  }
}
