#include <bits/stdc++.h>
using namespace std;
struct P {
  int x, y, z;
};
queue<P> q;
inline void exi() {
  puts("-1");
  exit(0);
}
int n, m, k, i, j, l;
vector<vector<vector<int>>> a, inq, aa;
inline void inii(vector<vector<vector<int>>>& e0, int n, int m, int k) {
  e0.resize(n);
  for (auto& u : e0) {
    u.resize(m);
    for (auto& v : u) v.resize(k);
  }
}
vector<vector<int>> e1, e2, e3, c0, c1, c2, c3, c4, c5, cov0, cov1, cov2;
inline void ini(vector<vector<int>>& cov, vector<vector<int>>& c0,
                vector<vector<int>>& c1, int a, int b) {
  for (i = 0; i < a; ++i)
    for (j = 0; j < b; ++j) scanf("%d", &c0[i][j]);
  for (i = 0; i < a; ++i)
    for (j = 0; j < b; ++j) scanf("%d", &c1[i][j]);
  for (i = 0; i < a; ++i)
    for (j = 0; j < b; ++j) {
      bool f0 = c0[i][j] == 0, f1 = c1[i][j] == 0;
      if (f0 != f1) exi();
      if (f0) cov[i][j] = 1;
    }
}
struct aaa {
  vector<vector<vector<int>>> q;
  vector<vector<int>> h, t, c0, c1;
  int n, m, k, tp;
  void ini(int n, int m, int k, vector<vector<int>> zz, vector<vector<int>> c0,
           vector<vector<int>> c1) {
    inii(q, n, m, 0);
    h = t = zz;
    this->n = n;
    this->m = m;
    this->k = k;
    this->c0 = c0;
    this->c1 = c1;
  }
  void ini2() {
    for (int i = 0; i < n; ++i)
      for (int j = 0; j < m; ++j)
        h[i][j] = 0, t[i][j] = int(q[i][j].size()) - 1;
  }
  int getv(int x, int y, int z) {
    if (tp == 1) return a[z][x][y];
    if (tp == 2) return a[x][z][y];
    if (tp == 3) return a[x][y][z];
  }
  P getv2(int x, int y, int z) {
    if (tp == 1) return (P){z, x, y};
    if (tp == 2) return (P){x, z, y};
    if (tp == 3) return (P){x, y, z};
  }
  void pop(int x, int y) {
    for (; h[x][y] <= t[x][y];)
      if (getv(x, y, q[x][y][h[x][y]]) == 0)
        ++h[x][y];
      else if (getv(x, y, q[x][y][t[x][y]]) == 0)
        --t[x][y];
      else
        break;
  }
  int ask(int x, int y, int z) {
    pop(x, y);
    if (h[x][y] == t[x][y]) {
      if (c0[x][y] != c1[x][y]) exi();
      return c0[x][y];
    } else {
      if (z == q[x][y][h[x][y]]) return c0[x][y];
      if (z == q[x][y][t[x][y]]) return c1[x][y];
      return -1;
    }
  }
  void del(int x, int y, int z, vector<P>& ve) {
    pop(x, y);
    if (h[x][y] == t[x][y]) exi();
    if (z == q[x][y][h[x][y]]) {
      ++h[x][y];
      pop(x, y);
      ve.push_back(getv2(x, y, q[x][y][h[x][y]]));
    } else if (z == q[x][y][t[x][y]]) {
      --t[x][y];
      pop(x, y);
      ve.push_back(getv2(x, y, q[x][y][t[x][y]]));
    }
  }
} a1, a2, a3;
bool upd(int& a, int b) {
  if (a != -1 && b != -1 && a != b) return 0;
  if (b != -1) a = b;
  return 1;
}
void del(int x, int y, int z);
void trydel(int x, int y, int z) {
  int& c = a[x][y][z];
  if (!upd(c, a1.ask(y, z, x)) || !upd(c, a2.ask(x, z, y)) ||
      !upd(c, a3.ask(x, y, z)))
    del(x, y, z);
}
void del(int x, int y, int z) {
  vector<P> ve;
  a1.del(y, z, x, ve);
  a2.del(x, z, y, ve);
  a3.del(x, y, z, ve);
  a[x][y][z] = 0;
  for (auto u : ve)
    if (a[u.x][u.y][u.z] != 0) trydel(u.x, u.y, u.z);
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  inii(a, n, m, k);
  inii(inq, n, m, k);
  e1.resize(m);
  for (auto& u : e1) u.resize(k);
  e2.resize(n);
  for (auto& u : e2) u.resize(k);
  e3.resize(n);
  for (auto& u : e3) u.resize(m);
  cov0 = c0 = c1 = e1;
  ini(cov0, c0, c1, m, k);
  cov1 = c2 = c3 = e2;
  ini(cov1, c2, c3, n, k);
  cov2 = c4 = c5 = e3;
  ini(cov2, c4, c5, n, m);
  a1.ini(m, k, n, e1, c0, c1);
  a1.tp = 1;
  a2.ini(n, k, m, e2, c2, c3);
  a2.tp = 2;
  a3.ini(n, m, k, e3, c4, c5);
  a3.tp = 3;
  for (i = 0; i < n; ++i)
    for (j = 0; j < m; ++j)
      for (l = 0; l < k; ++l) {
        a[i][j][l] = cov0[j][l] || cov1[i][l] || cov2[i][j] ? 0 : -1;
        if (a[i][j][l] == -1) {
          a1.q[j][l].push_back(i);
          a2.q[i][l].push_back(j);
          a3.q[i][j].push_back(l);
        }
      }
  a1.ini2();
  a2.ini2();
  a3.ini2();
  for (i = 0; i < n; ++i)
    for (j = 0; j < m; ++j)
      for (l = 0; l < k; ++l)
        if (a[i][j][l] != 0) trydel(i, j, l);
  for (i = 0; i < n; ++i) {
    for (j = 0; j < m; ++j, puts(""))
      for (l = 0; l < k; ++l) {
        if (a[i][j][l] == -1) a[i][j][l] = 1;
        printf("%d ", a[i][j][l]);
      }
    puts("");
  }
  return 0;
}
