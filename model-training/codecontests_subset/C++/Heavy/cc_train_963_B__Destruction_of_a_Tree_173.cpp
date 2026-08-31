#include <bits/stdc++.h>
using namespace std;
vector<int> g[(int)3e5 + 500];
int del[(int)3e5 + 500];
void dfs1(int u) {
  int cnt = 0;
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    dfs1(v);
    if (!del[v]) cnt++;
  }
  if (cnt % 2 == 1) {
    cout << u << endl;
    del[u] = 1;
  }
}
void dfs2(int u) {
  if (!del[u]) cout << u << endl;
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    dfs2(v);
  }
}
int main() {
  int n;
  while (~scanf("%d", &n)) {
    int rt, u;
    for (int i = 1; i <= n; i++) {
      g[i].clear();
      del[i] = 0;
    }
    for (int i = 1; i <= n; i++) {
      scanf("%d", &u);
      if (u == 0)
        rt = i;
      else
        g[u].push_back(i);
    }
    if (n % 2 == 0)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      dfs1(rt);
      dfs2(rt);
    }
  }
  return 0;
}
