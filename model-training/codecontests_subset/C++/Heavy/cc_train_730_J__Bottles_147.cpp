#include <bits/stdc++.h>
const int maxn = 110;
using namespace std;
struct bott {
  int wt;
  int bt;
} pp[maxn];
int cc[maxn];
bool cmp(bott a, bott b) { return a.bt > b.bt; }
int dp[maxn][10005];
int ans, n, wts, bts, mini, totb;
int main() {
  scanf("%d", &n);
  wts = 0, bts = 0;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &pp[i].wt);
    wts += pp[i].wt;
  }
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &pp[i].bt);
    bts += pp[i].bt;
    cc[i] = pp[i].bt;
  }
  sort(cc + 1, cc + 1 + n);
  int temp = 0;
  for (int i = 1; i <= n && temp < wts; ++i) {
    temp += cc[n - i + 1];
    mini++;
  }
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0, ans = wts;
  for (int i = 1; i <= n; ++i)
    for (int j = bts; j >= pp[i].bt; --j)
      for (int l = mini; l; l--)
        if (dp[l - 1][j - pp[i].bt] >= 0)
          dp[l][j] = max(dp[l][j], dp[l - 1][j - pp[i].bt] + pp[i].wt);
  for (int j = bts; j >= wts; --j) ans = min(ans, wts - dp[mini][j]);
  printf("%d %d\n", mini, ans);
  return 0;
}
