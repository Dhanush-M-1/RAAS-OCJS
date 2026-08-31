#include <bits/stdc++.h>
using namespace std;
int n, m, cnt;
int head[2000005], vet[2000005], Next[2000005];
int d[2000005], f[2000005], g[2000005], len[2000005];
void add(int x, int y) {
  cnt++;
  Next[cnt] = head[x];
  head[x] = cnt;
  vet[cnt] = y;
}
void dfs(int x, int fa) {
  d[x] = d[fa] + 1;
  len[x] = 0x3f3f3f3f, f[x] = 0;
  int tot = 0;
  for (int i = head[x]; i; i = Next[i]) {
    int v = vet[i];
    if (v == fa) continue;
    tot++;
    dfs(v, x);
    len[x] = min(len[x], len[v]);
    if (len[v] - d[x] > m) g[v] = 0;
    f[x] = max(f[x], f[v] - g[v]);
    g[x] += g[v];
  }
  if (!tot)
    len[x] = d[x], g[x] = f[x] = 1;
  else
    f[x] += g[x];
}
int main() {
  cin >> n >> m;
  int x;
  for (int i = 2; i <= n; i++) {
    scanf("%d", &x);
    add(x, i);
  }
  dfs(1, 0);
  cout << f[1] << endl;
  return 0;
}
