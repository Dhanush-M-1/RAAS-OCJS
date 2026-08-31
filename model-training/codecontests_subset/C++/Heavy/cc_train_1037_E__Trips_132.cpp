#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
set<int> e[N];
int deg[N], x[N], y[N], ans[N], q[N], del[N];
int n, m, k, tail = 0, head = 1;
void delv(int u) {
  if (deg[u] >= k || del[u]) return;
  del[u] = 1;
  q[++tail] = u;
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d", x + i, y + i);
    e[x[i]].insert(y[i]);
    e[y[i]].insert(x[i]);
    ++deg[x[i]], ++deg[y[i]];
  }
  for (int i = 1; i <= n; ++i) delv(i);
  for (int i = m; i >= 1; --i) {
    while (head <= tail) {
      int u = q[head++];
      for (auto &v : e[u]) {
        --deg[v];
        delv(v);
        e[v].erase(u);
      }
    }
    ans[i] = n - tail;
    if (!del[x[i]] && !del[y[i]]) {
      --deg[x[i]], --deg[y[i]];
      delv(x[i]), delv(y[i]);
      e[x[i]].erase(y[i]);
      e[y[i]].erase(x[i]);
    }
  }
  for (int i = 1; i <= m; ++i) printf("%d%c", ans[i], " \n"[i == m]);
  return 0;
}
