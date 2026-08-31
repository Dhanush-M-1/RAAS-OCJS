#include <bits/stdc++.h>
using namespace std;
const int N = 4 * 100007;
vector<int> adj[N];
int D[N], par[N], fa, mx;
int find_set(int x) { return par[x] == x ? x : par[x] = find_set(par[x]); }
void dfs(int v) {
  par[v] = fa;
  for (auto x : adj[v])
    if (!par[x]) {
      dfs(x);
      mx = max(mx, D[x] + D[v] + 1);
      D[v] = max(D[v], D[x] + 1);
    }
}
int main() {
  int n, m, q, a, b;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d", &a, &b);
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  for (int i = 1; i <= n; ++i)
    if (!par[i]) fa = i, mx = 0, dfs(i), D[i] = mx;
  for (int i = 0; i < q; ++i) {
    int x;
    scanf("%d%d", &x, &a);
    if (x == 1)
      printf("%d\n", D[find_set(a)]);
    else {
      scanf("%d", &b);
      a = find_set(a);
      b = find_set(b);
      if (a != b) {
        par[b] = a;
        D[a] = max((D[a] + 1) / 2 + (D[b] + 1) / 2 + 1, max(D[a], D[b]));
      }
    }
  }
}
