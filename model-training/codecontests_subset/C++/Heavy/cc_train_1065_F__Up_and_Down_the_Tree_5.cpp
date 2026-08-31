#include <bits/stdc++.h>
using namespace std;
const int N = 1000010;
int h[N], n, k;
vector<int> g[N];
pair<int, int> f[N];
void dfs(int p) {
  if (!g[p].size()) {
    f[p] = make_pair(k, 1);
    h[p] = 1;
  }
  for (auto i : g[p]) {
    dfs(i);
    if (f[i].first)
      f[p].first = max(f[p].first, f[i].first - 1), f[p].second += f[i].second;
  }
  for (auto i : g[p])
    if (f[i].first)
      h[p] = max(h[p], f[p].second - f[i].second + h[i]);
    else
      h[p] = max(h[p], f[p].second + h[i]);
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n - 1; i++) {
    int x;
    scanf("%d", &x);
    g[x].push_back(i + 1);
  }
  dfs(1);
  printf("%d\n", max(f[1].second, h[1]));
  return 0;
}
