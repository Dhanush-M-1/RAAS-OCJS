#include <bits/stdc++.h>
using namespace std;
int Read() {
  char c;
  while (c = getchar(), (c != '-') && (c < '0' || c > '9'))
    ;
  bool neg = (c == '-');
  int ret = (neg ? 0 : c - 48);
  while (c = getchar(), c >= '0' && c <= '9') ret = ret * 10 + c - 48;
  return neg ? -ret : ret;
}
const int MAXN = 55, MOD = 7 + 1e9;
vector<pair<int, int> > h[MAXN], t[MAXN];
vector<int> g[MAXN][MAXN];
bool con[MAXN][MAXN];
int N, M, tail, q[MAXN * 4];
int b[MAXN * 2][MAXN][MAXN], f[MAXN * 2][MAXN], c[MAXN * 2][MAXN][MAXN];
void init() {
  scanf("%d%d", &N, &M);
  for (int i = 1; i <= M; i++) {
    int u = Read(), v = Read(), k = Read();
    con[u][v] = 1;
    for (int j = 1; j <= k; j++) {
      int x = Read();
      g[u][v].push_back(x);
    }
  }
}
bool Expand() {
  for (int head = 1; head <= tail - 1; head++) {
    int x = q[head], y = q[head + 1];
    if (con[x][y]) {
      for (int k = 0; k <= (int)g[x][y].size() - 1; k++) q[++tail] = g[x][y][k];
      if (tail > 2 * N) return 0;
    } else
      return 0;
  }
  return 1;
}
bool RExpand() {
  for (int head = 1; head <= tail - 1; head++) {
    int x = q[head], y = q[head + 1];
    if (con[y][x]) {
      for (int k = (int)g[y][x].size() - 1; k >= 0; k--) q[++tail] = g[y][x][k];
      if (tail > 2 * N) return 0;
    } else
      return 0;
  }
  return 1;
}
void Add(int &x, int y) { x += y, x -= (x >= MOD ? MOD : 0); }
void work() {
  for (int i = 1; i <= N; i++)
    for (int j = 1; j <= N; j++)
      if (con[i][j] && g[i][j].size()) {
        if (g[i][j].back() == i) {
          tail = 0;
          for (int k = g[i][j].size() - 1; k >= 0; k--) q[++tail] = g[i][j][k];
          if (RExpand()) h[j].push_back(make_pair(tail, q[tail]));
        }
        if (g[i][j][0] == j) {
          tail = 0;
          for (int k = 0; k <= g[i][j].size() - 1; k++) q[++tail] = g[i][j][k];
          if (Expand()) t[i].push_back(make_pair(tail, q[tail]));
        }
        if (g[i][j].size() > 1) {
          for (int k = 1; k <= g[i][j].size() - 1; k++)
            if (g[i][j][k - 1] == i && g[i][j][k] == j) {
              tail = 0;
              for (int p = k - 1; p >= 0; p--) q[++tail] = g[i][j][p];
              if (RExpand()) {
                int tl = tail, tp = q[tail];
                tail = 0;
                for (int p = k; p <= g[i][j].size() - 1; p++)
                  q[++tail] = g[i][j][p];
                if (Expand() && tl + tail - 1 <= 2 * N)
                  ++b[tl + tail - 1][tp][q[tail]];
              }
              break;
            }
        }
      }
  for (int l = 1; l <= 2 * N - 1; l++)
    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= N; j++)
        if (b[l][i][j])
          for (int k = 0; k <= (int)h[i].size() - 1; k++) {
            int x = h[i][k].first, y = h[i][k].second;
            if (l + x <= 2 * N) Add(b[l + x][y][j], b[l][i][j]);
          }
  for (int l = 1; l <= 2 * N - 1; l++)
    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= N; j++)
        if (b[l][i][j])
          for (int k = 0; k <= (int)t[j].size() - 1; k++) {
            int x = t[j][k].first, y = t[j][k].second;
            if (l + x <= 2 * N) Add(b[l + x][i][y], b[l][i][j]);
          }
  for (int l = 1; l <= 2 * N; l++)
    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= N; j++) Add(f[l][j], b[l][i][j]);
  for (int l = 1; l <= 2 * N; l++)
    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= N; j++)
        if (b[l][i][j])
          for (int k = 1; k <= N; k++)
            if (con[k][i] && !g[k][i].size()) Add(c[l + 1][k][j], b[l][i][j]);
  for (int l1 = 1; l1 <= 2 * N; l1++)
    for (int i = 1; i <= N; i++)
      if (f[l1][i])
        for (int l2 = 1; l2 <= 2 * N - l1; l2++)
          for (int j = 1; j <= N; j++)
            Add(f[l1 + l2][j], (long long)f[l1][i] * c[l2][i][j] % MOD);
  for (int i = 1; i <= 2 * N; i++) {
    int ans = 0;
    for (int j = 1; j <= N; j++) Add(ans, f[i][j]);
    printf("%d\n", ans);
  }
}
int main() {
  init();
  work();
  return 0;
}
