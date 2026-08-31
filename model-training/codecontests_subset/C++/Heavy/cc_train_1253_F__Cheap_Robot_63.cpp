#include <bits/stdc++.h>
using namespace std;
struct state {
  long long len;
  int node;
  const bool operator<(const state oth) const { return len > oth.len; }
};
struct edge {
  int a, b;
  long long c;
} e[400005];
int n, m, k, q;
int dad[400005], up[20][400005], dep[400005];
long long mx[20][400005], d[400005];
vector<int> v[400005];
int find(int x) {
  if (x == dad[x]) return x;
  return dad[x] = find(dad[x]);
}
void merge(int x, int y) { dad[dad[x]] = dad[y]; }
void dfs(int node, int u) {
  dep[node] = dep[u] + 1;
  for (int i = 1; i < 20; i++) {
    mx[i][node] = max(mx[i - 1][node], mx[i - 1][up[i - 1][node]]);
    up[i][node] = up[i - 1][up[i - 1][node]];
  }
  for (int ed : v[node]) {
    int go = e[ed].a ^ e[ed].b ^ node;
    if (go == u) continue;
    mx[0][go] = e[ed].c;
    up[0][go] = node;
    dfs(go, node);
  }
}
long long query(int a, int b) {
  long long ans = -1;
  if (dep[a] > dep[b]) swap(a, b);
  for (int i = 20 - 1; i >= 0; i--) {
    if (dep[b] - (1 << i) >= dep[a]) {
      ans = max(ans, mx[i][b]);
      b = up[i][b];
    }
  }
  if (a == b) return ans;
  for (int i = 20 - 1; i >= 0; i--) {
    if (up[i][a] != up[i][b]) {
      ans = max(ans, max(mx[i][a], mx[i][b]));
      a = up[i][a];
      b = up[i][b];
    }
  }
  ans = max(ans, max(mx[0][a], mx[0][b]));
  return ans;
}
void build_tree() {
  for (int i = 1; i <= n; i++) {
    dad[i] = i;
    v[i].clear();
  }
  for (int i = 1; i <= m; i++) {
    e[i].c = d[e[i].a] + d[e[i].b] + e[i].c;
  }
  sort(e + 1, e + 1 + m, [](edge a, edge b) { return a.c < b.c; });
  for (int i = 1; i <= m; i++) {
    if (find(e[i].a) != find(e[i].b)) {
      merge(e[i].a, e[i].b);
      v[e[i].a].push_back(i);
      v[e[i].b].push_back(i);
    }
  }
  dfs(1, up[0][1]);
}
void msp() {
  memset(d, -1, sizeof(d));
  priority_queue<state> Q;
  for (int i = 1; i <= k; i++) Q.push({0, i});
  while (!Q.empty()) {
    state cur = Q.top();
    Q.pop();
    if (~d[cur.node]) continue;
    d[cur.node] = cur.len;
    for (int ed : v[cur.node]) {
      int go = e[ed].a ^ e[ed].b ^ cur.node;
      Q.push({cur.len + e[ed].c, go});
    }
  }
}
int main() {
  scanf("%d %d %d %d", &n, &m, &k, &q);
  for (int i = 1; i <= m; i++) {
    scanf("%d %d %lld", &e[i].a, &e[i].b, &e[i].c);
    v[e[i].a].push_back(i);
    v[e[i].b].push_back(i);
  }
  msp();
  build_tree();
  while (q--) {
    int x, y;
    scanf("%d %d", &x, &y);
    printf("%lld\n", query(x, y));
  }
}
