#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)998244353;
const int MAXN = (int)2e5 + 3;
const int infint = (int)1e9 + 3;
const long long inf = (long long)1e18;
int n, m, M[MAXN], visited[MAXN], h[MAXN], t[MAXN];
vector<int> G[MAXN], topol;
void dfs(int u) {
  visited[u] = 1;
  for (auto v : G[u])
    if (!visited[v]) dfs(v);
  topol.push_back(u);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> h[i];
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    G[u].push_back(v);
  }
  for (int i = 1; i <= n; i++)
    if (!visited[i]) dfs(i);
  reverse(topol.begin(), topol.end());
  for (int i = n - 1; i >= 0; i--) {
    if (G[topol[i]].size() == 0)
      M[topol[i]] = 0;
    else {
      vector<int> cur;
      for (auto v : G[topol[i]]) cur.push_back(M[v]);
      sort(cur.begin(), cur.end());
      int ptr = 0;
      for (auto v : cur)
        if (v == ptr) ptr++;
      M[topol[i]] = ptr;
    }
  }
  for (int i = 1; i <= n; i++) t[M[i]] ^= h[i];
  int mika = -1;
  for (int i = 0; i < n; i++)
    if (t[i] > 0) mika = i;
  if (mika == -1) return cout << "LOSE\n", 0;
  cout << "WIN\n";
  int id = -1;
  for (int i = 1; i <= n; i++)
    if (M[i] == mika && (h[i] ^ t[mika]) < h[i]) id = i;
  h[id] ^= t[mika];
  memset(visited, 0, sizeof visited);
  for (auto v : G[id])
    if (!visited[M[v]]) h[v] = h[v] ^ t[M[v]], visited[M[v]] = 1;
  for (int i = 1; i <= n; i++) cout << h[i] << " ";
}
