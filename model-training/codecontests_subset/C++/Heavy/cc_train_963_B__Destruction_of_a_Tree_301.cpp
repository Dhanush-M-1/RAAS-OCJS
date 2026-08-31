#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int to, ne;
} edge[200010 << 1];
int ne[200010], tot, rt;
bool flag[200010];
vector<int> ans;
void add(int u, int v) {
  edge[tot] = {v, ne[u]};
  ne[u] = tot++;
}
void collect(int u, int fa) {
  ans.push_back(u);
  flag[u] = true;
  for (int i = ne[u]; ~i; i = edge[i].ne) {
    int v = edge[i].to;
    if (v == fa || flag[v]) continue;
    collect(v, u);
  }
}
int dfs(int u, int fa) {
  int tot = 0;
  for (int i = ne[u]; ~i; i = edge[i].ne) {
    int v = edge[i].to;
    if (v == fa) continue;
    tot += dfs(v, u);
  }
  if ((u == rt && !(tot & 1)) || (u != rt && tot & 1)) collect(u, fa);
  return !(tot & 1);
}
int main() {
  memset(ne, -1, sizeof ne);
  int n, x;
  scanf("%d", &n);
  for (int i = (1); i <= (n); ++i) {
    scanf("%d", &x);
    if (!x)
      rt = i;
    else
      add(i, x), add(x, i);
  }
  if (dfs(rt, -1)) {
    puts("YES");
    for (auto x : ans) printf("%d\n", x);
  } else
    puts("NO");
  return 0;
}
