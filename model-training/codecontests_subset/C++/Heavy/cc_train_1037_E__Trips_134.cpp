#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int n, m, k, l, i, ans, a[N], b[N], in[N], x[N], y[N], z[N], head[N], go[N + N],
    Next[N + N];
bool f[N], use[N + N];
inline void Add(int u, int v) {
  Next[++l] = head[u], head[u] = l, go[l] = v, use[l] = 1;
}
inline void bfs(int x) {
  int l, r, j, u, v;
  if (in[x] >= k || !f[x]) return;
  for (b[l = r = 1] = x, f[x] = 0, ans--; l <= r; l++) {
    for (j = head[u = b[l]]; j; j = Next[j]) {
      if (!use[j]) continue;
      in[v = go[j]]--, in[u]--;
      use[j] = use[j ^ 1] = 0;
      if (f[v] && in[v] < k) b[++r] = v, f[v] = 0, ans--;
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (l = 1, i = 1; i <= m; i++)
    scanf("%d%d", &x[i], &y[i]), Add(x[i], y[i]), Add(y[i], x[i]),
        z[i] = l, in[x[i]]++, in[y[i]]++;
  memset(f, 1, sizeof(f));
  for (ans = n, i = 1; i <= n; i++) bfs(i);
  for (i = m; i; i--) {
    a[i] = ans;
    if (!use[z[i]]) continue;
    in[x[i]]--, in[y[i]]--, use[z[i]] = use[z[i] ^ 1] = 0;
    bfs(x[i]), bfs(y[i]);
  }
  for (i = 1; i <= m; i++) printf("%d\n", a[i]);
  return 0;
}
