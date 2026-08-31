#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
int n, k, fa[N], dep[N], Min[N];
vector<int> e[N];
void dfs(int x) {
  Min[x] = (e[x].empty() ? 0 : 1e9);
  for (int v : e[x]) {
    dep[v] = dep[x] + 1;
    dfs(v);
    Min[x] = min(Min[x], Min[v] + 1);
  }
}
bool vis[N];
int calc(int x, int res, vector<int> &a) {
  if (Min[x] > res) return 0;
  vis[x] = 1;
  a.push_back(x);
  int ans = (Min[x] == 0);
  for (int v : e[x]) ans += calc(v, k - 1, a);
  return ans;
}
int solve(int x) {
  vector<int> a;
  int ans = calc(x, k, a), Max = 0;
  if (Min[x] > k) a.push_back(x);
  for (int u : a)
    for (int v : e[u])
      if (!vis[v]) Max = max(Max, solve(v));
  return ans + Max;
}
int main() {
  scanf("%d%d", &n, &k);
  if (n == 1) return puts("0"), 0;
  for (int i = 2; i <= n; ++i) {
    scanf("%d", &fa[i]);
    e[fa[i]].push_back(i);
  }
  dfs(1);
  printf("%d\n", solve(1));
  return 0;
}
