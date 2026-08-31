#include <bits/stdc++.h>
using namespace std;
struct Bottle {
  int water, all;
  inline bool operator<(const Bottle &x) const { return all > x.all; }
};
int n, ans, sum, now, dp[10005][105], ans_time = -2147483647;
Bottle bottle[105];
inline int read() {
  int ans = 0, f = 1;
  char in = getchar();
  while (!(in >= '0' && in <= '9')) {
    if (in == '-') {
      f = !f;
    }
    in = getchar();
  }
  while (in >= '0' && in <= '9') {
    ans = (ans << 1) + (ans << 3) + (in ^ '0');
    in = getchar();
  }
  return ans * f;
}
int main() {
  n = read();
  for (register int i = 1; i <= n; i++) {
    bottle[i].water = read();
    sum += bottle[i].water;
  }
  for (register int i = 1; i <= n; i++) {
    bottle[i].all = read();
  }
  sort(bottle + 1, bottle + n + 1);
  while (now < sum) {
    ans++;
    now += bottle[ans].all;
  }
  printf("%d ", ans);
  memset(dp, 128, sizeof(dp));
  dp[0][0] = 0;
  for (register int i = 1; i <= n; i++) {
    for (register int j = now; j >= bottle[i].all; j--) {
      for (register int k = 1; k <= ans; k++) {
        dp[j][k] = (dp[j][k] > dp[j - bottle[i].all][k - 1] + bottle[i].water
                        ? dp[j][k]
                        : dp[j - bottle[i].all][k - 1] + bottle[i].water);
      }
    }
  }
  for (register int i = sum; i <= now; i++) {
    ans_time = (ans_time > dp[i][ans] ? ans_time : dp[i][ans]);
  }
  printf("%d\n", sum - ans_time);
  return 0;
}
