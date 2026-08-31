#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e3 + 7;
const int maxm = 1e6 + 7;
const int mod = 1e9 + 7;
const int INF = 1e9 + 7;
const int mlog = 21;
const int SQ = 400;
vector<int> adj[maxn];
int par[maxn];
int fi[maxm], se[maxm], we[maxm], ord[maxm];
bool col[maxn];
void dfs(int v, int Par = -1) {
  col[v] ^= 1;
  for (auto u : adj[v])
    if (u != Par) dfs(u, v);
}
int get(int v) { return (par[v] < 0 ? v : par[v] = get(par[v])); }
int merge(int v, int u) {
  bool change = col[v] ^ col[u];
  int V = get(v);
  int U = get(u);
  if (V == U) {
    if (!change) return -1;
    return 0;
  }
  par[V] = U;
  if (!change) dfs(v);
  return 1;
}
bool cmp(int i, int j) { return (we[i] > we[j]); }
int32_t main() {
  int n, m, q;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; i++)
    scanf("%d%d%d", fi + i, se + i, we + i), ord[i] = i, fi[i]--, se[i]--;
  sort(ord, ord + m, cmp);
  for (int rep = 0; rep < q; rep++) {
    for (int i = 0; i < n; i++) adj[i].clear(), par[i] = -1, col[i] = 0;
    int l, r, ans = -1;
    scanf("%d%d", &l, &r);
    l--;
    for (int i = 0; i < m; i++) {
      if (l <= ord[i] && ord[i] < r) {
        int v = fi[ord[i]];
        int u = se[ord[i]];
        int w = we[ord[i]];
        int state = merge(v, u);
        if (state == 1) adj[v].push_back(u), adj[u].push_back(v);
        if (state == -1) {
          ans = w;
          break;
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
