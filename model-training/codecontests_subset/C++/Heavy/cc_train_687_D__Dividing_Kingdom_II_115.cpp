#include <bits/stdc++.h>
using namespace std;
pair<int, int> edge[1000000];
pair<int, int> vert[1000000];
int parity[1001];
int par[1001];
vector<int> group[1001];
int m;
void merge(int u, int v) {
  int x = parity[u] == parity[v];
  u = par[u];
  v = par[v];
  if (group[u].size() < group[v].size()) swap(u, v);
  while (!group[v].empty()) {
    int cur = group[v].back();
    group[v].pop_back();
    par[cur] = u;
    parity[cur] ^= x;
    group[u].push_back(cur);
  }
}
int solve(int l, int r) {
  for (int i = m - 1; i >= 0; i--) {
    int j = edge[i].second;
    if (j > r || j < l) continue;
    int u = vert[j].first;
    int v = vert[j].second;
    if (par[u] == par[v]) {
      if (parity[u] == parity[v]) return edge[i].first;
      continue;
    }
    merge(u, v);
  }
  return -1;
}
int main(int argc, char const *argv[]) {
  int n, q;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; i++) {
    int u, v, w;
    scanf("%d%d%d", &u, &v, &w);
    edge[i] = make_pair(w, i);
    vert[i] = make_pair(u, v);
  }
  sort(edge, edge + m);
  while (q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    l--;
    r--;
    for (int i = 1; i <= n; i++) {
      parity[i] = -1;
      par[i] = i;
      group[i].clear();
      group[i].push_back(i);
    }
    int ans = solve(l, r);
    printf("%d\n", ans);
  }
  return 0;
}
