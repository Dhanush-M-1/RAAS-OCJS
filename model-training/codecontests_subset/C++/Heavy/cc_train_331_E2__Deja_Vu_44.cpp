#include <bits/stdc++.h>
using namespace std;
const int N = 110, D = 100010;
const int mod = 1e9 + 7;
int n, m, e[N][N], rv, rl, id[2][N][N], dn, ans[N];
int sv[D], svt, de[D], dp[D];
vector<int> tp[D], dv[N][N];
void inc(int &a, int b) {
  if (a += b, a >= mod) a -= mod;
}
void go(int u, int ty) {
  rv = -1, rl = 0;
  while (rl + 1 <= svt && rl <= 2 * n) {
    int v = sv[++rl];
    if (e[u][v] != ty) return;
    for (int j = 0, jt = dv[u][v].size(); j < jt; ++j) sv[++svt] = dv[u][v][j];
    u = v;
  }
  rv = u;
  if (rl > 2 * n) rv = -1;
}
void link(int u, int v) { tp[u].push_back(v), ++de[v]; }
void trans(int *u, int *v, int l) {
  for (int i = 0; i + l <= 2 * n; ++i) link(u[i], v[i + l]);
}
void build() {
  for (int u = 1; u <= n; ++u)
    for (int v = 1; v <= n; ++v) {
      vector<int> ls = dv[u][v];
      if (e[u][v] == 1) {
        for (int j = 0, jt = ls.size(); j + 1 < jt; ++j)
          if (ls[j] == u && ls[j + 1] == v) {
            int len = 0, uu, vv;
            svt = 0;
            for (int jj = j - 1; jj >= 0; --jj) sv[++svt] = ls[jj];
            go(u, -1), uu = rv, len += rl;
            svt = 0;
            for (int jj = j + 2; jj < jt; ++jj) sv[++svt] = ls[jj];
            go(v, 1), vv = rv, len += rl;
            if (uu > 0 && vv > 0 && len <= 2 * n)
              trans(id[1][uu], id[0][vv], len + 1);
            break;
          }
        if (!ls.size()) {
          trans(id[0][u], id[1][v], 1);
        } else if (ls[0] == v) {
          svt = 0;
          for (int j = 1, jt = ls.size(); j < jt; ++j) sv[++svt] = ls[j];
          go(v, 1);
          if (rv > 0) trans(id[0][u], id[0][rv], rl + 1);
        }
      }
      if (e[u][v] == -1 && ls.size() && ls[0] == v) {
        svt = 0;
        for (int j = 1, jt = ls.size(); j < jt; ++j) sv[++svt] = ls[j];
        go(v, -1);
        if (rv > 0) trans(id[1][rv], id[1][u], rl + 1);
      }
    }
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= m; ++i) {
    int u, v, k, x;
    scanf("%d %d %d", &u, &v, &k);
    e[u][v] = 1, e[v][u] = -1;
    for (int j = 0; j < k; ++j) {
      scanf("%d", &x);
      dv[u][v].push_back(x);
    }
    for (int j = 0; j < k; ++j) dv[v][u].push_back(dv[u][v][k - 1 - j]);
  }
  for (int i = 1; i <= n; ++i)
    for (int l = 0; l <= 2 * n; ++l) {
      id[1][i][l] = ++dn;
      if (!l) dp[dn] = 1;
      id[0][i][l] = ++dn;
    }
  build();
  svt = 0;
  for (int i = 1; i <= dn; ++i)
    if (!de[i]) sv[++svt] = i;
  while (svt) {
    int u = sv[svt--], v;
    for (int j = 0, jt = tp[u].size(); j < jt; ++j) {
      v = tp[u][j];
      inc(dp[v], dp[u]);
      if (--de[v] == 0) sv[++svt] = v;
    }
  }
  for (int i = 1; i <= n; ++i)
    for (int l = 1; l <= 2 * n; ++l) {
      inc(ans[l], dp[id[0][i][l]]);
    }
  for (int i = 1; i <= 2 * n; ++i) printf("%d\n", ans[i]);
}
