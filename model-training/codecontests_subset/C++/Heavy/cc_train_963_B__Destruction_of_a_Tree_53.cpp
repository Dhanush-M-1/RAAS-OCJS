#include <bits/stdc++.h>
int B = 400;
using namespace std;
const long long inf = 1e12;
int MOD = 1e9 + 9;
const int mxn = 200010;
int deg[mxn];
bool del[mxn];
vector<int> ans;
vector<int> g[mxn];
void dell(int v, int p) {
  if (del[v] != 0) return;
  if (deg[v] % 2 != 0) return;
  del[v] = 1;
  ans.push_back(v);
  for (int u : g[v]) deg[u]--;
  for (int u : g[v]) {
    if (!del[u] && u != p) dell(u, v);
  }
}
void dfs(int v, int p) {
  for (int u : g[v]) {
    if (u != p) dfs(u, v);
  }
  if (deg[v] % 2 == 0) dell(v, p);
}
long long res = 0;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int a;
    cin >> a;
    if (!a) continue;
    g[i].push_back(a);
    g[a].push_back(i);
    deg[a]++, deg[i]++;
  }
  dfs(1, -1);
  if (ans.size() == n) {
    cout << "YES" << endl;
    for (int u : ans) cout << u << endl;
  } else
    cout << "NO" << endl;
}
