#include <bits/stdc++.h>
using namespace std;
inline int read() {
  register int x = 0, f = 1;
  register char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = 0;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + (ch ^ '0');
    ch = getchar();
  }
  return f ? x : -x;
}
const int mod = 1e9 + 7;
int n, m, num, have[51][51], f[101][2][51];
vector<int> e[51][51], te[51][51], tmp, ans, trans[2][2][51][51];
inline void inc(int& x, int y) { x = x + y < mod ? x + y : x + y - mod; }
int dfs_0(int u, int len, vector<int>& E) {
  if (len >= (int)(E).size()) return u * (len == (int)(E).size());
  int v = E[len];
  if (!have[v][u]) return 0;
  E.insert(E.end(), te[u][v].begin(), te[u][v].end());
  return dfs_0(v, len + 1, E);
}
int dfs_1(int u, int len, vector<int>& E) {
  if (len >= (int)(E).size()) return u * (len == (int)(E).size());
  int v = E[len];
  if (!have[u][v]) return 0;
  E.insert(E.end(), e[u][v].begin(), e[u][v].end());
  return dfs_1(v, len + 1, E);
}
void get_00() {
  for (int i = (1), _ed = (n); i <= _ed; ++i)
    for (int j = (1), _ed = (n); j <= _ed; ++j)
      if ((int)(e[i][j]).size() && e[i][j].back() == i) {
        tmp.clear();
        tmp.insert(tmp.end(), te[j][i].begin(), te[j][i].end());
        int s = dfs_0(i, 1, tmp);
        if (s) trans[0][0][s][j].push_back((int)(tmp).size());
      }
}
void get_01() {
  static vector<int> res;
  for (int i = (1), _ed = (n); i <= _ed; ++i)
    for (int j = (1), _ed = (n); j <= _ed; ++j)
      if ((int)(e[i][j]).size() > 1) {
        int a = -1;
        while (a < (int)(e[i][j]).size() - 1) {
          for (++a; a < (int)(e[i][j]).size() - 1; ++a)
            if (e[i][j][a] == i && e[i][j][a + 1] == j) break;
          if (a >= (int)(e[i][j]).size() - 1) break;
          tmp.clear();
          tmp.insert(tmp.end(), e[i][j].begin(), e[i][j].begin() + a + 1);
          reverse(tmp.begin(), tmp.end());
          int s = dfs_0(i, 1, tmp);
          res = tmp, reverse(res.begin(), res.end());
          tmp.clear();
          tmp.insert(tmp.end(), e[i][j].begin() + a + 1, e[i][j].end());
          int t = dfs_1(j, 1, tmp);
          res.insert(res.end(), tmp.begin(), tmp.end());
          if (s && t) {
            trans[0][1][s][t].push_back((int)(res).size() - 1);
            if (!(int)(ans).size()) ans = res;
          }
        }
      }
}
void get_10() {
  for (int i = (1), _ed = (n); i <= _ed; ++i)
    for (int j = (1), _ed = (n); j <= _ed; ++j)
      if (have[i][j] && !(int)(e[i][j]).size()) trans[1][0][i][j].push_back(1);
}
void get_11() {
  for (int i = (1), _ed = (n); i <= _ed; ++i)
    for (int j = (1), _ed = (n); j <= _ed; ++j)
      if ((int)(e[i][j]).size() && e[i][j][0] == j) {
        tmp.clear();
        tmp.insert(tmp.end(), e[i][j].begin(), e[i][j].end());
        int s = dfs_1(j, 1, tmp);
        if (s) trans[1][1][i][s].push_back((int)(tmp).size());
      }
}
int main() {
  n = read(), m = read();
  for (int i = (1), _ed = (m); i <= _ed; ++i) {
    int u = read(), v = read(), k = read();
    have[u][v] = 1;
    for (int i = (1), _ed = (k); i <= _ed; ++i) e[u][v].push_back(read());
    te[v][u] = e[u][v];
    reverse(te[v][u].begin(), te[v][u].end());
  }
  get_00(), get_01(), get_10(), get_11();
  for (int i = (1), _ed = (n); i <= _ed; ++i) f[0][0][i] = 1;
  for (int l = (0), _ed = (n + n - 1); l <= _ed; ++l)
    for (int p = (0), _ed = (1); p <= _ed; ++p)
      for (int u = (1), _ed = (n); u <= _ed; ++u)
        if (f[l][p][u]) {
          for (int q = (0), _ed = (1); q <= _ed; ++q)
            for (int v = (1), _ed = (n); v <= _ed; ++v)
              if ((int)(trans[p][q][u][v]).size())
                for (int x : trans[p][q][u][v])
                  if (l + x <= n + n) inc(f[l + x][q][v], f[l][p][u]);
        }
  for (int l = (1), _ed = (n + n); l <= _ed; ++l) {
    int ans = 0;
    for (int i = (1), _ed = (n); i <= _ed; ++i) inc(ans, f[l][1][i]);
    printf("%d\n", ans);
  }
  return 0;
}
