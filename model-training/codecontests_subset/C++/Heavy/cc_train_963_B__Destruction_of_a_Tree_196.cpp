#include <bits/stdc++.h>
using namespace std;
const long long infl = 1e18 + 5;
long long n, m, k, q, x, y, f, val, t, i, j;
long long ind, cnt, sz, sm, ans, mx, mn;
long long a[1000004], vis[1000004];
vector<int> g[1000004];
void dfs1(int u, int p) {
  if (vis[u]) return;
  vis[u] = 1;
  cout << u << " ";
  for (auto it : g[u]) {
    if (it != p) dfs1(it, u);
  }
}
int dfs(int u, int p) {
  int re = 0;
  if (p != -1) re = 1;
  for (auto it : g[u]) {
    if (it != p) {
      re += dfs(it, u);
    }
  }
  if (re % 2 == 0) {
    dfs1(u, p);
    return 0;
  }
  return 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  if (fopen("inp.txt", "r")) {
    freopen("myfile.txt", "w", stdout);
    freopen("inp.txt", "r", stdin);
  }
  cin >> n;
  for (i = 1; i < n + 1; i++) {
    cin >> x;
    if (x == 0) {
      k = i;
      continue;
    }
    g[i].emplace_back(x);
    g[x].emplace_back(i);
  }
  if (n % 2 == 0)
    cout << "NO";
  else {
    cout << "YES\n";
    dfs(k, -1);
  }
  return 0;
}
