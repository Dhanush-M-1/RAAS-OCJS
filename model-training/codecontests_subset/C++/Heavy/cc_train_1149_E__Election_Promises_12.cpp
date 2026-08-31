#include <bits/stdc++.h>
const int N = 200007;
int a[N], deg[N], pos[N], vis[N], sg[N], sum[N];
std::queue<int> q;
std::vector<int> e[N];
int read() {
  int x = 0, c = getchar();
  while (isspace(c)) c = getchar();
  while (isdigit(c)) (x *= 10) += c & 15, c = getchar();
  return x;
}
int main() {
  int n = read(), m = read();
  for (int i = 1; i <= n; ++i) a[i] = read();
  for (int i = 1, u, v; i <= m; ++i)
    u = read(), v = read(), e[u].push_back(v), ++deg[v];
  for (int i = 1; i <= n; ++i)
    if (!deg[i]) q.push(i);
  for (int u, c = 0; !q.empty();) {
    u = q.front(), q.pop(), pos[++c] = u;
    for (int v : e[u])
      if (!--deg[v]) q.push(v);
  }
  for (int i = n, u; i; --i) {
    u = pos[i];
    for (int v : e[u]) vis[sg[v]] = i;
    while (vis[sg[u]] == i) ++sg[u];
    sum[sg[u]] ^= a[u];
  }
  for (int i = n, u; ~i; --i)
    if (sum[i]) {
      for (int j = 1; j <= n; ++j)
        if (sg[j] == i && a[j] > (sum[i] ^ a[j])) u = j;
      a[u] ^= sum[i];
      for (int v : e[u]) a[v] ^= sum[sg[v]], sum[sg[v]] = 0;
      puts("WIN");
      for (int j = 1; j <= n; ++j) printf("%d ", a[j]);
      puts("");
      return 0;
    }
  puts("LOSE");
}
