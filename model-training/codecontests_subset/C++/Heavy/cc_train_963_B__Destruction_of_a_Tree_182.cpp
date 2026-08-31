#include <bits/stdc++.h>
using namespace std;
vector<int> v[200001];
int deg[200001];
bool vis[200001];
void dfs(int s) {
  vis[s] = 1;
  deg[s] = 1;
  for (auto i : v[s]) {
    if (vis[i]) continue;
    dfs(i);
    deg[s] += deg[i];
  }
}
void solve(int s) {
  for (auto i : v[s])
    if (deg[i] % 2 == 0) solve(i);
  cout << s << '\n';
  for (auto i : v[s])
    if (deg[i] % 2 == 1) solve(i);
}
int main() {
  int n;
  cin >> n;
  if (n % 2 == 0) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  int rt;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x == 0)
      rt = i;
    else
      v[x].push_back(i);
  }
  dfs(rt);
  solve(rt);
  return 0;
}
