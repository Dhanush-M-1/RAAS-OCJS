#include <bits/stdc++.h>
using namespace std;
set<int> a[100005];
int dfs(int v) {
  vector<int> adj;
  for (auto it = a[v].begin(); it != a[v].end(); it++) {
    adj.push_back(*it);
    a[*it].erase(v);
  }
  a[v].clear();
  vector<int> unpaired;
  for (int i = 0; i < adj.size(); i++) {
    int u = adj[i];
    int w = dfs(u);
    if (w == 0)
      unpaired.push_back(u);
    else
      printf("%d %d %d\n", v, u, w);
  }
  adj.clear();
  int i = (int)unpaired.size() - 1;
  while (i >= 1) {
    int u = unpaired[i];
    int w = unpaired[i - 1];
    printf("%d %d %d\n", u, v, w);
    i -= 2;
  }
  if (i >= 0) {
    unpaired.clear();
    return unpaired[i];
  } else {
    unpaired.clear();
    return 0;
  }
}
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    a[x].insert(y);
    a[y].insert(x);
  }
  if (m % 2 == 0)
    dfs(1);
  else
    cout << "No solution" << endl;
}
