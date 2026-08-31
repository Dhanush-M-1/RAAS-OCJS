#include <bits/stdc++.h>
using namespace std;
long long n, m, k, Q, d[100005], tr[100005], oo, f[100005][20], gt[100005][20],
    h[100005], u, v, w, ru, rv, lab[100005];
bool kt[100005];
pair<long long, pair<int, int> > ed[300005];
vector<pair<long long, int> > a[100005], ke[100005];
priority_queue<pair<long long, int>, vector<pair<long long, int> >,
               greater<pair<long long, int> > >
    q;
void ditcha() {
  for (int i = 1; i <= n; ++i)
    if (i <= k) {
      q.push({0, i});
      tr[i] = i;
    } else
      d[i] = oo;
  memset(kt, 0, sizeof(kt));
  while (!q.empty()) {
    int u = q.top().second;
    q.pop();
    if (kt[u]) continue;
    kt[u] = true;
    for (int i = 0; i < a[u].size(); ++i) {
      int v = a[u][i].second;
      long long w = a[u][i].first;
      if (d[v] > d[u] + w) {
        d[v] = d[u] + w;
        tr[v] = tr[u];
        q.push({d[v], v});
      }
    }
  }
}
void dfs(int u, int pa, long long w) {
  h[u] = h[pa] + 1;
  f[u][0] = pa;
  gt[u][0] = w;
  for (int i = 0; i < ke[u].size(); ++i) {
    int v = ke[u][i].second;
    long long w = ke[u][i].first;
    if (v == pa) continue;
    dfs(v, u, w);
  }
}
void khoitao() {
  for (int K = 1; (1 << K) <= k; ++K)
    for (int i = 1; i <= k; ++i)
      if (f[i][K - 1] != -1) {
        f[i][K] = f[f[i][K - 1]][K - 1];
        gt[i][K] = max(gt[i][K - 1], gt[f[i][K - 1]][K - 1]);
      }
}
long long lca(int u, int v) {
  if (h[u] < h[v]) swap(u, v);
  int log = trunc(log2(h[u])) + 1;
  long long kq = 0;
  for (int i = log; i >= 0; --i)
    if (f[u][i] != -1 && h[f[u][i]] >= h[v]) {
      kq = max(kq, gt[u][i]);
      u = f[u][i];
    }
  if (u == v) return kq;
  for (int i = log; i >= 0; --i)
    if (f[u][i] != f[v][i]) {
      kq = max(kq, max(gt[u][i], gt[v][i]));
      u = f[u][i];
      v = f[v][i];
    }
  return max(kq, max(gt[u][0], gt[v][0]));
}
int phin(int u) { return lab[u] < 0 ? u : lab[u] = phin(lab[u]); }
void uni(int u, int v) {
  if (lab[u] > lab[v]) swap(u, v);
  lab[u] += lab[v];
  lab[v] = u;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k >> Q;
  oo = 1e18;
  for (int i = 1; i <= m; ++i) {
    cin >> u >> v >> w;
    a[u].push_back({w, v});
    a[v].push_back({w, u});
    ed[i] = {w, {u, v}};
  }
  ditcha();
  for (int i = 1; i <= m; ++i) {
    u = ed[i].second.first;
    v = ed[i].second.second;
    w = ed[i].first;
    ed[i] = {d[u] + d[v] + w, {tr[u], tr[v]}};
  }
  sort(ed + 1, ed + m + 1);
  memset(lab, -1, sizeof(lab));
  for (int i = 1; i <= m; ++i) {
    u = ed[i].second.first;
    v = ed[i].second.second;
    w = ed[i].first;
    ru = phin(u);
    rv = phin(v);
    if (ru != rv) {
      uni(ru, rv);
      ke[u].push_back({w, v});
      ke[v].push_back({w, u});
    }
  }
  memset(f, -1, sizeof(f));
  dfs(1, 1, 0);
  f[1][0] = -1;
  khoitao();
  for (int i = 1; i <= Q; ++i) {
    cin >> u >> v;
    cout << lca(u, v) << '\n';
  }
  return 0;
}
