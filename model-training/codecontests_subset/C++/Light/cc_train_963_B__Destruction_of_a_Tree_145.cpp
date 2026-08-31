#include <bits/stdc++.h>
using namespace std;
int read() {
  int a = 0, b = 1, c;
  while (((c = fgetc(stdin)) > '9' || c < '0') && c != '-')
    ;
  if (c == '-') b = -1, c = fgetc(stdin);
  while (c >= '0' && c <= '9') a = a * 10 + c - '0', c = fgetc(stdin);
  return a * b;
}
set<pair<int, int> > even;
vector<int> g[200005], ans;
int n, par[200005], d[200005], dep[200005], del[200005];
void dfs(int u) {
  dep[u] = dep[par[u]] + 1;
  for (int i = 0; i < ((int)(g[u]).size()); i++) {
    int v = g[u][i];
    if (v == par[u]) continue;
    dfs(v);
  }
}
int main() {
  n = read();
  for (int i = 1; i <= n; i++) {
    par[i] = read();
    if (!par[i]) continue;
    d[par[i]]++;
    d[i]++;
    g[par[i]].push_back(i);
    g[i].push_back(par[i]);
  }
  for (int i = 1; i <= n; i++)
    if (!par[i]) dfs(i);
  for (int i = 1; i <= n; i++)
    if (!(d[i] & 1)) even.insert(make_pair(dep[i], i));
  while (!even.empty()) {
    int u = even.rbegin()->second;
    even.erase(make_pair(dep[u], u));
    del[u] = 1;
    ans.push_back(u);
    for (int i = 0; i < ((int)(g[u]).size()); i++) {
      int v = g[u][i];
      if (del[v]) continue;
      if (!even.count(make_pair(dep[v], v)))
        even.insert(make_pair(dep[v], v));
      else
        even.erase(make_pair(dep[v], v));
    }
  }
  if (((int)(ans).size()) != n) {
    printf("NO\n");
  } else {
    printf("YES\n");
    for (int i = 0; i < n; i++) {
      printf("%d\n", ans[i]);
    }
  }
  return 0;
}
