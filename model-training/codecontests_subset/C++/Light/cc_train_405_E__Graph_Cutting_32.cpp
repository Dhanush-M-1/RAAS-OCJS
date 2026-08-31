#include <bits/stdc++.h>
using namespace std;
int mod = 100000000;
set<int> adj[100005];
int n, m;
int dfs(int node) {
  vector<int> lef;
  while (adj[node].size()) {
    int mm = *(adj[node].begin());
    adj[mm].erase(node);
    adj[node].erase(mm);
    int t = dfs(mm);
    if (t != -1) {
      printf("%d %d %d\n", node, mm, t);
    } else
      lef.push_back(mm);
  }
  for (int i = (lef.size() % 2); i < lef.size(); i += 2) {
    printf("%d %d %d\n", lef[i], node, lef[i + 1]);
  }
  if (lef.size() % 2)
    return lef[0];
  else
    return -1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int TESTS = 1;
  while (TESTS--) {
    scanf("%d %d", &n, &m);
    for (int i = 0; i < m; i++) {
      int a, b;
      scanf("%d %d", &a, &b);
      adj[a].insert(b);
      adj[b].insert(a);
    }
    if (m % 2 == 1)
      puts("No solution");
    else
      dfs(1);
  }
  return 0;
}
