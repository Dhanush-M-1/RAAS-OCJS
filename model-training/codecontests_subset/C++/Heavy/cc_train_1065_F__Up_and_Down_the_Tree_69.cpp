#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
vector<int> gfo[N];
int p[N], here[N];
bool vst[N];
int find(int u) {
  if (u == p[u]) return u;
  return p[u] = find(p[u]);
}
void uni(int u, int v) {
  int pu = find(u);
  int pv = find(v);
  p[pv] = pu;
}
void up(int u, int k) {
  while (k && p[u] == u) {
    uni(here[u], u);
    u = here[u];
    k--;
    if (u == 0) break;
  }
}
int dfs(int u) {
  int ans = 0;
  for (int v : gfo[u]) ans = max(ans, dfs(v));
  return ans + here[u];
}
int main() {
  int n;
  scanf("%d", &n);
  int k;
  scanf("%d", &k);
  for (int i = int(1); i < int(n); ++i) {
    int pa;
    scanf("%d", &pa);
    pa--;
    gfo[pa].push_back(i);
    here[i] = pa;
  }
  vector<int> leafs;
  queue<int> q;
  q.push(0);
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (int v : gfo[u]) {
      if (int(gfo[v].size()) == 0) leafs.push_back(v);
      q.push(v);
    }
  }
  for (int i = int(0); i < int(n); ++i) p[i] = i;
  for (int u : leafs) up(u, k);
  for (int i = int(0); i < int(n); ++i) find(i);
  memset(here, 0, sizeof(here));
  for (int i = int(0); i < int(n); ++i)
    if (int(gfo[i].size()) == 0) here[p[i]]++;
  printf("%d\n", dfs(0));
  return 0;
}
