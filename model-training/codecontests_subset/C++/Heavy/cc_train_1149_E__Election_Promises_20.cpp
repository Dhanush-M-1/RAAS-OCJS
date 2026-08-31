#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0;
  bool t = false;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') t = true, ch = getchar();
  while (ch <= '9' && ch >= '0') x = x * 10 + ch - 48, ch = getchar();
  return t ? -x : x;
}
vector<int> E[200200];
int n, m, h[200200], sg[200200], sum[200200];
int dg[200200], Q[200200], vis[200200];
void Topsort() {
  int h = 1, t = 0;
  for (int i = 1; i <= n; ++i)
    if (!dg[i]) Q[++t] = i;
  while (h <= t) {
    int u = Q[h++];
    for (int v : E[u])
      if (!--dg[v]) Q[++t] = v;
  }
}
int main() {
  n = read();
  m = read();
  for (int i = 1; i <= n; ++i) h[i] = read();
  for (int i = 1; i <= m; ++i) {
    int u = read(), v = read();
    E[u].push_back(v);
    ++dg[v];
  }
  Topsort();
  for (int i = n; i; --i) {
    int u = Q[i];
    for (int v : E[u]) vis[sg[v]] = i;
    while (vis[sg[u]] == i) ++sg[u];
    sum[sg[u]] ^= h[u];
  }
  for (int i = n; ~i; --i)
    if (sum[i]) {
      int pos;
      for (int j = 1; j <= n; ++j)
        if (sg[j] == i && h[j] > (sum[i] ^ h[j])) pos = j;
      h[pos] ^= sum[i];
      for (int v : E[pos]) h[v] ^= sum[sg[v]], sum[sg[v]] = 0;
      puts("WIN");
      for (int j = 1; j <= n; ++j) printf("%d ", h[j]);
      puts("");
      return 0;
    }
  puts("LOSE");
  return 0;
}
