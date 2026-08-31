#include <bits/stdc++.h>
using namespace std;
struct bottles {
  int las;
  int vol;
} inp[1000];
int dp[105][20000];
bool cmp(bottles x, bottles y) { return x.vol > y.vol; }
int main() {
  int n, sum = 0, cnt = 0, num = -1;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &inp[i].las);
  for (int i = 1; i <= n; i++) scanf("%d", &inp[i].vol);
  for (int i = 1; i <= n; i++) sum += inp[i].las;
  sort(inp + 1, inp + 1 + n, cmp);
  for (int i = 1; i <= n; i++) {
    cnt += inp[i].vol;
    if (cnt >= sum && num == -1) num = i;
  }
  printf("%d ", num);
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = cnt; j >= inp[i].vol; j--) {
      for (int k = 1; k <= num; k++) {
        if (dp[k - 1][j - inp[i].vol] != -1) {
          dp[k][j] = max(dp[k - 1][j - inp[i].vol] + inp[i].las, dp[k][j]);
        }
      }
    }
  }
  int oup = -1;
  for (int i = sum; i <= cnt; i++) {
    oup = max(oup, dp[num][i]);
  }
  printf("%d", sum - oup);
  return 0;
}
