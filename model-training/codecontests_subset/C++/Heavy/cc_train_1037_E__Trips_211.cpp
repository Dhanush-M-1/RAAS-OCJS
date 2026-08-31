#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 3;
int n, m, k, deg[N], x[N], y[N], ans[N], cnt;
bool del[N];
set<int> G[N];
set<int>::iterator it;
void Del(int rt) {
  if (deg[rt] >= k || del[rt]) return;
  queue<int> q;
  q.push(rt);
  del[rt] = 1;
  cnt--;
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (it = G[u].begin(); it != G[u].end(); it++) {
      int v = *it;
      deg[v]--;
      if (deg[v] < k && !del[v]) {
        del[v] = 1;
        q.push(v);
        cnt--;
      }
    }
  }
}
int main() {
  memset(deg, 0, sizeof deg);
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", x + i, y + i);
    deg[x[i]]++;
    deg[y[i]]++;
    G[x[i]].insert(y[i]);
    G[y[i]].insert(x[i]);
  }
  cnt = n;
  for (int i = 1; i <= n; i++) Del(i);
  for (int i = m; i; i--) {
    ans[i] = cnt;
    if (!del[x[i]]) deg[y[i]]--;
    if (!del[y[i]]) deg[x[i]]--;
    G[x[i]].erase(y[i]);
    G[y[i]].erase(x[i]);
    Del(x[i]);
    Del(y[i]);
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
