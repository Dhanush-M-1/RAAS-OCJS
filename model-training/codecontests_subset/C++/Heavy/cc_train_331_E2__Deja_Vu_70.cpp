#include <bits/stdc++.h>
using namespace std;
const int mo = 1000000007;
const double pi = acos(-1);
int n, m;
int trans[2][2][105][105][2 * 105], f[2 * 105][105][2];
int E[105][105], A[105][105][2 * 105], B[105][105][2 * 105], X[105 * 105],
    Y[105 * 105];
vector<int> V[105 * 105];
void Plus(int &x, int y) {
  x += y;
  if (x >= mo) x -= mo;
}
pair<int, int> Get_chain(vector<int> &t, int x, bool flag) {
  int i = 0;
  while (i + 1 <= t.size()) {
    int y = t[i], p = E[x][y];
    if (!p || t.size() > 2 * n || (p > m) != flag)
      return make_pair(1 << 20, -1);
    for (int j = 0; j < V[p].size(); ++j) t.push_back(V[p][j]);
    x = y;
    i++;
  }
  return make_pair(t.size(), x);
}
void work(bool flag) {
  memset(A, 0, sizeof(A));
  memset(B, 0, sizeof(B));
  for (int i = 1; i <= 2 * m; ++i)
    if ((i > m) == flag) {
      for (int j = 0; j < V[i].size(); ++j)
        if (V[i][j] == X[i]) {
          vector<int> t1, t2;
          for (int k = j - 1; k >= 0; --k) t1.push_back(V[i][k]);
          pair<int, int> tmp1 = Get_chain(t1, X[i], flag ^ 1);
          if (tmp1.first > 2 * n) continue;
          if (j + 1 == V[i].size()) {
            B[tmp1.second][Y[i]][tmp1.first + 1]++;
          } else {
            if (V[i][j + 1] != Y[i]) continue;
            for (int k = j + 2; k < V[i].size(); ++k) t2.push_back(V[i][k]);
            pair<int, int> tmp2 = Get_chain(t2, Y[i], flag);
            if (tmp1.first + tmp2.first + 1 <= 2 * n)
              A[tmp1.second][tmp2.second][tmp1.first + tmp2.first + 1]++;
          }
        }
    }
}
void solve() {
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      for (int k = 1; k <= 2 * n; ++k) {
        Plus(f[k][j][0], trans[1][0][i][j][k]);
        Plus(f[k][j][1], trans[1][1][i][j][k]);
      }
  for (int k = 1; k <= 2 * n; ++k) {
    int ans = 0;
    for (int i = 1; i <= n; ++i) {
      Plus(ans, f[k][i][1]);
      for (int j = 0; j <= 1; ++j)
        if (f[k][i][j]) {
          for (int v = 0; v <= 1; ++v) {
            for (int x = 1; x <= n; ++x)
              for (int len = 1; len <= 2 * n - k; ++len)
                if (trans[j ^ 1][v][i][x][len])
                  Plus(f[k + len][x][v],
                       1ll * f[k][i][j] * trans[j ^ 1][v][i][x][len] % mo);
          }
        }
    }
    printf("%d\n", ans);
  }
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d", &X[i], &Y[i]);
    E[X[i]][Y[i]] = i;
    int x, k;
    scanf("%d", &k);
    for (int j = 1; j <= k; ++j) {
      scanf("%d", &x);
      V[i].push_back(x);
    }
    if (!k) trans[0][0][X[i]][Y[i]][1]++;
    X[i + m] = Y[i];
    Y[i + m] = X[i];
    E[Y[i]][X[i]] = i + m;
    V[i + m] = V[i];
    reverse(V[i + m].begin(), V[i + m].end());
  }
  work(0);
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      for (int k = 1; k <= 2 * n; ++k) {
        trans[1][1][i][j][k] = A[i][j][k];
        trans[1][0][i][j][k] = B[i][j][k];
      }
  work(1);
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      for (int k = 1; k <= 2 * n; ++k) {
        assert(trans[1][1][j][i][k] == A[i][j][k]);
        trans[0][1][j][i][k] = B[i][j][k];
      }
  solve();
}
