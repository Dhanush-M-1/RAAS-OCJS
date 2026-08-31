#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000010;
int head[maxn], Next[maxn], ver[maxn];
int d[maxn], dp[maxn], re[maxn];
int tot;
int n, k;
void add(int x, int y) {
  ver[++tot] = y;
  Next[tot] = head[x];
  head[x] = tot;
}
void dfs(int x) {
  d[x] = 0x3f3f3f3f;
  int y;
  for (int i = head[x]; i; i = Next[i]) {
    y = ver[i];
    dfs(y);
    d[x] = min(d[x], d[y] + 1);
    re[x] += re[y];
    dp[x] = max(dp[x], dp[y] - re[y]);
  }
  dp[x] += re[x];
  if (d[x] == 0x3f3f3f3f) {
    d[x] = 0;
    dp[x] = re[x] = 1;
  }
  if (d[x] >= k) {
    re[x] = 0;
  }
}
int main() {
  scanf("%d%d", &n, &k);
  int x;
  for (int i = 2; i <= n; i++) {
    scanf("%d", &x);
    add(x, i);
  }
  dfs(1);
  printf("%d\n", dp[1]);
}
