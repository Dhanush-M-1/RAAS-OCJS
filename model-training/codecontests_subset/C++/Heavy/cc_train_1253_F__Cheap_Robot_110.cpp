#include <bits/stdc++.h>
#pragma GCC target("avx2")
#pragma GCC optimization("O3")
#pragma GCC optimization("unroll-loops")
const long long INF = 0x3f3f3f3f3f3f3f3f;
const long long llinf = (1LL << 62);
const int inf = (1 << 30);
const int nmax = 3e5 + 50;
const long long mod = 1e9 + 7;
using namespace std;
int n, m, k, q, i, x, y, sz[nmax], p[nmax], ex[nmax], ey[nmax];
long long w, ew[nmax], d[nmax], rs[nmax];
vector<pair<int, int> > qr[nmax], tmp;
vector<pair<int, long long> > a[nmax];
vector<pair<long long, pair<int, int> > > vc;
set<pair<long long, int> > s;
vector<int> v[nmax];
int fnd(int x) {
  if (p[x] == x) return x;
  return p[x] = fnd(p[x]);
}
void uni(int x, int y, long long w) {
  x = fnd(x), y = fnd(y);
  if (sz[x] < sz[y]) swap(x, y);
  int u;
  for (int i = 0; i < (int)v[y].size(); i++) {
    u = v[y][i];
    tmp.clear();
    for (int j = 0; j < (int)qr[u].size(); j++) {
      if (fnd(qr[u][j].first) == x)
        rs[qr[u][j].second] = w;
      else
        tmp.push_back(qr[u][j]);
    }
    qr[u] = tmp;
    v[x].push_back(u);
  }
  for (int i = 0; i < (int)v[y].size(); i++) {
    u = v[y][i];
    p[u] = x;
  }
  v[y].clear();
  sz[x] += sz[y];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cerr.tie(0);
  cout.tie(0);
  cin >> n >> m >> k >> q;
  for (i = 1; i <= m; i++) {
    cin >> ex[i] >> ey[i] >> ew[i];
    a[ex[i]].push_back(make_pair(ey[i], ew[i]));
    a[ey[i]].push_back(make_pair(ex[i], ew[i]));
  }
  for (i = k + 1; i <= n; i++) d[i] = llinf;
  for (i = 1; i <= k; i++) s.insert(make_pair(d[i], i));
  while (!s.empty()) {
    x = s.begin()->second;
    s.erase(s.begin());
    for (i = 0; i < (int)a[x].size(); i++) {
      y = a[x][i].first, w = a[x][i].second;
      if (d[y] > d[x] + w) {
        if (d[y] != llinf) s.erase(s.find(make_pair(d[y], y)));
        d[y] = d[x] + w;
        s.insert(make_pair(d[y], y));
      }
    }
  }
  for (i = 1; i <= m; i++) {
    vc.push_back(
        make_pair(d[ex[i]] + d[ey[i]] + ew[i], make_pair(ex[i], ey[i])));
  }
  sort(vc.begin(), vc.end());
  for (i = 1; i <= q; i++) {
    cin >> x >> y;
    qr[x].push_back(make_pair(y, i));
    qr[y].push_back(make_pair(x, i));
  }
  for (i = 1; i <= n; i++) {
    sz[i] = 1;
    p[i] = i;
    v[i].push_back(i);
  }
  for (i = 0; i < m; i++) {
    x = vc[i].second.first, y = vc[i].second.second, w = vc[i].first;
    if (fnd(x) == fnd(y)) continue;
    uni(x, y, w);
  }
  for (i = 1; i <= q; i++) cout << rs[i] << '\n';
  return 0;
}
