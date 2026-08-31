#include <bits/stdc++.h>
#pragma GCC optimize("O2")
using namespace std;
const int maxn = 1000 + 10, maxm = 1e6 + 100;
int n, m, q;
struct DSU {
  int par[maxn], mx = -1;
  bool c[maxn];
  vector<pair<int, int> > v;
  DSU() { fill(par, par + maxn, -1); }
  int root(int x) { return par[x] < 0 ? x : root(par[x]); }
  bool xr(int x) { return par[x] < 0 ? 0 : c[x] ^ xr(par[x]); }
  bool dis(int x, int y) { return xr(x) ^ xr(y); }
  bool merge(int x, int y, int w) {
    int xp = x, yp = y;
    x = root(x);
    y = root(y);
    bool cy = 1 ^ dis(x, xp) ^ dis(y, yp);
    if (x == y) {
      if (dis(xp, yp) == 0) {
        mx = max(mx, w);
      }
      return 0;
    }
    if (-par[x] < -par[y]) swap(x, y);
    v.push_back({y, par[y]});
    par[x] += par[y];
    par[y] = x;
    c[y] = cy;
    return 1;
  }
  void undo() {
    if (v.size() == 0) return;
    pair<int, int> p = v.back();
    v.pop_back();
    int y = p.first, x = par[y];
    c[y] = 0;
    par[y] = p.second;
    par[x] -= par[y];
  }
  void reset() {
    while (v.size()) {
      undo();
    }
    mx = -1;
  }
} dsu;
struct edge {
  int a, b, w;
} e[maxm];
struct Segment {
  vector<int> S[maxm << 2];
  int mx[maxm << 2];
  void merge(vector<int>& v, vector<int>& vl, vector<int>& vr) {
    dsu.reset();
    int pos[2] = {0, 0}, size[2] = {int(vl.size()), int(vr.size())};
    for (int i = 0; i < size[0] + size[1]; i++) {
      int x = 0;
      if (pos[0] == size[0]) {
        x = vr[pos[1]];
        pos[1]++;
      } else if (pos[1] == size[1]) {
        x = vl[pos[0]];
        pos[0]++;
      } else {
        if (e[vl[pos[0]]].w > e[vr[pos[1]]].w) {
          x = vl[pos[0]];
          pos[0]++;
        } else {
          x = vr[pos[1]];
          pos[1]++;
        }
      }
      if (dsu.merge(e[x].a, e[x].b, e[x].w)) {
        v.push_back(x);
      }
    }
  }
  void Build(int id = 1, int l = 0, int r = m) {
    if (r - l == 1) {
      S[id].push_back(l);
      mx[id] = -1;
      return;
    }
    int mid = (l + r) >> 1;
    Build(id << 1, l, mid);
    Build(id << 1 | 1, mid, r);
    merge(S[id], S[id << 1], S[id << 1 | 1]);
    mx[id] = max(dsu.mx, max(mx[id << 1], mx[id << 1 | 1]));
  }
  vector<int> v[2];
  int now = 1, pre = 0, ans = -1;
  void get(int L, int R, int id = 1, int l = 0, int r = m) {
    if (L >= r || R <= l) return;
    if (L <= l && R >= r) {
      swap(now, pre);
      v[now].clear();
      merge(v[now], v[pre], S[id]);
      ans = max(ans, max(dsu.mx, mx[id]));
      return;
    }
    int mid = (l + r) >> 1;
    get(L, R, id << 1, l, mid);
    get(L, R, id << 1 | 1, mid, r);
  }
} seg;
int32_t main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d", &e[i].a, &e[i].b, &e[i].w);
    e[i].a--;
    e[i].b--;
  }
  seg.Build();
  for (int i = 0; i < q; i++) {
    seg.ans = -1;
    int l, r;
    scanf("%d%d", &l, &r);
    l--;
    seg.v[0].clear();
    seg.v[1].clear();
    seg.get(l, r);
    printf("%d\n", seg.ans);
  }
}
