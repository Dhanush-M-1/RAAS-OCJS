#include <bits/stdc++.h>
using namespace std;
int vis[100];
int sum[1000];
int bit[100][10], a[10];
int b[100];
int cnt = 0;
int dp[30][20];
int pre[30][20], rem[30][20];
void dfs(int d, int s) {
  if (d == 6) {
    if (vis[s]) return;
    vis[s] = 1;
    sum[cnt] = s;
    memcpy(bit[cnt], a, sizeof(a));
    cnt++;
    return;
  }
  a[d] = 0;
  dfs(d + 1, s + 0);
  a[d] = 4;
  dfs(d + 1, s + 4);
  a[d] = 7;
  dfs(d + 1, s + 7);
}
long long ans[10];
int main() {
  dfs(0, 0);
  int T, n;
  long long x;
  scanf("%d", &T);
  while (T--) {
    n = 0;
    cin >> x;
    while (x) {
      b[++n] = x % 10;
      x /= 10;
    }
    memset(dp, 0, sizeof(dp));
    dp[0][0] = 1;
    int nn = 20;
    for (int i = 1; i <= n; ++i)
      for (int j = 0; j <= 10; ++j)
        if (dp[i - 1][j]) {
          for (int k = 0; k < cnt; ++k) {
            x = sum[k] + j;
            if (x % 10 != b[i]) continue;
            dp[i][x / 10] |= dp[i - 1][j];
            pre[i][x / 10] = (i - 1) * nn + j;
            rem[i][x / 10] = k;
          }
        }
    if (dp[n][0]) {
      memset(ans, 0, sizeof(ans));
      int x, y, k;
      k = rem[n][0];
      for (int i = 0; i < 6; ++i) {
        ans[i] = bit[k][i];
      }
      x = pre[n][0];
      while (x) {
        y = x % nn, x = x / nn;
        k = rem[x][y];
        for (int i = 0; i < 6; ++i) {
          ans[i] = 10 * ans[i] + bit[k][i];
        }
        x = pre[x][y];
      }
      long long haha = 0;
      for (int i = 0; i < 6; ++i) {
        haha += ans[i];
        cout << ans[i] << " ";
      }
      cout << endl;
    } else
      puts("-1");
  }
}
