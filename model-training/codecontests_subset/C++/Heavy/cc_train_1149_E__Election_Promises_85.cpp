#include <bits/stdc++.h>
using namespace std;
int gi() {
  int x = 0, w = 1;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') w = 0, ch = getchar();
  while (ch >= '0' && ch <= '9')
    x = (x << 3) + (x << 1) + ch - '0', ch = getchar();
  return w ? x : -x;
}
const int N = 2e5 + 5;
int n, m, h[N], in[N], q[N], hd, tl, mrk[N], sg[N], sum[N], vis[N];
vector<int> E[N];
int main() {
  n = gi();
  m = gi();
  for (int i = 1; i <= n; ++i) h[i] = gi();
  for (int i = 1, x, y; i <= m; ++i)
    x = gi(), ++in[y = gi()], E[x].push_back(y);
  for (int i = 1; i <= n; ++i)
    if (!in[i]) q[++tl] = i;
  while (hd < tl) {
    int u = q[++hd];
    for (int v : E[u])
      if (!--in[v]) q[++tl] = v;
  }
  for (int i = n; i; --i) {
    int u = q[i];
    for (int v : E[u]) mrk[sg[v]] = u;
    while (mrk[sg[u]] == u) ++sg[u];
    sum[sg[u]] ^= h[u];
  }
  for (int i = n - 1; ~i; --i)
    if (sum[i]) {
      puts("WIN");
      for (int j = 1; j <= n; ++j)
        if (sg[j] == i && h[j] > (h[j] ^ sum[i])) {
          h[j] ^= sum[i];
          for (int v : E[j]) h[v] ^= sum[sg[v]], sum[sg[v]] = 0;
          break;
        }
      for (int j = 1; j <= n; ++j) printf("%d ", h[j]);
      return puts(""), 0;
    }
  return puts("LOSE"), 0;
}
