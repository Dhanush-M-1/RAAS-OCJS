#include <bits/stdc++.h>
using namespace std;
const int N = 55, mod = 1e9 + 7;
void add(int &x, int y) {
  x += y;
  x = (x >= mod ? x - mod : x);
}
int cnt[N << 1][N][N][2][2], f[N << 1][N][2];
int n, q[N << 1], head, tail;
bool e[N][N];
vector<int> vec[N][N];
void solve0(int x, int y) {
  head = 1;
  tail = 0;
  for (int nd : vec[x][y]) q[++tail] = nd;
  while (head < tail) {
    int u = q[head], v = q[++head];
    if (!e[u][v] || tail + vec[u][v].size() > n + n + 1) return;
    for (int nd : vec[u][v]) q[++tail] = nd;
  }
  ++cnt[tail][x][q[tail]][0][1];
}
void solve1(int x, int y) {
  head = 1;
  tail = 0;
  for (int i = vec[x][y].size() - 1; i >= 0; --i) q[++tail] = vec[x][y][i];
  while (head < tail) {
    int u = q[head], v = q[++head];
    if (!e[v][u] || tail + vec[v][u].size() > n + n + 1) return;
    for (int i = vec[v][u].size() - 1; i >= 0; --i) q[++tail] = vec[v][u][i];
  }
  ++cnt[tail][q[tail]][y][1][0];
}
void solve(int x, int y, int pos) {
  head = 1;
  tail = 0;
  for (int i = pos - 1; i >= 0; --i) q[++tail] = vec[x][y][i];
  while (head < tail) {
    int u = q[head], v = q[++head];
    if (!e[v][u] || tail + vec[v][u].size() > n + n + 1) return;
    for (int i = vec[v][u].size() - 1; i >= 0; --i) q[++tail] = vec[v][u][i];
  }
  if (tail + vec[x][y].size() - pos > n + n + 1) return;
  reverse(q + 1, q + tail + 1);
  for (int i = pos; i < vec[x][y].size(); ++i) q[++tail] = vec[x][y][i];
  ++head;
  while (head < tail) {
    int u = q[head], v = q[++head];
    if (!e[u][v] || tail + vec[u][v].size() > n + n + 1) return;
    for (int nd : vec[u][v]) q[++tail] = nd;
  }
  ++cnt[tail - 1][q[1]][q[tail]][1][1];
}
void solve(int u, int v) {
  if (!e[u][v]) return;
  if (vec[u][v].size() > n + n + 1) return;
  if (vec[u][v].size() == 0) return (void)(++cnt[1][u][v][0][0]);
  if (vec[u][v].front() == v) solve0(u, v);
  if (vec[u][v].back() == u) solve1(u, v);
  for (int i = 1; i < vec[u][v].size(); ++i)
    if (vec[u][v][i - 1] == u && vec[u][v][i] == v) solve(u, v, i);
}
int ans[N << 1];
signed main() {
  int u, v, x, m, d;
  cin >> n >> m;
  for (int i = 1; i <= m; ++i) {
    cin >> u >> v >> x;
    e[u][v] = 1;
    for (int j = 0; j < x; ++j) cin >> d, vec[u][v].push_back(d);
  }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j) solve(i, j);
  for (int i = 1; i <= n; ++i) f[0][i][0] = 1;
  for (int i = 0; i <= n + n; ++i)
    for (int x = 1; x <= n; ++x) {
      add(ans[i], f[i][x][1]);
      for (int j = 0; i + j <= n + n; ++j)
        for (int y = 1; y <= n; ++y)
          for (int u = 0; u < 2; ++u)
            for (int v = 0; v < 2; ++v)
              add(f[i + j][y][v],
                  1ll * f[i][x][u] * cnt[j][x][y][u ^ 1][v] % mod);
    }
  for (int i = 1; i <= n + n; ++i) cout << ans[i] << endl;
  return 0;
}
