#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
vector<bool> vs, bs;
vector<int> en, ex, lev, ror, go, wa;
int vos;
bool ye;
int dord;
vector<vector<int> > g, h;
void dfa(int u) {
  bs[u] = true;
  en[u] = dord;
  dord++;
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    if (vs[v]) {
      if (!bs[v]) {
        ye = false;
      }
    } else {
      vos++;
      vs[v] = true;
      lev[v] = lev[u] + 1;
      dfa(v);
    }
  }
  bs[u] = false;
  ex[u] = dord;
  dord++;
}
void hh(int u) {
  for (int i = 0; i < h[u].size(); i++) {
    int v = h[u][i];
    if (!vs[v]) {
      vs[v] = true;
      hh(v);
    }
  }
}
int dfb(int u) {
  int mu = -1, ma = 1e9;
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    if (lev[v] < lev[u]) {
      go[en[v]]++;
      go[ex[u] - 1]--;
      if (lev[v] < ma) {
        mu = v;
        ma = lev[v];
      }
    } else {
      int ok = dfb(v);
      if (ok != -1 && lev[ok] < ma) {
        ma = lev[ok];
        mu = ok;
      }
    }
  }
  if (mu != -1 && lev[mu] < lev[u]) {
    wa[u] = mu;
  } else {
    wa[u] = -1;
  }
  return mu;
}
void dfc(int u, int r) {
  if (wa[u] >= 0) {
    vs[u] = (vs[u] && vs[wa[u]]);
  } else {
    vs[u] = 0;
  }
  if (u == r) {
    vs[u] = true;
  }
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    if (lev[v] > lev[u]) {
      dfc(v, r);
    }
  }
}
bool det(int u) {
  dord = 0;
  vos = 1;
  vs.assign(g.size(), 0);
  vs[u] = true;
  ye = true;
  lev[u] = 0;
  dfa(u);
  if (vos < g.size()) {
    return false;
  }
  return ye;
}
int main() {
  int N;
  cin >> N;
  while (N--) {
    int n, m;
    cin >> n >> m;
    g.assign(n, vector<int>());
    h.assign(n, vector<int>());
    lev.assign(g.size(), 0);
    en.assign(g.size(), 0);
    ex.assign(g.size(), 0);
    vs.assign(g.size(), 0);
    bs.assign(g.size(), 0);
    go.assign(g.size(), 0);
    for (int i = 0; i < m; i++) {
      int a, b;
      cin >> a >> b;
      a--;
      b--;
      g[a].push_back(b);
      h[b].push_back(a);
    }
    ror.clear();
    for (int i = 0; i < n; i++) {
      ror.push_back(i);
    }
    shuffle(ror.begin(), ror.end(), rng);
    int te = min(70, int(ror.size()));
    int ro = -1;
    for (int i = 0; i < te; i++) {
      if (det(ror[i])) {
        ro = ror[i];
        break;
      }
    }
    vector<int> ans;
    if (ro != -1) {
      go.assign(dord, 0);
      vs.assign(n, 0);
      wa.assign(n, 0);
      hh(ro);
      dfb(ro);
      int rs = 0;
      for (int i = 0; i < dord; i++) {
        int te = rs + go[i];
        go[i] = rs;
        rs = te;
      }
      for (int i = 0; i < n; i++) {
        if (go[en[i]] - go[ex[i]] != 1) {
          vs[i] = false;
        }
      }
      vs[ro] = 1;
      dfc(ro, ro);
      vs[ro] = 1;
      for (int i = 0; i < n; i++) {
        if (vs[i]) {
          ans.push_back(i);
        }
      }
    }
    if (ans.size() * 5 < n) {
      cout << -1 << '\n';
    } else {
      for (int i = 0; i < ans.size(); i++) {
        if (i > 0) {
          cout << " ";
        }
        cout << ans[i] + 1;
      }
      cout << '\n';
    }
  }
}
