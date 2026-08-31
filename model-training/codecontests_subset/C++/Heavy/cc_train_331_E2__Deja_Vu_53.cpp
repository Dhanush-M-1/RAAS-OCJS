#include <bits/stdc++.h>
using namespace std;
const int N = 50, mod = 1000000007;
int add(int a, int b, int p = mod) { return a + b >= p ? a + b - p : a + b; }
int sub(int a, int b, int p = mod) { return a - b < 0 ? a - b + p : a - b; }
int mul(int a, int b, int p = mod) { return 1LL * a * b % p; }
void sadd(int &a, int b, int p = mod) { a = add(a, b, p); }
void ssub(int &a, int b, int p = mod) { a = sub(a, b, p); }
void smul(int &a, int b, int p = mod) { a = mul(a, b, p); }
int n, m, e[N + 9][N + 9];
vector<int> str[N + 9][N + 9];
void into() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; ++i) {
    int x, y, c;
    scanf("%d%d%d", &x, &y, &c);
    e[x][y] = 1;
    for (int j = 0; j < c; ++j) {
      int k;
      scanf("%d", &k);
      str[x][y].push_back(k);
    }
  }
}
int cnt[N * 2 + 9][N + 9][N + 9][2][2];
int q[N * 2 + 9], hd, tl;
void Get_cnt0(int x, int y) {
  hd = 1;
  tl = 0;
  for (int vs = str[x][y].size(), i = 0; i < vs; ++i) q[++tl] = str[x][y][i];
  for (; hd < tl;) {
    int u = q[hd], v = q[++hd];
    if (!e[u][v]) return;
    if (tl + str[u][v].size() > n * 2 + 1) return;
    for (int vs = str[u][v].size(), i = 0; i < vs; ++i) q[++tl] = str[u][v][i];
  }
  ++cnt[tl][x][q[tl]][0][1];
}
void Get_cnt1(int x, int y) {
  hd = 1;
  tl = 0;
  for (int vs = str[x][y].size(), i = vs - 1; i >= 0; --i)
    q[++tl] = str[x][y][i];
  for (; hd < tl;) {
    int v = q[hd], u = q[++hd];
    if (!e[u][v]) return;
    if (tl + str[u][v].size() > n * 2 + 1) return;
    for (int vs = str[u][v].size(), i = vs - 1; i >= 0; --i)
      q[++tl] = str[u][v][i];
  }
  ++cnt[tl][q[tl]][y][1][0];
}
void Get_cnt(int x, int y, int p) {
  hd = 1;
  tl = 0;
  for (int vs = str[x][y].size(), i = p - 1; i >= 0; --i)
    q[++tl] = str[x][y][i];
  for (; hd < tl;) {
    int v = q[hd], u = q[++hd];
    if (!e[u][v]) return;
    if (tl + str[u][v].size() > n * 2 + 1) return;
    for (int vs = str[u][v].size(), i = vs - 1; i >= 0; --i)
      q[++tl] = str[u][v][i];
  }
  reverse(q + 1, q + tl + 1);
  if (tl + str[x][y].size() - p > n * 2 + 1) return;
  for (int vs = str[x][y].size(), i = p; i < vs; ++i) q[++tl] = str[x][y][i];
  for (++hd; hd < tl;) {
    int u = q[hd], v = q[++hd];
    if (!e[u][v]) return;
    if (tl + str[u][v].size() > n * 2 + 1) return;
    for (int vs = str[u][v].size(), i = 0; i < vs; ++i) q[++tl] = str[u][v][i];
  }
  ++cnt[tl - 1][q[1]][q[tl]][1][1];
}
void Get_cnt(int x, int y) {
  if (!e[x][y]) return;
  if (str[x][y].size() > n * 2 + 1) return;
  if (str[x][y].empty()) {
    cnt[1][x][y][0][0] = 1;
    return;
  }
  if (str[x][y][0] == y) Get_cnt0(x, y);
  if (str[x][y].back() == x) Get_cnt1(x, y);
  for (int vs = str[x][y].size(), i = 1; i < vs; ++i)
    if (str[x][y][i - 1] == x && str[x][y][i] == y) Get_cnt(x, y, i);
}
void Get_cnt() {
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j) {
      Get_cnt(i, j);
    }
}
int dp[N * 2 + 9][N + 9][2], ans[N * 2 + 9];
void Get_dp() {
  for (int i = 1; i <= n; ++i) dp[0][i][0] = 1;
  for (int i = 0; i <= n << 1; ++i)
    for (int x = 1; x <= n; ++x) {
      sadd(ans[i], dp[i][x][1]);
      for (int j = 1; i + j <= n << 1; ++j)
        for (int y = 1; y <= n; ++y)
          for (int u = 0; u < 2; ++u)
            for (int v = 0; v < 2; ++v)
              sadd(dp[i + j][y][v], mul(dp[i][x][u], cnt[j][x][y][u ^ 1][v]));
    }
}
void work() {
  Get_cnt();
  Get_dp();
}
void outo() {
  for (int i = 1; i <= n << 1; ++i) printf("%d\n", ans[i]);
}
int main() {
  into();
  work();
  outo();
  return 0;
}
