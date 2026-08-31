#include <bits/stdc++.h>
using namespace std;
const int N = 1000005;
struct ab {
  int f, t;
} t[N << 1];
int h, hh[N], d[N], dmn[N], sum[N], dp[N], k;
void make(int x, int y) {
  t[++h].f = hh[x];
  t[h].t = y;
  hh[x] = h;
}
void dfs(int x, int y) {
  d[x] = d[y] + 1;
  dmn[x] = N;
  int flag = 0;
  for (int i = hh[x]; i; i = t[i].f) {
    int j = t[i].t;
    if (j == y) continue;
    flag = 1;
    dfs(j, x);
    dmn[x] = min(dmn[x], dmn[j]);
    if (dmn[j] - d[x] <= k) sum[x] += sum[j], dp[j] -= sum[j];
    dp[x] = max(dp[x], dp[j]);
  }
  if (!flag) dmn[x] = d[x], sum[x] = 1;
  dp[x] += sum[x];
}
int main() {
  int n;
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; i++) {
    int x;
    scanf("%d", &x);
    make(x, i), make(i, x);
  }
  dfs(1, 0);
  printf("%d\n", dp[1]);
  return 0;
}
