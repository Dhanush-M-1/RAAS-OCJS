#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:1000000000")
using namespace std;
const bool db = false;
vector<int> gr[3010];
double res;
int mark[3010], color;
int ds[3010], ds2[3010];
int deg[3010], n, m;
int Len;
void dfs(int v) {
  mark[v] = 1;
  for (int i = 0, sz = gr[v].size(); i < sz; ++i) {
    int to = gr[v][i];
    if (mark[to]) continue;
    ds2[to] = ds2[v] + 1;
    if (ds[to] == 0) {
      ds[to] = ds[v] + 1;
      res += 1.0 / ds[to];
    } else {
      res += 1.0 / ds2[to];
      res -= 1.0 / ((ds[to] + ds2[to] + Len) / 2 - 1);
    }
    dfs(to);
  }
  mark[v] = 0;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    int x, y;
    scanf("%d%d", &x, &y);
    x += 1;
    y += 1;
    gr[x].push_back(y);
    gr[y].push_back(x);
    ++deg[x];
    ++deg[y];
  }
  queue<int> q;
  for (int i = 1; i <= n; ++i)
    if (deg[i] == 1) q.push(i);
  Len = n;
  res = n;
  while (!q.empty()) {
    int v = q.front();
    q.pop();
    for (int i = 0, sz = gr[v].size(); i < sz; ++i) {
      int to = gr[v][i];
      if (--deg[to] == 1) q.push(to);
    }
    Len -= 1;
  }
  for (int i = 1; i <= n; ++i) {
    memset(ds, 0, sizeof(ds));
    memset(ds2, 0, sizeof(ds2));
    ds[i] = ds2[i] = 1;
    dfs(i);
  }
  cout.precision(9);
  cout << fixed << res << "\n";
  getchar();
  getchar();
  return 0;
}
