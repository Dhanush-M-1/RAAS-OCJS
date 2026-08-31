#include <bits/stdc++.h>
using namespace std;
template <class T>
using p_que = priority_queue<T, vector<T>, greater<T>>;
constexpr int N = 112345, M = 18;
vector<pair<int, long long>> g[N];
p_que<pair<long long, pair<int, int>>> que;
int u[N];
long long d[N];
class UF {
 public:
  int p[N], d[N] = {};
  UF() { iota(p, p + N, 0); }
  int grp(int a) {
    auto &ret = p[a];
    if (ret != a) ret = grp(ret);
    return ret;
  }
  bool mrg(int a, int b) {
    a = grp(a), b = grp(b);
    if (a == b) return false;
    if (d[a] > d[b]) swap(a, b);
    p[a] = b;
    ((d[b]) = max((d[b]), (d[a] + 1)));
    return true;
  }
} uf;
class {
 public:
  vector<pair<int, long long>> g[N];
  void edge(int a, int b, long long p) {
    g[a].emplace_back(b, p);
    g[b].emplace_back(a, p);
  }
  int p[N][M] = {};
  int d[N];
  long long c[N][M];
  void build() {
    d[0] = 0;
    fill(c[0], c[0] + M, 0);
    dfs(0);
  }
  void dfs(int a) {
    for (auto &e : g[a]) {
      int b = e.first;
      if (b == p[a][0]) continue;
      p[b][0] = a;
      for (int i = (1); i < (M); i++) p[b][i] = p[p[b][i - 1]][i - 1];
      d[b] = d[a] + 1;
      c[b][0] = e.second;
      for (int i = (1); i < (M); i++)
        c[b][i] = max(c[b][i - 1], c[p[b][i - 1]][i - 1]);
      dfs(b);
    }
  }
  long long ans(int a, int b) {
    if (d[a] > d[b]) swap(a, b);
    ;
    long long ret = 0;
    ;
    for (int i = M - 1; i >= 0; i--) {
      if (d[a] <= (d[b] - (1 << i))) {
        ;
        ((ret) = max((ret), (c[b][i])));
        b = p[b][i];
      }
    };
    for (int i = M - 1; i >= 0; i--) {
      if (p[a][i] != p[b][i]) {
        ;
        ((ret) = max((ret), (c[a][i])));
        ((ret) = max((ret), (c[b][i])));
        a = p[a][i];
        b = p[b][i];
      }
    }
    if (a != b) {
      ;
      ((ret) = max((ret), (c[a][0])));
      ((ret) = max((ret), (c[b][0])));
    }
    return ret;
  }
} t;
int main() {
  int n, m, k, q;
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (int i = (0); i < ((m)); i++) {
    int u, v;
    long long w;
    scanf("%d%d%lld", &u, &v, &w);
    u--;
    v--;
    g[u].emplace_back(v, w);
    g[v].emplace_back(u, w);
  };
  fill(u, u + N, -1);
  for (int i = (0); i < ((k)); i++) que.emplace(0, make_pair(i, i));
  while (que.size()) {
    auto tp = que.top();
    que.pop();
    int i = tp.second.first;
    if (~u[i]) continue;
    u[i] = tp.second.second;
    d[i] = tp.first;
    ;
    for (auto &e : g[i]) {
      int j = e.first;
      que.emplace(d[i] + e.second, make_pair(j, u[i]));
    }
  };
  while (que.size()) que.pop();
  for (int i = (0); i < ((n)); i++)
    for (auto &e : g[i]) {
      int j = e.first;
      if (u[i] >= u[j]) continue;
      ;
      que.emplace(d[i] + d[j] + e.second, make_pair(u[i], u[j]));
    };
  while (que.size()) {
    auto tp = que.top();
    que.pop();
    int i = tp.second.first, j = tp.second.second;
    if (!uf.mrg(i, j)) continue;
    ;
    t.edge(i, j, tp.first);
  }
  t.build();
  for (int iq = (0); iq < ((q)); iq++) {
    int a, b;
    scanf("%d%d", &a, &b);
    a--;
    b--;
    printf("%lld\n", t.ans(a, b));
  }
}
