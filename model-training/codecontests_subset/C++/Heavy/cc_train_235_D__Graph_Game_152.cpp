#include <bits/stdc++.h>
using namespace std;
int vis[3010];
vector<int> ne[3010];
int n, siz;
int du[3010];
queue<int> q;
double ans;
void dfs(int u, int siza, int sizb, int top) {
  if (du[u] == 2)
    sizb++;
  else
    siza++;
  vis[u] = top;
  if (sizb == siz)
    ans += 1.0 / (siza + 2);
  else if (sizb <= 2)
    ans += 1.0 / (siza + sizb);
  else
    ans += 1.0 / (siza + sizb) + 1.0 / (siza + siz - sizb + 2) -
           1.0 / (siza + siz);
  for (int v : ne[u])
    if (vis[v] != top) dfs(v, siza, sizb, top);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    x++, y++;
    ne[x].push_back(y);
    ne[y].push_back(x);
    du[x]++, du[y]++;
  }
  for (int i = 1; i <= n; i++)
    if (du[i] == 1) q.push(i);
  while (q.size()) {
    int u = q.front();
    q.pop();
    for (int v : ne[u])
      if ((--du[v]) == 1) q.push(v);
  }
  for (int i = 1; i <= n; i++)
    if (du[i] == 2) siz++;
  for (int i = 1; i <= n; i++) dfs(i, 0, 0, i);
  printf("%.10f\n", ans);
}
