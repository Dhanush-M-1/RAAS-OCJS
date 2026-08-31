#include <bits/stdc++.h>
const int maxn = 300005;
using namespace std;
int pre[maxn], dis[maxn], len[maxn];
vector<int> G[maxn];
void add(int u, int v) { G[u].push_back(v); }
int find(int x) { return x == pre[x] ? x : pre[x] = find(pre[x]); }
int S, ffa;
void dfs(int u, int fa) {
  pre[u] = ffa;
  dis[u] = dis[fa] + 1;
  if (dis[u] > dis[S]) S = u;
  for (auto x : G[u]) {
    if (x == fa) continue;
    dfs(x, u);
  }
}
void solve(int x) {
  ffa = x, S = 0;
  dfs(x, 0);
  dfs(S, 0);
  len[x] = dis[S] - 1;
}
int main() {
  int n, m, q;
  scanf("%d %d %d", &n, &m, &q);
  for (int i = 1; i <= n; i++) pre[i] = i;
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    add(u, v);
    add(v, u);
  }
  for (int i = 1; i <= n; i++) {
    if (!dis[i]) {
      solve(i);
    }
  }
  while (q--) {
    int op, u, v;
    scanf("%d", &op);
    if (op == 1) {
      scanf("%d", &u);
      printf("%d\n", len[find(u)]);
    } else {
      scanf("%d %d", &u, &v);
      int fx = find(u);
      int fy = find(v);
      if (fx == fy) continue;
      pre[fx] = fy;
      int ans =
          max(max(len[fx], len[fy]), (len[fx] + 1) / 2 + (len[fy] + 1) / 2 + 1);
      len[fy] = ans;
    }
  }
  return 0;
}
