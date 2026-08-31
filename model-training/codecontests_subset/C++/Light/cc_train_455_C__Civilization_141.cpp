#include <bits/stdc++.h>
using namespace std;
int n, m, q;
vector<vector<int> > v;
int sz[300000];
int clr[300000];
int atMx, curMx;
int find(int u) {
  if (u == clr[u]) return u;
  return clr[u] = find(clr[u]);
}
void dfs(int u, int P, int d) {
  if (d > curMx) {
    curMx = d;
    atMx = u;
  }
  for (int i = 0; i < v[u].size(); i++)
    if (v[u][i] != P) dfs(v[u][i], u, d + 1);
}
int main() {
  cin >> n >> m >> q;
  v.resize(n);
  memset(sz, -1, sizeof(sz));
  for (int i = 0; i < n; i++) clr[i] = i;
  for (int i = 0, a, b; i < m; i++) {
    scanf("%d%d", &a, &b);
    --a;
    --b;
    v[a].push_back(b);
    v[b].push_back(a);
    clr[find(a)] = find(b);
  }
  for (int i = 0; i < n; i++)
    if (sz[find(i)] == -1) {
      curMx = -1;
      dfs(find(i), -1, 0);
      curMx = -1;
      dfs(atMx, -1, 0);
      sz[find(i)] = curMx;
    }
  while (q--) {
    int ty, x, y;
    scanf("%d", &ty);
    if (ty == 2) {
      scanf("%d%d", &x, &y);
      --x;
      --y;
      x = find(x);
      y = find(y);
      if (x != y) {
        int tmp;
        tmp = (sz[x] + 1) / 2 + (sz[y] + 1) / 2 + 1;
        tmp = max(tmp, sz[x]);
        sz[y] = max(sz[y], tmp);
        clr[x] = y;
      }
    } else {
      scanf("%d", &x);
      --x;
      printf("%d\n", sz[find(x)]);
    }
  }
  return 0;
}
