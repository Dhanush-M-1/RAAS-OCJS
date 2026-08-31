#include <bits/stdc++.h>
using namespace std;
double b[100005], a[100005];
vector<pair<int, long long int>> gr[100005];
void dfs(int u) {
  int v;
  for (auto vv : gr[u]) {
    v = vv.first;
    dfs(v);
    if (b[v] < a[v])
      b[u] -= (a[v] - b[v]) * vv.second;
    else
      b[u] += b[v] - a[v];
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int i, j, n, u;
  double k;
  cin >> n;
  for (i = 1; i <= n; i++) cin >> b[i];
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = 2; i <= n; i++) {
    cin >> u >> k;
    gr[u].push_back(make_pair(i, k));
  }
  dfs(1);
  cout << ((b[1] >= a[1]) ? "YES" : "NO");
  return 0;
}
