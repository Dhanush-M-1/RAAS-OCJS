#include <bits/stdc++.h>
const int maxn = 2e5 + 10;
const int maxm = 2e5 + 10;
const int mod = 1e9 + 7;
const int inf = 0x3f3f3f3f;
const double eps = 1e-7;
using namespace std;
vector<int> G[maxn];
int rt = 1;
int n, p, sz[maxn];
void dfs(int u, int fa) {
  sz[u]++;
  for (auto v : G[u]) {
    if (v == fa) continue;
    dfs(v, u);
    sz[u] += sz[v];
  }
}
void dfs1(int u, int fa) {
  for (auto v : G[u]) {
    if (v == fa) continue;
    if (sz[v] % 2 == 0) dfs1(v, u);
  }
  cout << u << endl;
  for (auto v : G[u]) {
    if (v == fa) continue;
    if (sz[v] & 1) dfs1(v, u);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> p;
    if (p == 0)
      rt = i;
    else {
      G[i].push_back(p);
      G[p].push_back(i);
    }
  }
  if (n & 1) {
    cout << "YES" << endl;
    dfs(rt, 0);
    dfs1(rt, 0);
  } else
    cout << "NO";
  return ~~(0 - 0);
}
