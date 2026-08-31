#include <bits/stdc++.h>
using namespace std;
int n, k, d[1000006], dd[1000006], l[1000006];
bool leaf[1000006], f[1000006];
vector<int> c[1000006];
void DFS(int u) {
  f[u] = true;
  for (int i = 0; i < c[u].size(); i++) {
    int v = c[u][i];
    if (f[v]) continue;
    l[v] = l[u] + 1;
    DFS(v);
  }
}
void get(int u) {
  if (leaf[u]) {
    d[u] = 1;
    return;
  }
  int m = l[u];
  l[u] = 1e9;
  f[u] = false;
  for (int i = 0; i < c[u].size(); i++) {
    int v = c[u][i];
    if (f[v])
      get(v);
    else
      continue;
    if (l[v] - m <= k)
      d[u] += d[v], dd[u] = max(dd[u], dd[v]);
    else
      dd[u] = max(dd[u], d[v] + dd[v]);
    l[u] = min(l[u], l[v]);
  }
  f[u] = true;
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) leaf[i] = true;
  for (int v = 2; v <= n; v++) {
    int u;
    scanf("%d", &u);
    c[u].push_back(v);
    c[v].push_back(u);
    leaf[u] = false;
  }
  l[1] = 1;
  DFS(1);
  get(1);
  printf("%d", d[1] + dd[1]);
  return 0;
}
