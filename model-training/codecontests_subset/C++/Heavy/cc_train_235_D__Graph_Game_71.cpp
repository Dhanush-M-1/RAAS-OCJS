#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
const int N = 3010;
vector<int> e[N], dis[N];
int q[N], n, u, v, t, d[N], vis[N], ct[N];
double ans;
void dfs(int u, int dep, int tc) {
  vis[u] = 1;
  ct[u] = tc;
  dis[u].push_back(dep);
  for (int j = 0; j < ((int)(e[u]).size()); j++)
    if (!vis[e[u][j]]) dfs(e[u][j], dep + 1, (d[e[u][j]] == 1) + tc);
  vis[u] = 0;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &u, &v);
    e[u].push_back(v);
    e[v].push_back(u);
  }
  for (int i = 0; i < n; i++) d[i] = ((int)(e[i]).size());
  for (int i = 0; i < n; i++)
    if (d[i] == 1) {
      vis[i] = 1;
      q[t++] = i;
    }
  for (int i = 0; i < t; i++)
    for (int j = 0; j < ((int)(e[q[i]]).size()); j++) {
      int v = e[q[i]][j];
      if (!vis[v] && (--d[v]) == 1) {
        q[t++] = v;
        vis[v] = 1;
      }
    }
  memset(vis, 0, sizeof(vis));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) dis[j].clear();
    dfs(i, 1, d[i] == 1);
    for (int j = 0; j < n; j++)
      if (((int)(dis[j]).size()) == 1)
        ans += 1. / dis[j][0];
      else
        ans += 1. / dis[j][0] + 1. / dis[j][1] -
               1. / (dis[j][0] + dis[j][1] - ct[j] - 2);
  }
  printf("%.10f\n", ans);
}
