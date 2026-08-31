#include <bits/stdc++.h>
const int MOD = (int)1e9 + 7;
const int N = 100000 + 5;
const int LOG = 18;
int inv(int x) {
  if (x == 0) return 0;
  return x == 1 ? 1 : (long long)(MOD - MOD / x) * inv(MOD % x) % MOD;
}
struct mod_int {
  int x;
  mod_int(int x_ = 0) : x(x_) {}
  mod_int operator+(const mod_int &t) const {
    mod_int ret(x + t.x);
    if (ret.x >= MOD) ret.x -= MOD;
    return ret;
  }
  mod_int operator-(const mod_int &t) const {
    mod_int ret(x - t.x);
    if (ret.x < 0) ret.x += MOD;
    return ret;
  }
  mod_int operator*(const mod_int &t) const {
    return mod_int((long long)x * t.x % MOD);
  }
  mod_int operator/(const mod_int &t) const {
    return mod_int((long long)x * inv(t.x) % MOD);
  }
  mod_int operator+(int x) { return *this + mod_int(x); }
  mod_int operator-(int x) { return *this - mod_int(x); }
  mod_int operator*(int x) { return *this * mod_int(x); }
  mod_int operator/(int x) { return *this / mod_int(x); }
};
mod_int A[N], B[N];
mod_int downA[N], downB[N];
mod_int sz[N];
std::vector<std::pair<int, int> > edges[N];
std::vector<std::pair<int, int> > queries[N];
int answer[N], n, m;
bool is_ancestor[N];
mod_int dis[N];
int depth[N], plca[LOG][N];
void prepare(int u, int fa) {
  if (fa != -1) depth[u] = depth[fa] + 1;
  plca[0][u] = fa;
  for (int i = 1; i < LOG; ++i) {
    plca[i][u] = -1;
    if (plca[i - 1][u] != -1) plca[i][u] = plca[i - 1][plca[i - 1][u]];
  }
  sz[u] = mod_int(1);
  for (std::pair<int, int> t : edges[u]) {
    int v = t.first;
    int w = t.second;
    if (v == fa) continue;
    dis[v] = dis[u] + w;
    prepare(v, u);
    sz[u] = sz[u] + sz[v];
    A[u] = A[u] + A[v] + B[v] * 2 * w + sz[v] * w * w;
    B[u] = B[u] + B[v] + sz[v] * w;
  }
}
int jump(int u, int d) {
  for (int i = 0; i < LOG; ++i)
    if (d >> i & 1) u = plca[i][u];
  return u;
}
int lca(int a, int b) {
  if (depth[a] < depth[b]) std::swap(a, b);
  a = jump(a, depth[a] - depth[b]);
  if (a == b) return a;
  for (int i = LOG - 1; i >= 0; --i) {
    if (plca[i][a] != plca[i][b]) {
      a = plca[i][a];
      b = plca[i][b];
    }
  }
  return plca[0][a];
}
mod_int get_dis(int a, int b) { return dis[a] + dis[b] - dis[lca(a, b)] * 2; }
void solve(int u, int fa) {
  is_ancestor[u] = true;
  for (std::pair<int, int> t : edges[u]) {
    int v = t.first;
    int w = t.second;
    if (v == fa) continue;
    mod_int a, b;
    a = A[v] + B[v] * 2 * w + sz[v] * w * w;
    b = B[v] + sz[v] * w;
    downA[v] = downA[u] + A[u] - a;
    downB[v] = downB[u] + B[u] - b;
    downA[v] = downA[v] + downB[v] * 2 * w + (sz[0] - sz[v]) * w * w;
    downB[v] = downB[v] + (sz[0] - sz[v]) * w;
    solve(v, u);
  }
  for (std::pair<int, int> t : queries[u]) {
    int v = t.first;
    int id = t.second;
    if (!is_ancestor[v]) {
      mod_int a = A[v];
      mod_int b = B[v];
      mod_int w = get_dis(u, v);
      a = a + b * 2 * w + sz[v] * w * w;
      b = b + sz[v] * w;
      answer[id] = (a - (downA[u] + A[u] - a)).x;
    } else if (u != v) {
      mod_int a = downA[v];
      mod_int b = downB[v];
      mod_int w = get_dis(u, v);
      a = a + b * 2 * w + (sz[0] - sz[v]) * w * w;
      b = b + (sz[0] - sz[v]) * w;
      answer[id] = (downA[u] + A[u] - a * 2).x;
    } else {
      answer[id] = (A[u] - downA[u]).x;
    }
  }
  is_ancestor[u] = false;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n - 1; ++i) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    a--;
    b--;
    edges[a].push_back(std::make_pair(b, c));
    edges[b].push_back(std::make_pair(a, c));
  }
  prepare(0, -1);
  scanf("%d", &m);
  for (int i = 0; i < m; ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    a--;
    b--;
    queries[a].push_back(std::make_pair(b, i));
  }
  solve(0, -1);
  for (int i = 0; i < m; ++i) {
    printf("%d\n", answer[i]);
  }
  return 0;
}
