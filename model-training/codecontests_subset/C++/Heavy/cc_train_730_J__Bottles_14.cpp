#include <bits/stdc++.h>
using namespace std;
int s[100], dp[101][10001];
int main() {
  int n;
  scanf("%d", &n);
  int ts = 0;
  for (int i = 0; i < (int)(n); ++i) scanf("%d", s + i), ts += s[i];
  for (int i = 0; i < (int)(n + 1); ++i)
    for (int j = 0; j < (int)(10001); ++j) dp[i][j] = -1e9;
  dp[0][0] = 0;
  for (int i = 0; i < (int)(n); ++i) {
    int sz;
    scanf("%d", &sz);
    for (int j = i; j >= 0; --j)
      for (int k = sz; k < (int)(10001); ++k)
        dp[j + 1][k] = max(dp[j + 1][k], dp[j][k - sz] + s[i]);
  }
  for (int i = 1; i < (int)(n + 1); ++i) {
    int an = -1;
    for (int j = ts; j < (int)(10001); ++j) an = max(an, dp[i][j]);
    if (an >= 0) {
      printf("%d %d\n", i, ts - an);
      return 0;
    }
  }
}
