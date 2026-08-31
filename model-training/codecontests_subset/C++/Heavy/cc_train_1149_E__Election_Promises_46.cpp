#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 1;
int read() {
  int x = 0;
  char ch = getchar();
  while (!isdigit(ch)) ch = getchar();
  while (isdigit(ch)) x = (x << 3) + (x << 1) + ch - '0', ch = getchar();
  return x;
}
vector<int> to[maxn];
int h[maxn], SG[maxn], sum[maxn];
int c[maxn], deg[maxn], que[maxn];
int n, m, hd = 1, tl = 1;
int main() {
  n = read(), m = read();
  for (int i = 1; i <= n; ++i) h[i] = read();
  for (int i = 1; i <= m; ++i) {
    int u = read(), v = read();
    to[u].push_back(v);
    ++deg[v];
  }
  for (int i = 1; i <= n; ++i)
    if (!deg[i]) que[tl++] = i;
  while (hd ^ tl) {
    int u = que[hd++];
    for (auto v : to[u])
      if (!--deg[v]) que[tl++] = v;
  }
  for (int i = n; i; --i) {
    int u = que[i];
    for (auto v : to[u]) ++c[SG[v]];
    while (c[SG[u]]) ++SG[u];
    sum[SG[u]] ^= h[u];
    for (auto v : to[u]) --c[SG[v]];
  }
  for (int i = n, u; ~i; --i)
    if (sum[i]) {
      for (int j = 1; j <= n; ++j)
        if (SG[j] == i && h[j] > (h[j] ^ sum[i])) u = j;
      h[u] ^= sum[i];
      for (auto v : to[u]) h[v] ^= sum[SG[v]], sum[SG[v]] = 0;
      puts("WIN");
      for (int j = 1; j <= n; ++j) printf("%d ", h[j]);
      return 0;
    }
  puts("LOSE");
  return 0;
}
