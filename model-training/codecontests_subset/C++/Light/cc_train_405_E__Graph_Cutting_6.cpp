#include <bits/stdc++.h>
using namespace std;
const int N = 1e5;
vector<int> g[N + 100];
vector<pair<pair<int, int>, int> > ans;
int vis[N + 100];
int dfs(int v, int par) {
  vis[v] = 1;
  vector<int> tmp;
  for (auto it : g[v]) {
    if (!vis[it]) {
      int f = dfs(it, v);
      if (f) {
        ans.push_back(make_pair(make_pair(v, it), f));
      } else {
        tmp.push_back(it);
      }
    } else {
      if (it != par && vis[it] == 1) tmp.push_back(it);
    }
  }
  int ret = 0;
  if ((int)tmp.size() % 2) {
    ret = tmp.back();
    tmp.pop_back();
  }
  for (int sz = tmp.size(), i = 0; i < sz; i += 2) {
    ans.push_back(make_pair(make_pair(tmp[i], v), tmp[i + 1]));
  }
  vis[v] = 2;
  return ret;
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    g[a].push_back(b);
    g[b].push_back(a);
  }
  if (m % 2) {
    printf("No solution\n");
  } else {
    dfs(1, 0);
    for (auto it : ans) {
      printf("%d %d %d\n", it.first.first, it.first.second, it.second);
    }
  }
}
