#include <bits/stdc++.h>
using namespace std;
int arr[29] = {0,  4,  7,  8,  11, 12, 14, 15, 16, 18, 19, 20, 21, 22,       23,
               24, 25, 26, 27, 28, 29, 30, 32, 33, 35, 36, 39, 42, 100000000};
int decision[111];
int res[111];
bool dfs(long long x, long long dec, int d) {
  if (d < 0) {
    if (x == 0) memcpy(res, decision, sizeof res);
    return x == 0;
  }
  long long c = upper_bound(arr, arr + 28, x / dec) - arr - 1;
  for (int i = c; i >= 0; --i) {
    if (x - dec * arr[i] > 5ll * dec) break;
    decision[d] = arr[i];
    if (dfs(x - dec * arr[i], dec / 10ll, d - 1)) return true;
  }
  return false;
}
bool check(int x) {
  while (x) {
    int c = x % 10;
    if (c != 4 && c != 7 && c != 0) return false;
    x /= 10;
  }
  return true;
}
long long ans[11];
int dp[11][3111], pre[11][3111];
int main() {
  int T;
  cin >> T;
  dp[0][0] = 1;
  for (int i = 0; i <= 5; ++i)
    for (int j = 0; j <= 1111; ++j)
      if (dp[i][j]) {
        for (int k = 0; k <= 1111; ++k)
          if (check(k)) {
            dp[i + 1][j + k] = true;
            pre[i + 1][j + k] = k;
          }
      }
  for (int TK = 1; TK <= T; ++TK) {
    long long x;
    cin >> x;
    long long cur = 1, d = 0;
    while (cur * 10 < x) {
      cur *= 10;
      ++d;
    }
    if (!dfs(x, cur, d)) {
      puts("-1");
      assert(x < 1000);
      continue;
    }
    cur = 1;
    memset(ans, 0, sizeof ans);
    for (int i = 0; i <= d; ++i) {
      int c = res[i];
      int c4 = 0, c7 = 0;
      for (int x = 0; x <= 6; ++x)
        for (int y = 0; y <= 6 - x; ++y)
          if (x * 4 + y * 7 == c) {
            c4 = x;
            c7 = y;
          }
      for (int i = 1; i <= c4; ++i) ans[i] += cur * 4;
      for (int i = c4 + 1; i <= c4 + c7; ++i) ans[i] += cur * 7;
      cur *= 10;
    }
    for (int i = 1; i <= 6; ++i) printf("%I64d%c", ans[i], " \n"[i == 6]);
    assert(ans[1] + ans[2] + ans[3] + ans[4] + ans[5] + ans[6] == x);
  }
  return 0;
}
