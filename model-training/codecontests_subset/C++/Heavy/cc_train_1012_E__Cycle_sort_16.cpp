#include <bits/stdc++.h>
using namespace std;
namespace FGF {
int n, m;
const int N = 2e5 + 5;
int a[N], b[N], p[N], vis[N], cnt, head[N], fa[N], ins[N], ok[N];
vector<int> V, tmp;
struct edg {
  int to, nxt, w;
} e[N];
void add(int u, int v, int w) {
  cnt++;
  e[cnt].to = v;
  e[cnt].nxt = head[u];
  head[u] = cnt;
  e[cnt].w = w;
}
int find(int x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
void merge(int u, int v) {
  if (find(u) != find(v)) fa[find(v)] = u;
}
vector<vector<int> > ans;
void dfs(int u) {
  ins[u] = 1;
  for (int w, &i = head[u]; i; i = e[i].nxt)
    if (!vis[i]) vis[i] = 1, w = e[i].w, dfs(e[i].to), tmp.push_back(w);
}
void work() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]), b[i] = a[i];
  sort(b + 1, b + n + 1);
  int tot = unique(b + 1, b + n + 1) - b - 1;
  for (int i = 1; i <= n; i++) a[i] = lower_bound(b + 1, b + tot + 1, a[i]) - b;
  for (int i = 1; i <= n; i++) p[i] = a[i], fa[i] = i;
  sort(p + 1, p + n + 1);
  for (int i = 1; i <= n; i++)
    if (a[i] != p[i]) cnt++, merge(a[i], p[i]);
  if (cnt > m) {
    puts("-1");
    return;
  }
  for (int i = 1; i <= n; i++)
    if (find(a[i]) == a[i] && a[i] != p[i] && !ok[a[i]])
      V.push_back(i), ok[a[i]] = 1;
  if (m - cnt > 1 && V.size() > 1) {
    tmp.push_back(V[0]);
    for (int i = 1; i < min((int)V.size(), m - cnt); i++)
      swap(a[V[i]], a[V[i - 1]]), tmp.push_back(V[i]);
    reverse(tmp.begin(), tmp.end());
    ans.push_back(tmp);
    tmp.clear();
  }
  cnt = 0;
  for (int i = 1; i <= n; i++)
    if (a[i] != p[i]) add(a[i], p[i], i);
  for (int i = 1; i <= tot; i++)
    if (!ins[i] && head[i]) tmp.clear(), dfs(i), ans.push_back(tmp);
  printf("%d\n", (int)ans.size());
  for (auto g : ans) {
    printf("%d\n", (int)g.size());
    for (auto x : g) printf("%d ", x);
    puts("");
  }
}
}  // namespace FGF
int main() {
  FGF::work();
  return 0;
}
