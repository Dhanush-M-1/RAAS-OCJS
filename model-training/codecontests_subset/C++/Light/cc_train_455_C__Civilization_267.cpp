#include <bits/stdc++.h>
using namespace std;
int parent[300008], sz[300008], lpath[300008];
int n, m, q;
vector<int> v[300008];
void init() {
  for (int i = 0; i < 300008; i++) {
    parent[i] = i;
    sz[i] = 1;
    lpath[i] = 0;
  }
}
int find(int i) {
  if (i == parent[i]) return i;
  return parent[i] = find(parent[i]);
}
inline void Union(int x, int y) {
  int xpar = find(x);
  int ypar = find(y);
  if (xpar == ypar) return;
  if (sz[ypar] > sz[xpar]) swap(xpar, ypar);
  parent[ypar] = xpar;
  sz[xpar] += sz[ypar];
  lpath[xpar] = max((lpath[xpar] + 1) / 2 + (lpath[ypar] + 1) / 2 + 1,
                    max(lpath[xpar], lpath[ypar]));
}
int NN, DD, vis[300008];
void dfs(int u, int p, int d) {
  if (d >= DD) {
    NN = u;
    DD = d;
  }
  vis[u] = 1;
  for (int i = 0; i < v[u].size(); i++) {
    int x = v[u][i];
    if (x == p) continue;
    vis[x] = 1;
    dfs(x, u, d + 1);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  init();
  cin >> n >> m >> q;
  while (m--) {
    int a, b;
    cin >> a >> b;
    v[a].push_back(b);
    v[b].push_back(a);
    Union(a, b);
  }
  for (int i = 1; i <= n; i++)
    if (!vis[i]) {
      DD = 0;
      dfs(i, 0, 0);
      DD = 0;
      dfs(NN, 0, 0);
      lpath[find(i)] = DD;
    }
  while (q--) {
    int ty, a, b;
    cin >> ty;
    if (ty == 1) {
      cin >> a;
      cout << lpath[find(a)] << "\n";
    } else {
      cin >> a >> b;
      Union(a, b);
    }
  }
  return 0;
}
