#include <bits/stdc++.h>
using namespace std;
const int N = 2e6 + 10;
int h[N], e[N], ne[N], idx;
int f[N], g[N], len[N];
int n, k;
void add(int a, int b) { e[idx] = b, ne[idx] = h[a], h[a] = idx++; }
void dfs(int u, int fa) {
  len[u] = 0x3f3f3f3f;
  bool flag = true;
  for (int i = h[u]; ~i; i = ne[i]) {
    int j = e[i];
    if (j == fa) continue;
    flag = false;
    dfs(j, u);
    len[u] = min(len[u], len[j] + 1);
    if (len[j] + 1 > k) g[j] = 0;
    g[u] += g[j];
    f[u] = max(f[u], f[j] - g[j]);
  }
  if (flag) {
    len[u] = 0;
    f[u] = g[u] = 1;
  } else
    f[u] += g[u];
}
int main() {
  memset(h, -1, sizeof h);
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    int x;
    cin >> x;
    add(i, x);
    add(x, i);
  }
  dfs(1, -1);
  cout << f[1] << endl;
}
