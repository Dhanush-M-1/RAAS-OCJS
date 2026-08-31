#include <bits/stdc++.h>
using namespace std;
const int N = 1005;
int n, m, q, u, v, w, l, r, ans, par[N], col[N], mark[N];
vector<pair<int, pair<int, int> > > yal, edge[N * N];
vector<int> cmp[N];
void add(int x) {
  for (int i = 0; i < edge[x].size(); i++) yal.push_back(edge[x][i]);
}
int Get_par(int u) {
  if (par[u] < 0) return u;
  return par[u] = Get_par(par[u]);
}
void query(int l, int r) {
  r++;
  for (l += m, r += m; l < r; l >>= 1, r >>= 1) {
    if (l & 1) add(l++);
    if (r & 1) add(--r);
  }
}
void reset(int x) {
  cmp[x].clear();
  cmp[x].push_back(x);
}
void merge(int u, int v, int s) {
  u = Get_par(u), v = Get_par(v);
  if (par[u] > par[v]) swap(u, v);
  for (int i = 0; i < cmp[v].size(); i++)
    cmp[u].push_back(cmp[v][i]), col[cmp[v][i]] ^= s;
  par[u] += par[v], par[v] = u;
}
void solve(int x) {
  vector<pair<int, pair<int, int> > > vec;
  for (int i = 0; i < edge[x].size(); i++)
    par[edge[x][i].second.first] = par[edge[x][i].second.second] = -1,
    reset(edge[x][i].second.first), reset(edge[x][i].second.second);
  for (int i = 0; i < edge[x].size(); i++) {
    u = edge[x][i].second.first, v = edge[x][i].second.second;
    if (Get_par(u) == Get_par(v)) {
      if (col[u] == col[v]) {
        vec.push_back(edge[x][i]);
        break;
      }
    } else
      merge(u, v, col[u] == col[v]), vec.push_back(edge[x][i]);
  }
  edge[x].clear();
  edge[x] = vec;
}
void merge_t(int u, int v, int an) {
  int p1 = 0, p2 = 0;
  while (p1 < edge[u].size() || p2 < edge[v].size()) {
    if (p2 == edge[v].size() ||
        (p1 < edge[u].size() && edge[u][p1].first > edge[v][p2].first))
      edge[an].push_back(edge[u][p1++]);
    else
      edge[an].push_back(edge[v][p2++]);
  }
}
void build() {
  for (int i = m - 1; i >= 1; i--) {
    merge_t(i * 2, i * 2 + 1, i);
    solve(i);
  }
}
void clear() {
  ans = -1, yal.clear();
  fill(col, col + N, 0);
  fill(par, par + N, -1);
  for (int i = 1; i < n + 1; i++) reset(i);
}
int main() {
  cin >> n >> m >> q;
  for (int i = 0; i < m; i++) {
    scanf("%d%d", &u, &v);
    ;
    scanf("%d", &w);
    ;
    edge[i + m].push_back(make_pair(w, make_pair(u, v)));
  }
  build();
  for (int io = 0; io < q; io++) {
    clear();
    scanf("%d%d", &l, &r);
    ;
    --l, --r;
    query(l, r);
    sort(yal.begin(), yal.end());
    reverse(yal.begin(), yal.end());
    for (int i = 0; i < yal.size(); i++) {
      u = yal[i].second.first, v = yal[i].second.second;
      if (Get_par(u) == Get_par(v)) {
        if (col[u] == col[v]) {
          ans = yal[i].first;
          break;
        }
      } else
        merge(u, v, col[u] == col[v]);
    }
    cout << ans << '\n';
  }
}
