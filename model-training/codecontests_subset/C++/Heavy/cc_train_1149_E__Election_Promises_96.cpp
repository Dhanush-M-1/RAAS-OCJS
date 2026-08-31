#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
inline int gi() {
  char c = getchar();
  while (c < '0' || c > '9') c = getchar();
  int sum = 0;
  while ('0' <= c && c <= '9') sum = sum * 10 + c - 48, c = getchar();
  return sum;
}
int n, m, val[maxn], Id[maxn], sum[maxn], vis[maxn];
vector<int> to[maxn];
int dfs(int u) {
  if (vis[u]) return Id[u];
  vector<int> t;
  vis[u] = 1;
  for (int v : to[u]) t.push_back(dfs(v));
  sort(t.begin(), t.end());
  int lst = -1;
  Id[u] = -1;
  for (int i = 0; i < t.size(); ++i)
    if (t[i] > lst + 1) {
      Id[u] = lst + 1;
      break;
    } else
      lst = t[i];
  if (Id[u] == -1) Id[u] = lst + 1;
  return Id[u];
}
int main() {
  n = gi();
  m = gi();
  for (int i = 1; i <= n; ++i) val[i] = gi();
  for (int u, v, i = 1; i <= m; ++i) u = gi(), v = gi(), to[u].push_back(v);
  for (int i = 1; i <= n; ++i)
    if (!vis[i]) dfs(i);
  for (int i = 1; i <= n; ++i) sum[Id[i]] ^= val[i];
  int pos = -1;
  for (int i = 0; i <= n; ++i)
    if (sum[i]) pos = i;
  if (~pos) {
    puts("WIN");
    for (int i = 1; i <= n; ++i)
      if (Id[i] == pos && (val[i] ^ sum[pos]) < val[i]) {
        val[i] = val[i] ^ sum[pos];
        sum[pos] = 0;
        for (int v : to[i]) val[v] = sum[Id[v]] ^ val[v], sum[Id[v]] = 0;
      }
    for (int i = 1; i <= n; ++i) printf("%d ", val[i]);
  } else
    puts("LOSE");
  return 0;
}
