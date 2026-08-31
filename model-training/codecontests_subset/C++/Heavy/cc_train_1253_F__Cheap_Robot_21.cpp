#include <bits/stdc++.h>
using namespace std;
const long double PI = 3.14159265359;
const long long MOD = (long long)998244353ll;
const long long MAXN = (long long)3e5 + 10;
const long long INF = (long long)2242545357980376863;
const long double EPS = (long double)1e-8;
long long source[MAXN], d0[MAXN], dis[MAXN], done[MAXN], par[MAXN];
vector<long long> C[MAXN];
vector<pair<long long, long long> > G[MAXN];
vector<pair<long long, pair<long long, long long> > > E;
set<pair<long long, long long> > dj;
void change_key(long long node, long long last, long long now) {
  dj.erase({last, node});
  dis[node] = now;
  dj.insert({now, node});
  return;
}
long long A[MAXN], B[MAXN], ans[MAXN];
long long W;
long long get_par(long long u) {
  if (par[u] == u) return u;
  return par[u] = get_par(par[u]);
}
bool merge(long long u, long long v) {
  long long U = u, V = v;
  u = get_par(u);
  v = get_par(v);
  if (u == v) return false;
  if (C[u].size() < C[v].size()) swap(u, v);
  par[v] = u;
  for (auto x : C[v]) {
    C[u].push_back(x);
    if (get_par(A[x]) == get_par(B[x])) ans[x] = min(ans[x], W);
  }
  C[v].clear();
  return true;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  memset(ans, 31, sizeof ans);
  for (int i = 0; i < MAXN; i++) par[i] = i;
  memset(dis, 31, sizeof dis);
  memset(d0, 31, sizeof d0);
  long long n, m, k, q;
  scanf("%lld%lld%lld%lld", &n, &m, &k, &q);
  long long u, v, w;
  for (int i = 0; i < m; i++) {
    scanf("%lld%lld%lld", &u, &v, &w);
    G[u].push_back({v, w});
    G[v].push_back({u, w});
  }
  long long p, f;
  for (int i = 1; i <= k; i++) {
    p = i;
    source[p] = p;
    dj.insert({0, p});
    dis[p] = 0;
  }
  long long fr, d, adj;
  while (dj.size()) {
    d = (*dj.begin()).first;
    fr = (*dj.begin()).second;
    dj.erase(dj.begin());
    for (auto edge : G[fr]) {
      adj = edge.first;
      w = edge.second;
      if (done[adj] == 1) {
        E.push_back({dis[adj] + dis[fr] + w, {source[fr], source[adj]}});
      }
      if (dis[adj] > d + w) {
        change_key(adj, dis[adj], d + w);
        source[adj] = source[fr];
      }
    }
    done[fr] = 1;
  }
  for (int i = 0; i < q; i++) {
    scanf("%lld%lld", A + i, B + i);
    C[A[i]].push_back(i);
    C[B[i]].push_back(i);
  }
  sort(E.begin(), E.end());
  for (auto edge : E) {
    W = edge.first;
    if (merge(edge.second.first, edge.second.second)) {
    }
  }
  for (int i = 0; i < q; i++) printf("%lld\n", ans[i]);
  return 0;
}
