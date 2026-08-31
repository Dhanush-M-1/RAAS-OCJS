#include <bits/stdc++.h>
using namespace std;
const int maxN = 2e5 + 10;
int n, m, clk;
int h[maxN + 1], vis[maxN + 1];
int p[maxN + 1], sum[maxN + 1];
vector<int> G[maxN + 1];
inline int read() {
  int num = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) num = (num << 3) + (num << 1) + (ch ^ 48), ch = getchar();
  return num * f;
}
inline void dfs(int u) {
  if (p[u] != -1) return;
  for (int i = 0; i < G[u].size(); i++) dfs(G[u][i]);
  clk++;
  for (int i = 0; i < G[u].size(); i++) vis[p[G[u][i]]] = clk;
  p[u] = 0;
  while (vis[p[u]] == clk) p[u]++;
  sum[p[u]] ^= h[u];
}
int main() {
  n = read(), m = read();
  for (int i = 1; i <= n; i++) h[i] = read();
  for (int i = 1; i <= m; i++) {
    int x = read(), y = read();
    G[x].push_back(y);
  }
  fill(p + 1, p + n + 1, -1);
  for (int i = 1; i <= n; i++) dfs(i);
  int id = -1;
  for (int i = 1; i <= n; i++)
    if (sum[p[i]]) id = max(id, p[i]);
  if (id == -1) {
    puts("LOSE");
    return 0;
  }
  puts("WIN");
  int x;
  for (int i = 1; i <= n; i++)
    if (p[i] == id && (h[i] ^ sum[id]) < h[i]) {
      x = i;
      break;
    }
  h[x] ^= sum[p[x]];
  for (int i = 0; i < G[x].size(); i++) {
    int y = G[x][i];
    h[y] ^= sum[p[y]];
    sum[p[y]] = 0;
  }
  for (int i = 1; i <= n; i++) printf("%d ", h[i]);
  puts("");
  return 0;
}
