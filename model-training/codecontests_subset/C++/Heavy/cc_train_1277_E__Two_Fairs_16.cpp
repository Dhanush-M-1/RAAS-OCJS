#include <bits/stdc++.h>
int dr[] = {2, 2, -2, -2, 1, -1, 1, -1};
int dc[] = {1, -1, 1, -1, 2, 2, -2, -2};
int dr1[] = {0, 0, 0, 1, 1, 1, -1, -1, -1};
int dc1[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
int dr2[] = {0, 0, 1, -1};
int dc2[] = {1, -1, 0, 0};
using namespace std;
vector<long long int> adj[300005];
long long int mark[300005], cnt;
void dfs(long long int u) {
  mark[u] = 1;
  cnt++;
  for (long long int i = 0; i < adj[u].size(); i++) {
    long long int p = adj[u][i];
    if (mark[p]) continue;
    dfs(p);
  }
}
int main() {
  long long int tc, n, m, x, y, i, j, a, b;
  cin >> tc;
  while (tc--) {
    cin >> n >> m >> a >> b;
    for (i = 1; i <= m; i++) {
      cin >> x >> y;
      adj[x].push_back(y);
      adj[y].push_back(x);
    }
    for (i = 1; i <= n; i++) mark[i] = 0;
    mark[b] = 1;
    cnt = 0;
    dfs(a);
    long long int xa = n - cnt - 1;
    for (i = 1; i <= n; i++) mark[i] = 0;
    mark[a] = 1;
    cnt = 0;
    dfs(b);
    long long int xb = n - cnt - 1;
    cout << xa * xb << endl;
    for (i = 1; i <= n; i++) adj[i].clear();
  }
  return 0;
}
