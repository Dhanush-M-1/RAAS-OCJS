#include <bits/stdc++.h>
using namespace std;
const int N = 1e6;
inline int getint() {
  int w = 0, q = 0;
  char c = getchar();
  while ((c < '0' || c > '9') && c != '-') c = getchar();
  if (c == '-') q = 1, c = getchar();
  while (c >= '0' && c <= '9') w = w * 10 + c - '0', c = getchar();
  return q ? -w : w;
}
int a[110];
int b[110];
int n;
int dp[11000][2];
int main() {
  n = getint();
  int sum = 0;
  for (int i = 0; i < n; i++) {
    a[i] = getint();
    sum += a[i];
  }
  for (int i = 0; i < n; i++) {
    b[i] = getint();
  }
  for (int i = 0; i <= sum; i++) {
    dp[i][0] = 0X3F7F7F7F;
    dp[i][1] = 0;
  }
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    for (int j = sum; j > 0; j--) {
      int t = max(j - b[i], 0);
      if (dp[j][0] > dp[t][0] + 1) {
        dp[j][0] = dp[t][0] + 1;
        dp[j][1] = dp[t][1] + a[i];
      } else if (dp[j][0] == dp[t][0] + 1 && dp[j][1] < dp[t][1] + a[i]) {
        dp[j][1] = dp[t][1] + a[i];
      }
    }
  }
  printf("%d %d\n", dp[sum][0], sum - dp[sum][1]);
  return 0;
}
