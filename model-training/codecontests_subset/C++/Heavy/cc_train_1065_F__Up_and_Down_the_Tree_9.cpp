#include <bits/stdc++.h>
using namespace std;
int n, m, x, f[1000005], g[1000005], len[1000005], deep[1000005];
int num, q[1000005], ne[1000005], head[1000005];
void addnum(int x, int y) {
  num++;
  q[num] = y;
  ne[num] = head[x];
  head[x] = num;
}
void dfs(int t) {
  if (head[t] == 0) {
    f[t] = 1;
    g[t] = 1;
    len[t] = deep[t];
    return;
  }
  len[t] = n;
  for (int i = head[t]; i != 0; i = ne[i]) {
    deep[q[i]] = deep[t] + 1;
    dfs(q[i]);
    len[t] = min(len[t], len[q[i]]);
    if (len[q[i]] - deep[t] <= m) {
      g[t] += g[q[i]];
      f[t] = max(f[t], f[q[i]] - g[q[i]]);
    } else
      f[t] = max(f[t], f[q[i]]);
  }
  f[t] += g[t];
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 2; i <= n; i++) {
    scanf("%d", &x);
    addnum(x, i);
  }
  deep[1] = 1;
  dfs(1);
  printf("%d", f[1]);
}
