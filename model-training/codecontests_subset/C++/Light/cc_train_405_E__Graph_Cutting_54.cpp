#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 1;
vector<int> g[MAXN];
vector<int> reverse_idx[MAXN];
vector<bool> blocked[MAXN];
int partition(const int v) {
  vector<bool>::iterator is_blocked = blocked[v].begin();
  vector<int>::iterator reverse = reverse_idx[v].begin();
  int unpaired = false;
  for (int u : g[v]) {
    if (*is_blocked) {
      ++is_blocked;
      ++reverse;
      continue;
    }
    *is_blocked = true;
    blocked[u][*reverse] = true;
    int w = partition(u);
    if (w) {
      printf("%d %d %d\n", v, u, w);
    } else {
      if (unpaired) {
        printf("%d %d %d\n", unpaired, v, u);
        unpaired = false;
      } else {
        unpaired = u;
      }
    }
    ++is_blocked;
    ++reverse;
  }
  return unpaired;
}
int main() {
  int n, m;
  scanf("%d %d ", &n, &m);
  if (m % 2) {
    printf("No solution\n");
    return 0;
  }
  for (int i = 0; i < m; ++i) {
    int a, b;
    scanf("%d %d ", &a, &b);
    reverse_idx[a].push_back(g[b].size());
    reverse_idx[b].push_back(g[a].size());
    g[a].push_back(b);
    g[b].push_back(a);
  }
  for (int i = 1; i <= n; ++i) {
    blocked[i].resize(g[i].size(), false);
  }
  partition(1);
  return 0;
}
