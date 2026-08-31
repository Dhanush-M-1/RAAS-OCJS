#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3fLL;
const double PI = acos(-1.0);
const double EPS = 1e-8;
const int MOD = 998244353;
template <typename T>
void cmin(T &x, T y) {
  if (y < x) x = y;
}
template <typename T>
void cmax(T &x, T y) {
  if (y > x) x = y;
}
long long qpow(long long x, long long n, long long mod = MOD) {
  long long res = 1;
  while (n) {
    if (n & 1) res = res * x % mod;
    x = x * x % mod;
    n >>= 1;
  }
  return res;
}
namespace Solver {
void InitOnce() {}
int n, m, k;
int u[200005];
int v[200005];
int deg[200005];
vector<pair<int, int> > G[200005];
void Read() {
  int res = scanf("%d%d%d", &n, &m, &k);
  if (res == -1) exit(0);
  for (int i = 1; i <= n; ++i) G[i].clear();
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d", &u[i], &v[i]);
    G[u[i]].emplace_back(v[i], i);
    G[v[i]].emplace_back(u[i], i);
  }
  for (int i = 1; i <= n; ++i) deg[i] = G[i].size();
}
bool vis[200005];
int ans[200005];
bool inQ[200005];
queue<int> Q;
void delEdge(int u, int v, int id) {
  if (vis[id]) return;
  vis[id] = 1;
  --deg[u];
  --deg[v];
  if (inQ[v] == 0 && deg[v] < k) {
    Q.push(v);
    inQ[v] = 1;
  }
}
void delEdge2(int u, int v, int id) {
  if (vis[id]) return;
  vis[id] = 1;
  --deg[u];
  --deg[v];
  if (inQ[u] == 0 && deg[u] < k) {
    Q.push(u);
    inQ[u] = 1;
  }
  if (inQ[v] == 0 && deg[v] < k) {
    Q.push(v);
    inQ[v] = 1;
  }
}
void Solve() {
  memset(vis, 0, sizeof(vis));
  memset(ans, 0, sizeof(ans));
  memset(inQ, 0, sizeof(inQ));
  for (int i = 1; i <= n; ++i) {
    if (deg[i] < k) {
      Q.push(i);
      inQ[i] = 1;
    }
  }
  int cur = n;
  while (!Q.empty()) {
    int u = Q.front();
    Q.pop();
    --cur;
    for (pair<int, int> &p : G[u]) {
      int v = p.first, id = p.second;
      delEdge(u, v, id);
    }
  }
  for (int i = 1; i <= n; ++i) {
    if (deg[i]) assert(deg[i] >= k);
  }
  ans[m] = cur;
  for (int i = m - 1; i >= 0; --i) {
    int de = i + 1;
    delEdge2(u[de], v[de], de);
    while (!Q.empty()) {
      int u = Q.front();
      Q.pop();
      --cur;
      for (pair<int, int> &p : G[u]) {
        int v = p.first, id = p.second;
        delEdge(u, v, id);
      }
    }
    ans[i] = cur;
  }
  for (int i = 1; i <= n; ++i) {
    assert(deg[i] == 0);
    assert(inQ[i] == 1);
  }
  for (int i = 1; i <= m; ++i) assert(vis[i] == 1);
  for (int i = 1; i <= m; ++i) printf("%d\n", ans[i]);
  return;
}
}  // namespace Solver
int main() {
  Solver::InitOnce();
  while (true) {
    Solver::Read();
    Solver::Solve();
  }
  return 0;
}
