#include <bits/stdc++.h>
using namespace std;
int dp[1100][1100];
int a[1100], cnt;
void gao(int n) {
  int i, j;
  dp[0][0] = 1;
  for (i = 0; i < n; i++) {
    for (j = 0; j <= 1000; j++)
      if (dp[i][j]) {
        if (j + a[i + 1] <= 1000) dp[i + 1][j + a[i + 1]] = 1;
        dp[i + 1][j] = 1;
      }
  }
}
int fa[1100];
int you[1100];
void ca(int n, int x) {
  int i = 1, is = 0;
  if (n == x) is = 1;
  while (fa[n]) {
    i++, n = fa[n];
    if (n == x) is = 1;
  }
  if (!is) a[++cnt] = i;
}
int main() {
  int n, x, i, j, k;
  scanf("%d", &n);
  scanf("%d", &x);
  for (i = 1; i <= n; i++) {
    scanf("%d", &j);
    you[j] = 1;
    fa[i] = j;
  }
  for (i = 1; i <= n; i++)
    if (!you[i]) ca(i, x);
  gao(cnt);
  int ans = 1;
  while (fa[x]) ans++, x = fa[x];
  for (i = 0; i <= 1000; i++)
    if (dp[cnt][i]) printf("%d\n", ans + i);
}
