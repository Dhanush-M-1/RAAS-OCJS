#include <bits/stdc++.h>
using namespace std;
int n, m, dep[5000], id[5000], cnt, sum, acc[5000], lca[3020][3020], f[5000];
int dfn[5000], low[5000], ist[5000], belong[5000], tot[5000], maxid;
double Ans;
stack<int> a;
vector<int> v[5000];
inline void tarjan(int x, int fa) {
  dfn[x] = low[x] = ++cnt;
  a.push(x);
  ist[x] = 1;
  for (int i = 0; i < v[x].size(); i++)
    if (v[x][i] != fa) {
      if (!dfn[v[x][i]]) {
        tarjan(v[x][i], x);
        low[x] = min(low[x], low[v[x][i]]);
      } else if (ist[v[x][i]]) {
        low[x] = min(low[x], dfn[v[x][i]]);
      }
    }
  if (low[x] == dfn[x]) {
    sum++;
    while (1) {
      int u = a.top();
      a.pop();
      ist[u] = 0;
      belong[u] = sum;
      tot[sum]++;
      if (u == x) break;
    }
  }
}
inline int sf(int x) { return f[x] == x ? x : f[x] = sf(f[x]); }
inline void work(int x, int ac, int fa) {
  acc[x] = ac;
  f[x] = x;
  for (int i = 0; i < v[x].size(); i++)
    if (v[x][i] != fa && tot[belong[v[x][i]]] == 1) {
      dep[v[x][i]] = dep[x] + 1;
      work(v[x][i], ac, x);
      if (sf(v[x][i]) != sf(x)) f[sf(v[x][i])] = sf(x);
    }
  for (int i = 1; i <= n; i++)
    if (acc[i] == ac) lca[x][i] = lca[i][x] = sf(i);
}
inline void dfs(int x, int fa) {
  id[x] = id[fa] + 1, dep[x] = 1, acc[x] = x;
  work(x, x, x);
  for (int i = 0; i < v[x].size(); i++)
    if (v[x][i] != fa && !id[v[x][i]]) {
      if (tot[belong[v[x][i]]] > 1) dfs(v[x][i], x);
    }
}
int main() {
  int i, j, k, x, y;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d%d", &x, &y);
    x++, y++;
    v[x].push_back(y);
    v[y].push_back(x);
  }
  for (i = 1; i <= n; i++)
    if (!dfn[i]) tarjan(i, 0);
  for (i = 1; i <= n; i++)
    if (tot[belong[i]] > 1) {
      id[i] = 1;
      maxid = tot[belong[i]];
      dfs(i, 0);
      break;
    }
  for (i = 1; i <= n; i++)
    for (j = 1; j <= n; j++) {
      if (acc[i] == acc[j])
        Ans += 1.0 / (dep[i] + dep[j] - 2 * dep[lca[i][j]] + 1);
      else {
        int x = dep[i] + dep[j], y = abs(id[acc[i]] - id[acc[j]]) - 1,
            z = maxid - y - 2;
        Ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
      }
    }
  printf("%0.7lf\n", Ans);
  return 0;
}
