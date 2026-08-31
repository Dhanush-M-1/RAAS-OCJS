#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 5;
set<int> adj[MAX];
int n, m;
int dfs(int source) {
  vector<int> unpaired;
  while (!adj[source].empty()) {
    int each = *adj[source].begin();
    adj[source].erase(each);
    adj[each].erase(source);
    int u = dfs(each);
    if (u == 0) {
      unpaired.push_back(each);
    } else {
      printf("%d %d %d\n", u, each, source);
    }
  }
  while (unpaired.size() >= 2) {
    int u = unpaired.back();
    unpaired.pop_back();
    int v = unpaired.back();
    unpaired.pop_back();
    printf("%d %d %d\n", u, source, v);
  }
  if (!unpaired.empty()) {
    return unpaired.back();
  }
  return 0;
}
int main() {
  scanf("%d %d", &n, &m);
  if (m & 1) {
    puts("No solution");
    return 0;
  }
  for (int i = int(0); i < int(m); i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    adj[u].insert(v);
    adj[v].insert(u);
  }
  dfs(1);
  return 0;
}
