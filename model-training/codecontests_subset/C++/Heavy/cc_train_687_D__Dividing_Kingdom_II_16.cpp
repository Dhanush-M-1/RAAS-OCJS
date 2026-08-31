#include <bits/stdc++.h>
using namespace std;
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
long long int myRand(long long int B) { return (unsigned long long)rng() % B; }
struct UnionFind {
  vector<int> par, num;
  vector<bool> done;
  UnionFind(int n) : par(n), num(n, 1), done(n, false) {
    iota(par.begin(), par.end(), 0);
  }
  int find(int v) { return (par[v] == v) ? v : (par[v] = find(par[v])); }
  void unite(int u, int v) {
    u = find(u), v = find(v);
    if (u == v) return;
    if (num[u] < num[v]) swap(u, v);
    num[u] += num[v];
    par[v] = u;
    done[u] = done[u] | done[v];
  }
  bool same(int u, int v) { return find(u) == find(v); }
  bool ispar(int v) { return v = find(v); }
  int size(int v) { return num[find(v)]; }
};
const int BS = 524288;
int CNT, rc;
char inb[BS];
inline char gchar(void) {
  if (CNT % BS == 0) {
    CNT = 0;
    rc = fread(inb, 1, BS, stdin);
  }
  return CNT < rc ? inb[CNT++] : 0;
}
inline int _readint(int *ptr) {
  int n = 0, c = 0;
  *ptr = 0;
  while (1) {
    char read = gchar();
    if (read >= '0' && read <= '9')
      read -= '0', n *= 10, n += read;
    else {
      *ptr = n;
      return n == 0 ? 0 : !c;
    }
    c++;
  }
  *ptr = n;
  return 0;
}
inline int readint(void) {
  int ptr;
  while (_readint(&ptr))
    ;
  return ptr;
}
int main() {
  cin.tie(nullptr);
  ios::sync_with_stdio(false);
  int n, m, q;
  cin >> n >> m >> q;
  vector<int> x(m), y(m), w(m);
  vector<pair<int, int>> v(m);
  for (int i = 0; i < m; i++) {
    cin >> x[i] >> y[i] >> w[i];
    x[i]--;
    y[i]--;
    v[i] = make_pair(w[i], i);
  }
  sort(v.rbegin(), v.rend());
  while (q--) {
    int l, r;
    cin >> l >> r;
    l--;
    int res = -1;
    UnionFind uf(2 * n);
    for (int i = 0; i < v.size(); i++) {
      if (v[i].second < l || r <= v[i].second) continue;
      int id = v[i].second;
      if (uf.same(x[id], y[id])) {
        res = v[i].first;
        break;
      } else {
        uf.unite(x[id], y[id] + n);
        uf.unite(x[id] + n, y[id]);
      }
    }
    printf("%d\n", res);
  }
}
