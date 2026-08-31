#include <bits/stdc++.h>
using namespace std;
const int jsb = 1000000007;
const int N = 105;
int g[2][2][N][N][N];
int f[N][N][2];
int n, m;
int ans[N];
vector<int> xu[N * N];
int st[N * N], ed[N * N];
int go[N][N];
inline void add(int &x, int y) {
  x += y;
  if (x >= jsb) x -= jsb;
}
pair<int, int> GOGOGO(vector<int> &tp, int x, bool fan) {
  int now = 0;
  while (now + 1 <= tp.size()) {
    int y = tp[now];
    int bian = go[x][y];
    if (!bian || tp.size() > 2 * n || (bian > m) != fan)
      return pair<int, int>(10086, -1);
    for (int j = (0); j <= (int)xu[bian].size() - 1; j++)
      tp.push_back(xu[bian][j]);
    x = y;
    now++;
  }
  return pair<int, int>(tp.size(), x);
}
void Read() {
  scanf("%d%d", &n, &m);
  for (int i = (1); i <= (int)m; i++) {
    int x, y, k;
    scanf("%d%d%d", &x, &y, &k);
    go[x][y] = i;
    st[i] = x;
    ed[i] = y;
    for (int j = (1); j <= (int)k; j++) {
      int v;
      scanf("%d", &v);
      xu[i].push_back(v);
    }
    go[y][x] = i + m;
    st[i + m] = y;
    ed[i + m] = x;
    for (int j = (k - 1); j >= (int)0; j--) xu[i + m].push_back(xu[i][j]);
    if (k == 0) g[0][0][x][y][1]++;
  }
}
int man[N][N][N];
int wei[N][N][N];
void work(bool fan) {
  memset(man, 0, sizeof man);
  memset(wei, 0, sizeof wei);
  for (int i = (1); i <= (int)2 * m; i++)
    if ((i <= m) ^ fan) {
      for (int j = (0); j <= (int)xu[i].size() - 1; j++)
        if (xu[i][j] == st[i]) {
          vector<int> t1, t2;
          for (int k = (j - 1); k >= (int)0; k--) t1.push_back(xu[i][k]);
          pair<int, int> result = GOGOGO(t1, st[i], fan ^ 1);
          if (result.first > 2 * n) continue;
          if (j + 1 == xu[i].size())
            wei[result.second][ed[i]][result.first + 1]++;
          else {
            if (xu[i][j + 1] != ed[i]) continue;
            for (int k = (j + 2); k <= (int)xu[i].size() - 1; k++)
              t2.push_back(xu[i][k]);
            pair<int, int> res2 = GOGOGO(t2, ed[i], fan);
            if (res2.first + 1 + result.first <= 2 * n)
              man[result.second][res2.second][res2.first + 1 + result.first]++;
          }
        }
    }
}
void GetG() {
  work(0);
  for (int i = (1); i <= (int)n; i++)
    for (int j = (1); j <= (int)n; j++)
      for (int k = (1); k <= (int)2 * n; k++) {
        g[1][1][i][j][k] = man[i][j][k];
        g[1][0][i][j][k] = wei[i][j][k];
      }
  work(1);
  for (int i = (1); i <= (int)n; i++)
    for (int j = (1); j <= (int)n; j++)
      for (int k = (1); k <= (int)2 * n; k++) g[0][1][j][i][k] = wei[i][j][k];
}
void Solve() {
  for (int i = (1); i <= (int)n; i++)
    for (int j = (1); j <= (int)n; j++)
      for (int k = (1); k <= (int)2 * n; k++)
        for (int v = (0); v <= (int)1; v++) add(f[k][j][v], g[1][v][i][j][k]);
  int rp;
  for (int k = (1); k <= (int)n * 2; k++) {
    rp = 0;
    for (int i = (1); i <= (int)n; i++) {
      add(rp, f[k][i][1]);
      for (int mid = (0); mid <= (int)1; mid++)
        if (f[k][i][mid]) {
          for (int ed = (0); ed <= (int)1; ed++)
            for (int zd = (1); zd <= (int)n; zd++)
              for (int len = (1); len <= (int)2 * n - k; len++)
                add(f[k + len][zd][ed],
                    f[k][i][mid] * 1ll * g[mid ^ 1][ed][i][zd][len] % jsb);
        }
    }
    printf("%d\n", rp);
  }
}
int main() {
  Read();
  GetG();
  Solve();
  return 0;
}
