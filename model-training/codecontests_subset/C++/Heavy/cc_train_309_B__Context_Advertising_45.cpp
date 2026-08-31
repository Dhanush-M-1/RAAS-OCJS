#include <bits/stdc++.h>
using namespace std;
char s[5000005];
int len[1000005];
int idx[1000005];
int sum[1000005];
int sz = 0;
int dp[1000005][20];
int p[1000005];
int main() {
  int n, r, c;
  scanf("%d%d%d", &n, &r, &c);
  gets(s);
  gets(s);
  int cnt = 0, slen = 0;
  for (int i = 0; s[i]; i++, slen++) {
    if (s[i] == ' ' && cnt != 0) {
      len[sz] = cnt;
      idx[sz++] = i - cnt;
      cnt = 0;
    } else
      cnt++;
  }
  if (cnt > 0) {
    len[sz] = cnt;
    idx[sz++] = slen - cnt;
    cnt = 0;
  }
  sum[0] = len[0];
  for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + 1 + len[i];
  for (int i = n - 1; i >= 0; i--) {
    int id = upper_bound(sum, sum + n, (i > 0 ? sum[i - 1] + 1 : 0) + c) - sum;
    if (id > n) id = n;
    dp[i][0] = id - i;
  }
  for (int j = 2, t = 1; j <= r; j *= 2, t++) {
    for (int i = n - 1; i >= 0; i--)
      dp[i][t] = dp[i][t - 1] + dp[i + dp[i][t - 1]][t - 1];
  }
  int maid = -1, ma = 0;
  for (int i = 0; i < n; i++) {
    int idx = i, rr = r, cur = 0;
    for (int j = 20; j >= 0; j--) {
      if (rr >= (1 << j)) {
        rr -= (1 << j);
        cur += dp[idx][j];
        idx += dp[idx][j];
      }
    }
    if (cur > ma) maid = i, ma = cur;
  }
  int cn = 1, cs = dp[maid][0];
  for (int i = maid; i < maid + ma; i++) {
    s[idx[i] + len[i]] = 0;
    if (cn < cs) {
      printf("%s ", s + idx[i]);
      cn++;
    } else {
      printf("%s\n", s + idx[i]);
      cs = dp[i + 1][0];
      cn = 1;
    }
  }
  return 0;
}
