#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000;
struct Ans {
  int u, v, w;
  Ans(int u = 0, int v = 0, int w = 0) : u(u), v(v), w(w) {}
};
int n, m;
vector<int> G[maxn + 5];
int vis[maxn + 5];
vector<Ans> ans;
int dfs(int u, int fa) {
  vis[u] = vis[fa] + 1;
  vector<int> P;
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i];
    if (vis[v]) {
      if (vis[u] < vis[v]) P.push_back(v);
      continue;
    }
    int temp = dfs(v, u);
    if (temp)
      ans.push_back(Ans(u, v, temp));
    else
      P.push_back(v);
  }
  int i;
  for (i = 0; i < (int)P.size() - 1; i += 2)
    ans.push_back(Ans(P[i], u, P[i + 1]));
  if (i == (int)P.size() - 1) return P[(int)P.size() - 1];
  return 0;
}
int main() {
  while (cin >> n >> m) {
    for (int i = 1; i <= n; i++) G[i].clear();
    for (int i = 0; i < m; i++) {
      int u, v;
      scanf("%d%d", &u, &v);
      G[u].push_back(v);
      G[v].push_back(u);
    }
    ans.clear();
    int rest = dfs(1, 0);
    if (rest)
      printf("No solution\n");
    else {
      for (int i = 0; i < ans.size(); i++)
        printf("%d %d %d\n", ans[i].u, ans[i].v, ans[i].w);
    }
  }
  return 0;
}
