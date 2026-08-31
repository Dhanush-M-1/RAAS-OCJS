#include <bits/stdc++.h>
using namespace std;
const int N = int(2e5) + 5;
const int inf = (int)1e9 + 7;
int n, m;
vector<pair<int, int> > g[N];
int ban[N];
int dfs(int v) {
  vector<int> to;
  for (pair<int, int> i : g[v]) {
    if (ban[i.second]) {
      continue;
    }
    ban[i.second] = 1;
    to.push_back(i.first);
  }
  vector<int> all;
  for (int i : to) {
    int w = dfs(i);
    if (w == 0) {
      all.push_back(i);
    } else {
      printf("%d %d %d\n", w, i, v);
    }
  }
  while ((int)all.size() >= 2) {
    printf("%d %d %d\n", all.back(), v, all[(int)all.size() - 2]);
    all.pop_back(), all.pop_back();
  }
  return all.empty() ? 0 : all.back();
}
int main() {
  scanf("%d %d", &n, &m);
  if (m & 1) {
    printf("No solution");
    return 0;
  }
  for (int i = 1; i <= m; ++i) {
    int x, y;
    scanf("%d %d", &x, &y);
    g[x].push_back({y, i});
    g[y].push_back({x, i});
  }
  dfs(1);
  return 0;
}
