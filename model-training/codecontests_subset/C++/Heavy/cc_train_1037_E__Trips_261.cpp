#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
set<int> s, G[N];
int n, m, k;
int U[N], V[N], ans[N];
void check(int u) {
  if (G[u].size() < k && s.erase(u)) {
    for (auto v : G[u]) {
      G[v].erase(u);
      check(v);
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= n; i++) s.insert(i);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &U[i], &V[i]);
    G[U[i]].insert(V[i]);
    G[V[i]].insert(U[i]);
  }
  for (int i = 1; i <= n; i++) check(i);
  for (int i = m; i >= 1; --i) {
    ans[i] = s.size();
    G[U[i]].erase(V[i]);
    G[V[i]].erase(U[i]);
    check(U[i]);
    check(V[i]);
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
}
